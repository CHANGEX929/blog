package com.changex.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.changex.blog.core.pojo.TBlogChat;

import java.util.List;

public interface TBlogChatService extends IService<TBlogChat> {
    /**
     * 新增
     * @param tBlogChat
     * @return
     */
    Integer saveChat(TBlogChat tBlogChat);

    /**
     * 查询聊天记录
     * @param tBlogChat
     * @return
     */
    List<TBlogChat> queryChats(TBlogChat tBlogChat);

}
