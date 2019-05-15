package com.guet.graduationdesign.service.impl;

import com.guet.graduationdesign.enums.ResultEnum;
import com.guet.graduationdesign.exception.MyException;
import com.guet.graduationdesign.result.Result;
//import com.guet.graduationdesign.runner.Runner;
import com.guet.graduationdesign.service.QuotaService;
import com.guet.graduationdesign.service.SchedulerService;
import com.guet.graduationdesign.util.ResultUtil;
import com.guet.graduationdesign.websocket.WebSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ScheduledFuture;

/**
* @Description:    定时任务service
* @Author:         TJX
* @CreateDate:     2019-05-15 17:03
* @UpdateUser:
* @UpdateDate:     2019-05-15 17:03
* @UpdateRemark:
* @Version:        1.0
*/
@Service
public class SchedulerServiceImpl implements SchedulerService {

    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    @Autowired
    public QuotaService quotaService;

    private ScheduledFuture<?> future;

    @Override
    public Result start(Integer oldPeopleId)throws MyException {
        /**
        * @Description: 开启定时任务
        * @Author:      TJX
         * @param
        * @Return      java.lang.String
        * @Exception
        * @Date        2019-05-15 17:04
        */
        try {
            future = threadPoolTaskScheduler.schedule(new Runner(oldPeopleId), new Trigger() {
                @Override
                public Date nextExecutionTime(TriggerContext triggerContext) {
                    return new CronTrigger("0/2 * * * * ?").nextExecutionTime(triggerContext);
                }
            });
            return ResultUtil.success(ResultEnum.ADD_SUCCESS);
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.ADD_FAIL);
        }
    }

    @Override
    public Result stop()throws MyException {
        /**
        * @Description:  关闭定时任务
        * @Author:      TJX
         * @param
        * @Return      java.lang.String
        * @Exception
        * @Date        2019-05-15 17:12
        */
        try{
            if (future != null) {
                future.cancel(true);
            }
            return ResultUtil.success(ResultEnum.CLOSE_SUCCESS);
        }catch (Exception e)
        {
            throw new MyException(ResultEnum.CLOSE_FAIL);
        }
    }
    class Runner extends Thread {

        private Integer oldPeopleId;

        private Random random = new Random();

        public Runner(Integer oldPeopleId)
        {
            this.oldPeopleId = oldPeopleId;
        }
        @Override
        public void run()
        {
            String s1 = String.valueOf(random.nextInt(75 - 58 + 1) + 58);
            String s2 = String.valueOf(random.nextInt(75 - 58 + 1) + 58);
            String s3 = String.valueOf(random.nextFloat()*1.1f+37);
            quotaService.add(Integer.parseInt(s1),Integer.parseInt(s2),Float.parseFloat(s3),oldPeopleId);
            String s = s1+","+s2+","+s3;
            for(WebSocket webSocket:WebSocket.webSocketSet)
            {
                try {
                    webSocket.sendMessage(s,webSocket.getSession());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        return new ThreadPoolTaskScheduler();
    }
}
