package com.personalblog.blog.pojo;

import lombok.Data;

@Data
public class TSysUser {
    private Integer id;
    private String userName;
    private String password;
    private String createDate;
    private String updateDate;
    private Integer isValid;

}
