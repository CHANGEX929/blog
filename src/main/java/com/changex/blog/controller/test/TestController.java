package com.changex.blog.controller.test;

import com.changex.blog.core.pojo.dto.BlogChatDTO;
import com.changex.blog.core.resource.result.DataResponseResult;
import com.changex.blog.core.resource.result.ResponseResultFactory;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author Xie Chenxi
 * @date 2019-06-21 20:01
 */
@RestController("/test")
public class TestController {

    @Resource
    private ValueOperations valueOperations;

    @ApiOperation(value = "测试一个redis")
    @GetMapping("/redisTest")
    public DataResponseResult<String> redisTest() {
        BlogChatDTO time = new BlogChatDTO();
        valueOperations.set("dui",time,60);
        return ResponseResultFactory.getData(valueOperations.get("name").toString());
    }

    @ApiOperation(value = "测试取一个redis")
    @GetMapping("/redisTestGet")
    public DataResponseResult<String> redisTestGet() {
        Object name = valueOperations.get("dui");
        System.out.println(name);
        return ResponseResultFactory.getData(name.toString());
    }

    public void setMessage(String message){
        System.out.println(message);
        valueOperations.set("message",message);
    }
}
