package com.personalblog.blog.pojo;

import lombok.Data;

/**
 * @Author Xie Chenxi
 * @Date 2018/11/18 4:45
 */
@Data
public class TBlogTag {
    private Integer id;
    private Integer authorId;
    private String name;
    private String createDate;
    private String updateDate;
    private Integer isValid;
}
