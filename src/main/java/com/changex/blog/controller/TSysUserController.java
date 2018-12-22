package com.changex.blog.controller;

import com.changex.blog.core.pojo.dto.UserDTO;
import com.changex.blog.core.resource.result.DataResponseResult;
import com.changex.blog.core.resource.result.ResponseResultFactory;
import com.changex.blog.service.TSysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "用户")
@RestController
@RequestMapping("/users/")
public class TSysUserController {

    @Autowired
    private TSysUserService userService;

    @ApiOperation(value = "新增用户")
    @PostMapping("/user")
    public DataResponseResult<Boolean> add(@ApiParam(value = "用户") UserDTO userDTO) {

        return ResponseResultFactory.getData(userService.save(userDTO));
    }
}
