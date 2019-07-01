package com.changex.blog.core.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName(value = "blog_chat")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TBlogChat extends Model<TBlogChat> {

    private Integer id;
    private Integer senderId;
    private String sendMsg;
    private Integer sendType;
    private Integer receiverId;
    @TableField(value = "create_date", fill = FieldFill.INSERT)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime createDate;
    @TableField(value = "update_date", fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime updateDate;
    @TableLogic
    private Integer isValid;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
