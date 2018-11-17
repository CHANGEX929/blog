package com.personalblog.blog.pojo;

import lombok.Data;

/**
 * @Author Xie Chenxi
 * @Date 2018/11/18 4:41
 */
@Data
public class TBlogAuthor {
    private Integer id;
    private Integer userId;
    private String realName;
    private String headImg;
    private Integer sex;
    private String birthDay;
    private String createDate;
    private String updateDate;
    private Integer isValid;
}
