package com.changex.blog.service;

import com.changex.blog.core.pojo.TSysUser;
import com.changex.blog.core.pojo.dto.UserDTO;

/**
 * @Author Xie Chenxi
 * @Date 2018/11/21 20:18
 */
public interface TSysUserService {

     TSysUser getUser();

     void del();

    TSysUser getByUserName(String userName);

    boolean save(UserDTO userDTO);
}
