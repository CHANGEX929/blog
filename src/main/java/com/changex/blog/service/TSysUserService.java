package com.changex.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.changex.blog.core.pojo.TSysUser;
import com.changex.blog.core.pojo.dto.UserDTO;

import java.util.List;

/**
 * @Author Xie Chenxi
 * @Date 2018/11/21 20:18
 */
public interface TSysUserService extends IService<TSysUser> {

    TSysUser getByUserName(String userName);

    boolean save(UserDTO userDTO);

    List<TSysUser> queryUser(TSysUser user);

}
