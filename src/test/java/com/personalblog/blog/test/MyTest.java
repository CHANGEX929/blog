package com.personalblog.blog.test;

import com.alibaba.fastjson.JSON;
import com.changex.blog.core.pojo.dto.BlogArticleDTO;
import com.changex.blog.core.pojo.dto.UserDTO;
import com.changex.blog.mapper.base.TSysUserMapper;
import com.changex.blog.service.TBlogArticleService;
import com.changex.blog.service.TSysUserService;
import com.changex.blog.tools.MD5Utils;
import com.personalblog.blog.BlogApplicationTests;
import org.junit.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringBootConfiguration;

import javax.annotation.Resource;

/**
 * @Author Xie Chenxi
 * @Date 2018/11/24 0:02
 */
@SpringBootConfiguration
@MapperScan("com.changex.blog.mapper.base")
public class MyTest extends BlogApplicationTests {

   /* @Resource
    private TSysUserMapper TSysUserMapper;*/
/*    @Resource
    private TBlogArticleService articleService;



    @Test
    public void sele() {

        BlogArticleDTO articleDTO = new BlogArticleDTO();
        articleDTO.setAuthorId(1);
        System.out.println(JSON.toJSONString(articleService.listByAuthorId(articleDTO)));
    }*/

    @Resource
    private TSysUserService sysUserService;

    @Test
    public void test() {
        String passWord = MD5Utils.getPassWord("134679x");
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName("13233006500");
        userDTO.setRoleId(1);
        userDTO.setPassword(passWord);
        sysUserService.save(userDTO);
    }
}
