package com.changex.blog.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.changex.blog.mapper.UserMapper;
import com.changex.blog.pojo.TSysUser;
import org.springframework.stereotype.Service;
/**
 * @Author Xie Chenxi
 * @Date 2018/11/21 20:18
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, TSysUser> implements UserService {

    @Override
    public TSysUser getUser() {
        return super.getById(1);
    }

    @Override
    public void del() {
        super.removeById(1);
    }
}
