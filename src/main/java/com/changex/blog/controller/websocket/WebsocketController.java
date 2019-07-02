package com.changex.blog.controller.websocket;

import com.changex.blog.config.RedisClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
@Slf4j
@ServerEndpoint("/websocket")
public class WebsocketController {

    private static RedisClient redisClient;

    private Session session;

    private static CopyOnWriteArraySet<WebsocketController> set = new CopyOnWriteArraySet<>();

    public WebsocketController() {
    }

    @Autowired
    public WebsocketController(RedisClient redisClient) {
        WebsocketController.redisClient = redisClient;
    }


    //创建链接
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        set.add(this);
    }

    //关闭链接
    @OnClose
    public void onClose() {
        set.remove(this);
    }

    @OnMessage
    public void onMessage(String message) {
        log.info("websocket 收到消息:" + message);
        sendAll(message);
        redisClient.convertAndSend("chat", message);
    }


    public void sendAll(String message) {
        for (WebsocketController websocket : set) {
            websocket.session.getAsyncRemote().sendText(message);
        }
    }


}
