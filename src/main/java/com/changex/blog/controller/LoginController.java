package com.changex.blog.controller;

import com.changex.blog.core.pojo.TSysUser;
import com.changex.blog.core.resource.result.DataResponseResult;
import com.changex.blog.core.resource.result.ResponseResult;
import com.changex.blog.core.resource.result.ResponseResultFactory;
import com.changex.blog.service.TSysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "管理员登陆后台")
    @PostMapping("")
    public DataResponseResult<Boolean> login(String userName, String passWord, HttpSession session) {

        TSysUser sysUser = sysUserService.getByUserName(userName);

        //账号不存在
        if (sysUser == null) {

            return ResponseResultFactory.getData(false);
        }

        //角色不对
        if (sysUser.getRoleId() != 1) {

            return ResponseResultFactory.getData(false);
        }

        //密码错误
        if (!sysUser.getPassword().equals(passWord)) {

            return ResponseResultFactory.getData(false);
        }

        session.setAttribute("admin", sysUser);

        return ResponseResultFactory.getData(true);
    }

    @ApiOperation(value = "管理员注销")
    @PostMapping("/logout")
    public ResponseResult logout(HttpSession session) {

        session.removeAttribute("admin");

        return ResponseResultFactory.getSuccess();
    }
}
