package com.changex.blog.mapper.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.changex.blog.core.pojo.TBlogArticle;
import com.changex.blog.core.pojo.dto.BlogArticleDTO;
import com.changex.blog.core.pojo.vo.BlogArticleVo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author Xie Chenxi
 * @Date 2018/11/25 0:02
 */
public interface TBlogArticleMapper extends BaseMapper<TBlogArticle> {

    @Select("SELECT a.*,t.name AS tag_name FROM blog_article a,blog_tag t" +
            " WHERE a.tag_id = t.id AND a.author_id = #{authorId} AND t.author_id = #{authorId} AND t.is_valid =1 AND a.is_valid = 1")
    List<BlogArticleVo> listByAuthorId(BlogArticleDTO blogArticleDTO);

    @Select("SELECT a.*,t.name AS tag_name FROM blog_article a,blog_tag t" +
            " WHERE a.tag_id = t.id AND a.id = #{id} AND t.is_valid =1 AND a.is_valid = 1")
    BlogArticleVo getById(BlogArticleDTO blogArticleDTO);
}
