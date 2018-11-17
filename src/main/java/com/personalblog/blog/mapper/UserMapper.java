package com.personalblog.blog.mapper;

import com.personalblog.blog.pojo.TSysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from tb_person")
    List<TSysUser> getUsers();
}
