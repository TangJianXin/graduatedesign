package com.guet.graduationdesign.runner;

import com.guet.graduationdesign.service.QuotaService;
import com.guet.graduationdesign.websocket.WebSocket;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Random;

/**
* @Description:    采集执行类
* @Author:         TJX
* @CreateDate:     2019-05-15 17:20
* @UpdateUser:
* @UpdateDate:     2019-05-15 17:20
* @UpdateRemark:
* @Version:        1.0
*/
public class Runner extends Thread {

    @Autowired
    private QuotaService quotaService;

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
