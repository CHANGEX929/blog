package com.changex.blog.core.pojo;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

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
    private Integer isSecret;
    private String createDate;
    private String updateDate;
    @TableLogic
    private Integer isValid;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
