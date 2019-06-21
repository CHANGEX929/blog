package com.changex.blog.controller.test;

import com.changex.blog.core.resource.result.DataResponseResult;
import com.changex.blog.core.resource.result.ResponseResultFactory;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
        valueOperations.set("name","changex");
        return ResponseResultFactory.getData(valueOperations.get("name").toString());
    }
}
