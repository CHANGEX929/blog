package com.changex.blog.pojo;

import lombok.Data;

/**
 * @Author Xie Chenxi
 * @Date 2018/11/18 4:39
 */
@Data
public class TBlogArticle {
    private Integer id;
    private String title;
    private Integer authorId;
    private Integer readNum;
    private String content;
    private String picUrl;
    private Integer tagId;
    private String createDate;
    private String updateDate;
    private Integer isValid;
}
