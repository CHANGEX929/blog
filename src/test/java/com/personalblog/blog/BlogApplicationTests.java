package com.personalblog.blog;

import com.changex.blog.core.pojo.TSysUser;
import com.changex.blog.core.pojo.dto.UserDTO;
import com.changex.blog.service.TSysUserService;
import com.changex.blog.tools.MD5Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
@SpringBootConfiguration
@MapperScan("com.changex.blog.mapper.*")
@ComponentScan("com.changex")
public class BlogApplicationTests {

    @Test
    public void contextLoads() {
    }
}
