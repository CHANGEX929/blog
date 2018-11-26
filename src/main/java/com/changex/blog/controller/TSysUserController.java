package com.changex.blog.controller;

import com.changex.blog.service.TSysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TSysUserController {

    @Autowired
    private TSysUserService userService;

}
