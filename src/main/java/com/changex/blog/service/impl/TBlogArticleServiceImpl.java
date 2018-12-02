package com.changex.blog.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.changex.blog.mapper.base.TBlogArticleMapper;
import com.changex.blog.core.pojo.TBlogArticle;
import com.changex.blog.core.pojo.dto.BlogArticleDTO;
import com.changex.blog.service.TBlogArticleService;
import com.changex.blog.tools.DateUtils;
import org.springframework.stereotype.Service;

/**
 * @Author Xie Chenxi
 * @Date 2018/11/25 0:22
 */
@Service
public class TBlogArticleServiceImpl extends ServiceImpl<TBlogArticleMapper, TBlogArticle> implements TBlogArticleService {

    @Override
    public Integer save(BlogArticleDTO articleDTO) {

        TBlogArticle blogArticle = new TBlogArticle();
        blogArticle.setTitle(articleDTO.getTitle());
        blogArticle.setAuthorId(articleDTO.getAuthorId());
        blogArticle.setContent(articleDTO.getContent());
        blogArticle.setPicUrl(articleDTO.getPicUrl());
        blogArticle.setTagId(articleDTO.getTagId());
        blogArticle.setIsSecret(blogArticle.getIsSecret());
        blogArticle.setCreateDate(DateUtils.getDateTime());
        blogArticle.setUpdateDate(DateUtils.getDateTime());
        super.save(blogArticle);

        System.out.println(JSON.toJSONString(blogArticle));

        return blogArticle.getId();
    }
}
