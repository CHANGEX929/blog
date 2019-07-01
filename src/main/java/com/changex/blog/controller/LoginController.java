package com.changex.blog.controller;

import com.alibaba.fastjson.JSON;
import com.changex.blog.core.pojo.TSysUser;
import com.changex.blog.core.resource.result.DataResponseResult;
import com.changex.blog.core.resource.result.ResponseResult;
import com.changex.blog.core.resource.result.ResponseResultFactory;
import com.changex.blog.service.TSysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author Xie Chenxi
 * @date 2018-12-22 10:46
 */
@Api(tags = "登录")
@RestController
@RequestMapping("/back/login")
public class LoginController {

    @Resource
    private TSysUserService sysUserService;

    @Resource
    private ValueOperations valueOperations;

    @ApiOperation(value = "管理员登陆后台")
    @PostMapping("")
    public DataResponseResult<Integer> login(String userName, String passWord, HttpSession session) {

        TSysUser sysUser = sysUserService.getByUserName(userName);

        //账号不存在
        if (sysUser == null) {

            return ResponseResultFactory.getData(0);
        }

        //角色不对
        if (sysUser.getRoleId() != 1) {

            return ResponseResultFactory.getData(0);
        }

        //密码错误
        if (!sysUser.getPassword().equals(passWord)) {

            return ResponseResultFactory.getData(0);
        }

        session.setAttribute("admin", sysUser);
        String json = JSON.toJSONString(sysUser);
        valueOperations.set("user",json,60*60*12);
        return ResponseResultFactory.getData(sysUser.getId());
    }

    @ApiOperation(value = "管理员注销")
    @PostMapping("/logout")
    public ResponseResult logout(HttpSession session) {

        session.removeAttribute("admin");

        return ResponseResultFactory.getSuccess();
    }
}
