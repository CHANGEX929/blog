package com.changex.blog.core.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author Xie Chenxi
 * @Date 2018/12/2 20:23
 */
@ApiModel(value = "目录")
@Data
public class BlogTagDTO  {
    @ApiModelProperty(value = "id")
    private Integer id;
    @ApiModelProperty(value = "作者ID")
    private Integer authorId;
    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "别名")
    private String alias;
}
