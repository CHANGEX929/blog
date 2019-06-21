package com.changex.blog.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.changex.blog.core.pojo.TBlogComment;
import com.changex.blog.core.pojo.THtmlPage;
import com.changex.blog.core.pojo.dto.HtmlPageDTO;
import com.changex.blog.core.resource.result.DataResponseResult;
import com.changex.blog.core.resource.result.ResponseResultFactory;
import com.changex.blog.service.THtmlPageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Xie Chenxi
 * @date 2019-02-01 01:09
 */
@Api(tags = "自定义页面")
@RestController
@RequestMapping("/htmlPages")
public class HtmlPageController {

    @Autowired
    private THtmlPageService htmlPageService;

    @ApiOperation(value = "新增或修改页面")
    @PostMapping("/htmlPage")
    public DataResponseResult<Boolean> mergeHtml(@ApiParam(value = "页面DTO") HtmlPageDTO htmlPageDTO) {

        THtmlPage tHtmlPage = new THtmlPage();

        BeanUtils.copyProperties(htmlPageDTO, tHtmlPage);

        return ResponseResultFactory.getData(htmlPageService.saveOrUpdate(tHtmlPage));
    }

    @ApiOperation(value = "根据type获取页面内容")
    @GetMapping("/htmlPage/type")
    public DataResponseResult<THtmlPage> getByType(@ApiParam(value = "页面DTO") HtmlPageDTO htmlPageDTO) {

        return ResponseResultFactory.getData(htmlPageService.getOne(Wrappers.query(THtmlPage.builder().type(htmlPageDTO.getType()).build())));
    }
}
