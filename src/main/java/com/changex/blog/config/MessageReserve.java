package com.changex.blog.config;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;

import com.alibaba.fastjson.JSON;
import com.changex.blog.controller.websocket.WebsocketController;
import com.changex.blog.core.pojo.TBlogChat;
import com.changex.blog.service.TBlogChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class MessageReserve {

    @Autowired
    private RedisClient                   redisClient;
    @Autowired
    private static   CountDownLatch latch = new CountDownLatch(1);

    @Autowired
    private TBlogChatService tBlogChatService;

    public MessageReserve(){}



    public void message(String message){
        System.out.println("-----------------------------开始----------------------");
        System.out.println("msgContent:" + message);
        TBlogChat tBlogChat = JSON.parseObject(message, TBlogChat.class);
        tBlogChat.setIsValid(1);
        tBlogChat.setCreateDate(LocalDateTime.now());
        Integer id = tBlogChatService.saveChat(tBlogChat);
        System.out.println("id"+id);

        latch.countDown();
    }

}
