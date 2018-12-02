package com.changex.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.changex.blog.mapper.base.TSysUserMapper;
import com.changex.blog.core.pojo.TSysUser;
import com.changex.blog.service.TSysUserService;
import org.springframework.stereotype.Service;
/**
 * @Author Xie Chenxi
 * @Date 2018/11/21 20:18
 */
@Service
public class TSysUserServiceImpl extends ServiceImpl<TSysUserMapper, TSysUser> implements TSysUserService {

    @Override
    public TSysUser getUser() {
        return super.getById(1);
    }

    @Override
    public void del() {
        super.removeById(1);
    }
}
