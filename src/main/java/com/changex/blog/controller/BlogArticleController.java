package com.changex.blog.controller;

import com.alibaba.fastjson.JSON;
import com.changex.blog.core.pojo.dto.BlogArticleDTO;
import com.changex.blog.core.pojo.vo.BlogArticleVo;
import com.changex.blog.core.resource.result.*;
import com.changex.blog.service.TBlogArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

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
                                               BlogArticleDTO blogArticle) {

        return ResponseResultFactory.getId(blogArticleService.save(blogArticle));
    }

    @ApiOperation(value = "根据作者ID查找文章列表")
    @GetMapping("/byAuthorId")
    public ListResponseResult<BlogArticleVo> listByAuthorId(@ApiParam(value = "文章") BlogArticleDTO blogArticle) {

        return ResponseResultFactory.getList(blogArticleService.listByAuthorId(blogArticle));
    }

    @ApiOperation(value = "根据文章ID查找文章")
    @GetMapping("/article/byId")
    public DataResponseResult<BlogArticleVo> getById(@ApiParam(value = "文章") BlogArticleDTO blogArticle) {

        return ResponseResultFactory.getData(blogArticleService.getById(blogArticle));
    }

    @ApiOperation(value = "更新文章")
    @PostMapping("/put/article")
    public ResponseResult update(@ApiParam(value = "文章") BlogArticleDTO blogArticle) {

        blogArticleService.update(blogArticle);
        return ResponseResultFactory.getSuccess();
    }

    @ApiOperation(value = "删除文章")
    @PostMapping("/delete/article")
    public ResponseResult delete(@ApiParam(value = "文章") BlogArticleDTO blogArticle) {

        blogArticleService.delete(blogArticle);

        return ResponseResultFactory.getSuccess();
    }


}
