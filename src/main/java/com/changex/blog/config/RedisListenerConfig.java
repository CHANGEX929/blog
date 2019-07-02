package com.changex.blog.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Component;

@Configuration("springRedis")
@Slf4j
public class RedisListenerConfig {

    @Bean
    public RedisMessageListenerContainer  redisMessageListenerContainer(RedisConnectionFactory redisConnectionFactory, MessageListenerAdapter messageListenerAdapter){
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnectionFactory);
        container.addMessageListener(messageListenerAdapter, new PatternTopic("chat"));
        log.info("RedisMessageListenerContainer-Started");
        return container;
    }

    @Bean
    public MessageListenerAdapter messageListenerAdapter(MessageReserve reserve) {
        log.info("messageListenerAdapter-Started");
        return new MessageListenerAdapter(reserve, "message");
    }

}
