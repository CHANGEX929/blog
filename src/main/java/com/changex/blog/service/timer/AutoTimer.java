package com.changex.blog.service.timer;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class AutoTimer {

    @Scheduled(cron="0 0/5 * * * ?")
    public void autoPrint(){
        System.out.println("【定时任务】我5分钟出现一次");
    }
}
