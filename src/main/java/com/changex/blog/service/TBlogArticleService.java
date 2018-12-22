package com.changex.blog.service;

import com.changex.blog.core.pojo.dto.BlogArticleDTO;
import com.changex.blog.core.pojo.vo.BlogArticleVo;

import java.util.List;

/**
 * @Author Xie Chenxi
 * @Date 2018/11/25 0:21
 */
public interface TBlogArticleService {
    Integer save(BlogArticleDTO articleDTO);

    List<BlogArticleVo> listByAuthorId(BlogArticleDTO articleDTO);

    List<BlogArticleVo> listByTagId(BlogArticleDTO articleDTO);

    List<BlogArticleVo> listByKeyWord(BlogArticleDTO articleDTO);

    BlogArticleVo getById(BlogArticleDTO articleDTO);

    boolean update(BlogArticleDTO articleDTO);

    boolean delete(BlogArticleDTO articleDTO);
}
