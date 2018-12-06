package com.changex.blog.controller;

import com.alibaba.fastjson.JSON;
import com.changex.blog.core.pojo.TBlogTag;
import com.changex.blog.core.pojo.dto.BlogTagDTO;
import com.changex.blog.core.resource.result.IdResponseResult;
import com.changex.blog.core.resource.result.ListResponseResult;
import com.changex.blog.core.resource.result.ResponseResult;
import com.changex.blog.core.resource.result.ResponseResultFactory;
import com.changex.blog.service.TBlogTagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author Xie Chenxi
 * @Date 2018/12/2 20:22
 */
@RestController
@Api(tags = "栏目")
@RequestMapping("/tags")
public class BlogTagController {

    @Resource
    private TBlogTagService blogTagService;

    @ApiOperation(value = "新增栏目")
    @PostMapping("/tag")
    public IdResponseResult add(@ApiParam(value = "栏目") BlogTagDTO blogTagDTO) {

        return ResponseResultFactory.getId(blogTagService.save(blogTagDTO));
    }

    @ApiOperation(value = "修改栏目")
    @PutMapping("/tag")
    public ResponseResult update(@ApiParam(value = "栏目") BlogTagDTO blogTagDTO) {

        if (blogTagService.update(blogTagDTO)) {
            return ResponseResultFactory.getSuccess();
        } else {
            return ResponseResultFactory.getInvalidProp();
        }
    }

    @ApiOperation(value = "删除栏目")
    @DeleteMapping("/tag")
    public ResponseResult del(@ApiParam(value = "栏目") BlogTagDTO blogTagDTO) {

        if (blogTagService.delById(blogTagDTO.getId())) {
            return ResponseResultFactory.getSuccess();
        } else {
            return ResponseResultFactory.getInvalidProp();
        }
    }

    @ApiOperation(value = "查看作者的所有栏目")
    @GetMapping("/byAuthorId")
    public ListResponseResult<TBlogTag> listByAuthorId(@ApiParam(value = "栏目") BlogTagDTO blogTagDTO) {

        return ResponseResultFactory.getList(blogTagService.listByAuthorId(blogTagDTO.getAuthorId()));
    }
}
