package com.changex.blog.service.timer;

import com.alibaba.fastjson.JSON;
import com.changex.blog.controller.websocket.WebsocketController;
import com.changex.blog.core.pojo.TBlogChat;
import com.changex.blog.core.pojo.TSysUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ChatConsumer implements InitializingBean,DisposableBean {
    @Autowired
    private WebsocketController websocketController;

    @Resource
    private ValueOperations valueOperations;

    @Autowired
    private ListOperations listOperations;

    private RedisListener redisListener;

    private Boolean isShutdown;

    private Integer userId;


    public ChatConsumer(){}
    public ChatConsumer(WebsocketController websocketController, ListOperations listOperations,Integer userId){
        this.websocketController=websocketController;
        this.listOperations=listOperations;
        this.isShutdown = false;
        if(userId==null){
            this.userId=0;
        }else {
            this.userId=userId;
        }

    }

    public String getRedisList(){
        String chatMassage = (String) listOperations.leftPop("chat");
        return chatMassage;
    }

    class RedisListener extends Thread{
        @Override
        public void run(){
            while (!isShutdown){
                String chatMassage = getRedisList();
                if(StringUtils.isNotBlank(chatMassage)){
                    websocketController.sendAll(chatMassage);
                }




            }
        }

    }


    @Override
    public void destroy() throws Exception {
        System.out.println("销毁");
        this.isShutdown = true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
       /* this.redisListener = new RedisListener();
        this.redisListener.setDaemon(true);
        this.redisListener.start();*/
        System.out.println("thread start！！！");
    }
}
