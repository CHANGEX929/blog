package com.changex.blog.config;

import com.alibaba.fastjson.JSON;
import com.changex.blog.core.pojo.TBlogChat;
import com.changex.blog.service.TBlogChatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;


@Component
@Slf4j
public class MessageReserve {

    @Autowired
    private RedisClient redisClient;
    @Autowired
    private static CountDownLatch latch = new CountDownLatch(1);

    @Autowired
    private TBlogChatService tBlogChatService;

    public MessageReserve() {
    }


    public void message(String message) {
        log.info("-----------------------------开始----------------------");
        log.info("msgContent:" + message);
        TBlogChat tBlogChat = JSON.parseObject(message, TBlogChat.class);
        tBlogChat.setIsValid(1);
        Integer id = tBlogChatService.saveChat(tBlogChat);
        log.info("id" + id);
        latch.countDown();
    }

}
