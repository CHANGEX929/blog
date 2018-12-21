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
 * @Date 2018/11/18 4:39
 */
@Data
@TableName(value = "blog_article")
public class TBlogArticle extends Model<TBlogArticle> {
    private Integer id;
    private String title;
    private Integer authorId;
    private Integer readNum;
    private String content;
    private String picUrl;
    private Integer tagId;
    private String keyWord;
    private String summary;
    private Integer isSecret;
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
