package com.changex.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Component;

@Configuration("springRedis")
public class RedisListenerConfig {

    @Bean
    public RedisMessageListenerContainer  redisMessageListenerContainer(RedisConnectionFactory redisConnectionFactory, MessageListenerAdapter messageListenerAdapter){
        System.out.println("RedisMessageListenerContainer-、、、、、、、、、、、、、、、、、、、、、、、---------------");
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnectionFactory);
        container.addMessageListener(messageListenerAdapter, new PatternTopic("chat"));
        return container;
    }

    @Bean
    public MessageListenerAdapter messageListenerAdapter(MessageReserve reserve) {
        System.out.println("MessageListenerAdapter----------------");
        return new MessageListenerAdapter(reserve, "message");
    }

}
