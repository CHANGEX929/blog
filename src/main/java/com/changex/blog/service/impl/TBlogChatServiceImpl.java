package com.changex.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.changex.blog.core.pojo.TBlogChat;
import com.changex.blog.core.pojo.TSysUser;
import com.changex.blog.core.pojo.dto.BlogArticleDTO;
import com.changex.blog.mapper.base.TBlogChatMapper;
import com.changex.blog.service.TBlogArticleService;
import com.changex.blog.service.TBlogChatService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TBlogChatServiceImpl extends ServiceImpl<TBlogChatMapper, TBlogChat> implements TBlogChatService {


    @Override
    public Integer saveChat(TBlogChat tBlogChat) {
        super.save(tBlogChat);
        return tBlogChat.getId();
    }

    @Override
    public List<TBlogChat> queryChats(TBlogChat tBlogChat) {
        QueryWrapper<TBlogChat> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().in(TBlogChat::getReceiverId,tBlogChat.getReceiverId(),tBlogChat.getSenderId());
        queryWrapper.lambda().in(TBlogChat::getSenderId,tBlogChat.getSenderId(),tBlogChat.getReceiverId());
        return super.list(queryWrapper);
    }
}
