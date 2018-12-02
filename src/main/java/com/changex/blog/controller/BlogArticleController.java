package com.changex.blog.controller;

import com.changex.blog.core.pojo.dto.BlogArticleDTO;
import com.changex.blog.core.resource.result.IdResponseResult;
import com.changex.blog.core.resource.result.ResponseResultFactory;
import com.changex.blog.service.TBlogArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author Xie Chenxi
 * @Date 2018/11/25 0:06
 */
@Api(tags = "文章")
@RestController
@RequestMapping("/articles")
public class BlogArticleController {

    @Resource
    private TBlogArticleService blogArticleService;

    @ApiOperation(value = "新增文章")
    @PostMapping("/article")
    public IdResponseResult addArticle(@ApiParam(value = "文章")
                                       @RequestBody BlogArticleDTO blogArticle) {

        return ResponseResultFactory.getId(blogArticleService.save(blogArticle));
    }
}
