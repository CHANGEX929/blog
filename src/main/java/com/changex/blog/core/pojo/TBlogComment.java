package com.changex.blog.core.pojo;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author Xie Chenxi
 * @Date 2018/11/18 4:43
 */
@Data
@TableName(value = "blog_comment")
public class TBlogComment extends Model<TBlogComment> {
    private Integer id;
    private Integer articleId;
    private Integer type;
    private String content;
    private String nickName;
    private String email;
    private String webUrl;
    private String createDate;
    private String updateDate;
    @TableLogic
    private Integer isValid;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
