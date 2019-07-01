package com.changex.blog.controller.websocket;

import com.alibaba.fastjson.JSON;
import com.changex.blog.config.RedisClient;
import com.changex.blog.config.RedisConfig;
import com.changex.blog.controller.test.TestController;
import com.changex.blog.core.pojo.TBlogChat;
import com.changex.blog.core.pojo.dto.BlogChatDTO;
import com.changex.blog.tools.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
@ServerEndpoint("/websocket")
public class WebsocketController {

    private static RedisClient redisClient;

    private Session session;

    private static CopyOnWriteArraySet<WebsocketController> set = new CopyOnWriteArraySet<>();
    public WebsocketController() {}
    @Autowired
    public WebsocketController(RedisClient redisClient) {
        this.redisClient=redisClient;
    }


    //创建链接
    @OnOpen
    public void onOpen(Session session){
        this.session=session;
        set.add(this);
    }

    //关闭链接
    @OnClose
    public  void onClose(){
        set.remove(this);
    }

    @OnMessage
    public void onMessage(String message){
        System.out.println("websocket 收到消息:"+message);

        //send(message);
        sendAll(message);
        redisClient.convertAndSend("chat",message);
    }



    public void sendAll(String message){
        for (WebsocketController websocket: set) {
            websocket.session.getAsyncRemote().sendText(message);
        }
    }




}
