package com.changex.blog.config;

import com.changex.blog.controller.websocket.WebsocketController;
import com.changex.blog.core.pojo.TSysUser;
import com.changex.blog.service.timer.ChatConsumer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Configuration
public class ChatConfig {
    @Resource
    private ValueOperations valueOperations;

    @Bean
    public ChatConsumer chatConsumer(WebsocketController websocketController, ListOperations listOperations){

        return new ChatConsumer(websocketController,listOperations,0);
    }

}
