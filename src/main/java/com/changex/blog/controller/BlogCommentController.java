package com.changex.blog.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.changex.blog.core.pojo.TBlogComment;
import com.changex.blog.core.pojo.dto.BlogCommentDTO;
import com.changex.blog.core.resource.result.*;
import com.changex.blog.service.TBlogCommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Xie Chenxi
 * @date 2019-02-01 00:34
 */
@Api(tags = "评论")
@RestController
@RequestMapping("/comments")
public class BlogCommentController {

    @Autowired
    private TBlogCommentService commentService;

    @ApiOperation(value = "新增评论")
    @PostMapping("/comment")
    public DataResponseResult<Boolean> addArticle(@ApiParam(value = "文章") BlogCommentDTO blogArticle) {

        TBlogComment tBlogComment = new TBlogComment();

        BeanUtils.copyProperties(blogArticle, tBlogComment);

        return ResponseResultFactory.getData(commentService.save(tBlogComment));
    }

    @ApiOperation(value = "查询评论")
    @GetMapping("/articleId")
    public ListResponseResult<TBlogComment> listByArticleId(@ApiParam(value = "文章") BlogCommentDTO blogArticle) {

        return ResponseResultFactory.getList(
                commentService.list(Wrappers.query(TBlogComment.builder().articleId(blogArticle.getArticleId()).build()))
        );
    }
}
