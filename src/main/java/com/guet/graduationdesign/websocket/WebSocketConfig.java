package com.guet.graduationdesign.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
* @Description:    websocket配置类
* @Author:         TJX
* @CreateDate:     2019-05-15 18:53
* @UpdateUser:
* @UpdateDate:     2019-05-15 18:53
* @UpdateRemark:
* @Version:        1.0
*/
@Configuration
public class WebSocketConfig {

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
