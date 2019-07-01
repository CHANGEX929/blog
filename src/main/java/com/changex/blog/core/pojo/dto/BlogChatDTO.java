package com.changex.blog.core.pojo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@ApiModel(value = "聊天")
@Data
public class BlogChatDTO {

        @ApiModelProperty(value = "发送者id")
        private Integer senderId;
        @ApiModelProperty(value = "发送内容")
        private String sendMsg;
        @ApiModelProperty(value = "发送类型")
        private Integer sendType;
        @ApiModelProperty(value = "接收者id")
        private Integer receiverId;

}
