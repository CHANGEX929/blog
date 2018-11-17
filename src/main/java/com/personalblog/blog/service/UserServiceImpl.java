package com.personalblog.blog.service;

import com.personalblog.blog.mapper.UserMapper;
import com.personalblog.blog.pojo.TSysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<TSysUser> getUsers() {
        return userMapper.getUsers();
    }
}
