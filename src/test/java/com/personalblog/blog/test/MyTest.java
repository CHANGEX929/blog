package com.personalblog.blog.test;

import com.changex.blog.mapper.base.TSysUserMapper;
import com.personalblog.blog.BlogApplicationTests;
import org.junit.Test;
import org.springframework.boot.SpringBootConfiguration;

import javax.annotation.Resource;

/**
 * @Author Xie Chenxi
 * @Date 2018/11/24 0:02
 */
@SpringBootConfiguration
public class MyTest extends BlogApplicationTests {

    @Resource
    private TSysUserMapper TSysUserMapper;

    @Test
    public void te(){
        TSysUserMapper.selectById(1);
    }
}
