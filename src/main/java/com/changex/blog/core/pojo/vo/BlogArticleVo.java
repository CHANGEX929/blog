package com.changex.blog.core.pojo.vo;

import com.changex.blog.core.pojo.TBlogArticle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author Xie Chenxi
 * @date 2018-12-07 17:01
 */
@Data
public class BlogArticleVo extends TBlogArticle {

    private String tagName;

    public BlogArticleVo() {
    }

    public BlogArticleVo(Integer id, String title, Integer authorId, Integer readNum, String content, String picUrl, Integer tagId, String keyWord, String summary, Integer isSecret, LocalDateTime createDate, LocalDateTime updateDate, Integer isValid, String tagName) {
        super(id, title, authorId, readNum, content, picUrl, tagId, keyWord, summary, isSecret, createDate, updateDate, isValid);
        this.tagName = tagName;
    }
}
