package com.changex.blog.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.changex.blog.config.Constant;
import com.changex.blog.core.pojo.TBlogArticle;
import com.changex.blog.core.pojo.TBlogTag;
import com.changex.blog.core.pojo.dto.BlogArticleDTO;
import com.changex.blog.core.pojo.vo.BlogArticleVo;
import com.changex.blog.mapper.base.TBlogArticleMapper;
import com.changex.blog.service.TBlogArticleService;
import com.changex.blog.service.TBlogTagService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author Xie Chenxi
 * @Date 2018/11/25 0:22
 */
@Service
public class TBlogArticleServiceImpl extends ServiceImpl<TBlogArticleMapper, TBlogArticle> implements TBlogArticleService {

    @Resource
    private TBlogTagService blogTagService;

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
    public IPage<BlogArticleVo> listByAuthorId(BlogArticleDTO articleDTO) {

        return convertToBlogArticleVoIPage(
                page(
                        new Page<>(articleDTO.getCurrentPage(), Constant.PAGE_SIZE),
                        Wrappers.query(TBlogArticle.builder().authorId(articleDTO.getAuthorId()).build()).orderByDesc("create_date")
                )
                , articleDTO);
    }

    @Override
    public IPage<BlogArticleVo> listByTagId(BlogArticleDTO articleDTO) {

        return convertToBlogArticleVoIPage(
                page(
                        new Page<>(articleDTO.getCurrentPage(), Constant.PAGE_SIZE),
                        Wrappers.query(TBlogArticle.builder().authorId(articleDTO.getAuthorId()).tagId(articleDTO.getTagId()).build()).orderByDesc("create_date")
                )
                , articleDTO);
    }

    @Override
    public IPage<BlogArticleVo> listByKeyWord(BlogArticleDTO articleDTO) {


        return convertToBlogArticleVoIPage(
                page(
                        new Page<>(articleDTO.getCurrentPage(), Constant.PAGE_SIZE),
                        Wrappers.query(TBlogArticle.builder().authorId(articleDTO.getAuthorId()).build()).like("concat(lower(key_word),lower(title))", articleDTO.getKeyWord().toLowerCase())
                )
                , articleDTO);
    }

    @Override
    public BlogArticleVo getById(BlogArticleDTO articleDTO) {

        BlogArticleVo blogArticleVo = super.baseMapper.getById(articleDTO);

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

    private IPage<BlogArticleVo> convertToBlogArticleVoIPage(IPage<TBlogArticle> articleIPage, BlogArticleDTO articleDTO) {

        Map<Integer, String> tagMap = blogTagService.listByAuthorId(articleDTO.getAuthorId()).stream().collect(Collectors.toMap(TBlogTag::getId, TBlogTag::getName));

        IPage<BlogArticleVo> articleVoIPage = new Page<>();
        articleVoIPage.setTotal(articleIPage.getTotal());
        articleVoIPage.setSize(articleIPage.getSize());
        articleVoIPage.setCurrent(articleIPage.getCurrent());
        articleVoIPage.setRecords(articleIPage.getRecords().stream().map(o -> convertToBlogArticleVo(o, tagMap)).collect(Collectors.toList()));
        return articleVoIPage;
    }

    private BlogArticleVo convertToBlogArticleVo(TBlogArticle blogArticle, Map<Integer, String> tagMap) {
        return new BlogArticleVo(
                blogArticle.getId()
                , blogArticle.getTitle()
                , blogArticle.getAuthorId()
                , blogArticle.getReadNum()
                , blogArticle.getContent()
                , blogArticle.getPicUrl()
                , blogArticle.getTagId()
                , blogArticle.getKeyWord()
                , blogArticle.getSummary()
                , blogArticle.getIsSecret()
                , blogArticle.getCreateDate()
                , blogArticle.getUpdateDate()
                , blogArticle.getIsValid()
                , tagMap.get(blogArticle.getTagId())
        );
    }
}
