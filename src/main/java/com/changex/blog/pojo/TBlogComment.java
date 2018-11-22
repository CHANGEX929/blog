package com.changex.blog.pojo;

import lombok.Data;

/**
 * @Author Xie Chenxi
 * @Date 2018/11/18 4:43
 */
@Data
public class TBlogComment {
    private Integer id;
    private Integer articleId;
    private Integer type;
    private String content;
    private String nickName;
    private String email;
    private String webUrl;
    private String createDate;
    private String updateDate;
    private Integer isValid;
}
