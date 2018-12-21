package com.changex.blog.core.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author Xie Chenxi
 * @Date 2018/11/25 0:14
 */
@ApiModel(value = "文章")
@Data
public class BlogArticleDTO {

    @ApiModelProperty(value = "文章ID")
    private Integer id;
    @ApiModelProperty(value = "标题")
    private String title;
    @ApiModelProperty(value = "内容")
    private String content;
    @ApiModelProperty(value = "作者id")
    private Integer authorId;
    @ApiModelProperty(value = "背景图片")
    private String picUrl;
    @ApiModelProperty(value = "标签ID")
    private Integer tagId;
    @ApiModelProperty(value = "关键词")
    private String keyWord;
    @ApiModelProperty(value = "摘要")
    private String summary;
    @ApiModelProperty(value = "是否加密，1：加密，0：不加密")
    private Integer isSecret;


}
