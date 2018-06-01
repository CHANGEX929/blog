package com.personalblog.blog.Controller;

import com.personalblog.blog.service.UserService;
import com.personalblog.blog.tools.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@EnableAutoConfiguration
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RedisUtil redisUtil;
    @GetMapping("index.html")
    public String index(Model model){
        redisUtil.setValue("user",userService.getUsers().get(0).getName());
        model.addAttribute("user",redisUtil.getValue("user"));
        System.out.println(redisUtil.getValue("user"));
        return "index";
    }
}
