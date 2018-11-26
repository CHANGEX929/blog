package com.changex.blog.pojo.dto;

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
    @ApiModelProperty(value = "是否加密，1：加密，0：不加密")
    private Integer isSecret;


}
