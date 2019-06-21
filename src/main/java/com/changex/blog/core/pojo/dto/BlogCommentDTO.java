package com.changex.blog.core.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Xie Chenxi
 * @date 2019-02-01 00:36
 */
@ApiModel(value = "评论")
@Builder
@AllArgsConstructor
@Data
public class BlogCommentDTO {

    @ApiModelProperty(value = "评论Id")
    private Integer id;
    @ApiModelProperty(value = "评论文章Id")
    private Integer articleId;
    @ApiModelProperty(value = "评论类型1:文章评论 2:博客评论")
    private Integer type;
    @ApiModelProperty(value = "评论内容")
    private String content;
    @ApiModelProperty(value = "回复评论Id")
    private Integer toComment;
    @ApiModelProperty(value = "昵称")
    private String nickName;
    @ApiModelProperty(value = "邮箱")
    private String email;
    @ApiModelProperty(value = "网址")
    private String webUrl;

    public BlogCommentDTO() {
        type = 1;
    }
}
