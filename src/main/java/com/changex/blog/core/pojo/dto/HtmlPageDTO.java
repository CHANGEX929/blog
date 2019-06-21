package com.changex.blog.core.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author Xie Chenxi
 * @date 2019-02-01 01:11
 */
@ApiModel(value = "评论")
@Builder
@AllArgsConstructor
@Data
public class HtmlPageDTO {

    @ApiModelProperty(value = "页面Id")
    private Integer id;
    @ApiModelProperty(value = "页面富文本内容")
    private String content;
    @ApiModelProperty(value = "页面类型")
    private String type;
}
