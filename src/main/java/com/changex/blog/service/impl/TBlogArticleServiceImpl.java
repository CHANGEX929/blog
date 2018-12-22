package com.changex.blog.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.changex.blog.core.pojo.TBlogArticle;
import com.changex.blog.core.pojo.dto.BlogArticleDTO;
import com.changex.blog.core.pojo.vo.BlogArticleVo;
import com.changex.blog.mapper.base.TBlogArticleMapper;
import com.changex.blog.service.TBlogArticleService;
import com.changex.blog.tools.DateUtils;
import com.fasterxml.jackson.databind.BeanProperty;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Xie Chenxi
 * @Date 2018/11/25 0:22
 */
@Service
public class TBlogArticleServiceImpl extends ServiceImpl<TBlogArticleMapper, TBlogArticle> implements TBlogArticleService {

    @Resource
    private TBlogArticleMapper articleMapper;

    @Override
    public Integer save(BlogArticleDTO articleDTO) {

        if (StringUtils.isEmpty(articleDTO.getPicUrl())) {
            articleDTO.setPicUrl("http://changex.oss-cn-beijing.aliyuncs.com/blog_img/bc1d967cf0ed43e3a128539de8dafc28b0ce3f3cde0c084b6d42321b2dcbc407?Expires=1859559813&OSSAccessKeyId=LTAI8EVf6JFCeu8E&Signature=p4cZYx2if2S31r2vdPsWWvnk%2BkE%3D");
        }

        TBlogArticle blogArticle = new TBlogArticle();

        BeanUtils.copyProperties(articleDTO, blogArticle);

        super.save(blogArticle);

        return blogArticle.getId();
    }

    @Override
    public List<BlogArticleVo> listByAuthorId(BlogArticleDTO articleDTO) {

        return articleMapper.listByAuthorId(articleDTO);
    }

    @Override
    public List<BlogArticleVo> listByTagId(BlogArticleDTO articleDTO) {

        return articleMapper.listByTagId(articleDTO);
    }

    @Override
    public List<BlogArticleVo> listByKeyWord(BlogArticleDTO articleDTO) {

        return articleMapper.listByKeyWord("%" + articleDTO.getKeyWord() + "%");
    }

    @Override
    public BlogArticleVo getById(BlogArticleDTO articleDTO) {

        BlogArticleVo blogArticleVo = articleMapper.getById(articleDTO);

        //增加阅读数目
        if (blogArticleVo != null) {

            BlogArticleDTO article = new BlogArticleDTO();
            article.setId(blogArticleVo.getId());
            article.setReadNum(blogArticleVo.getReadNum() + 1);
            this.update(article);
        }

        return blogArticleVo;
    }

    @Override
    public boolean update(BlogArticleDTO articleDTO) {

        TBlogArticle blogArticle = new TBlogArticle();

        BeanUtils.copyProperties(articleDTO, blogArticle);

        return super.updateById(blogArticle);
    }

    @Override
    public boolean delete(BlogArticleDTO articleDTO) {

        return super.removeById(articleDTO.getId());
    }
}
