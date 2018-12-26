package com.changex.blog.core.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author Xie Chenxi
 * @Date 2018/11/18 4:43
 */
@Data
public class TBlogComment extends Model<TBlogComment> {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer articleId;
    private Integer type;
    private String content;
    private String nickName;
    private String email;
    private String webUrl;
    @TableField(value = "create_date", fill = FieldFill.INSERT)
    private LocalDateTime createDate;
    @TableField(value = "update_date", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateDate;
    @TableLogic
    private Integer isValid;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
