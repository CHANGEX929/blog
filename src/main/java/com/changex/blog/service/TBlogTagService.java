package com.changex.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.changex.blog.core.pojo.TBlogTag;
import com.changex.blog.core.pojo.dto.BlogTagDTO;

import java.util.List;

/**
 * @Author Xie Chenxi
 * @Date 2018/11/25 0:03
 */
public interface TBlogTagService extends IService<TBlogTag> {

    Integer save(BlogTagDTO blogTagDTO);

    boolean update(BlogTagDTO blogTagDTO);

    boolean delById(Integer id);

    List<TBlogTag> listByAuthorId(Integer authorId);
}
