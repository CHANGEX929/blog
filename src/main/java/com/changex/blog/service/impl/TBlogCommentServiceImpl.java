package com.changex.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.changex.blog.core.pojo.TBlogComment;
import com.changex.blog.mapper.base.TBlogCommentMapper;
import com.changex.blog.service.TBlogCommentService;
import org.springframework.stereotype.Service;

/**
 * @author Xie Chenxi
 * @date 2019-02-01 00:33
 */
@Service
public class TBlogCommentServiceImpl extends ServiceImpl<TBlogCommentMapper, TBlogComment> implements TBlogCommentService {
}
