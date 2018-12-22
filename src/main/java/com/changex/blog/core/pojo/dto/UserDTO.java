package com.changex.blog.core.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Xie Chenxi
 * @date 2018-12-22 10:50
 */
@ApiModel(value = "目录")
@Data
public class UserDTO {

    @ApiModelProperty(value = "账号")
    private String userName;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "角色Id")
    private Integer roleId;
}
