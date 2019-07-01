package com.changex.blog.controller;

import com.changex.blog.core.pojo.TBlogChat;
import com.changex.blog.core.pojo.dto.BlogChatDTO;
import com.changex.blog.core.pojo.dto.BlogTagDTO;
import com.changex.blog.core.resource.result.DataResponseResult;
import com.changex.blog.core.resource.result.ResponseResult;
import com.changex.blog.core.resource.result.ResponseResultFactory;
import com.changex.blog.service.TBlogChatService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "聊天")
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    private TBlogChatService tBlogChatService;

    @ApiOperation(value = "查询聊天记录")
    @PostMapping(value = "/queryChats", produces = { "application/json;charset=UTF-8" })
    public DataResponseResult<List<TBlogChat>> queryChats(@ApiParam(value = "聊天参数")@RequestBody BlogChatDTO blogChatDTO) {
        TBlogChat tBlogChat = new TBlogChat();
        System.out.println(blogChatDTO);

        BeanUtils.copyProperties(blogChatDTO,tBlogChat);
        System.out.println(tBlogChat);
        List<TBlogChat> tBlogChats = tBlogChatService.queryChats(tBlogChat);
        return ResponseResultFactory.getData(tBlogChats);
    }


}
