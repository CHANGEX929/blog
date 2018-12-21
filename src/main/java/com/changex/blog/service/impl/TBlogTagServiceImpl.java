package com.changex.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.changex.blog.core.pojo.TBlogTag;
import com.changex.blog.core.pojo.dto.BlogTagDTO;
import com.changex.blog.mapper.base.TBlogTagMapper;
import com.changex.blog.service.TBlogTagService;
import com.changex.blog.tools.DateUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author Xie Chenxi
 * @Date 2018/12/2 20:13
 */
@Service
public class TBlogTagServiceImpl extends ServiceImpl<TBlogTagMapper, TBlogTag> implements TBlogTagService {

    @Override
    public Integer save(BlogTagDTO blogTagDTO) {

        if (null == blogTagDTO.getAuthorId() || blogTagDTO.getAuthorId() == 0) {
            blogTagDTO.setAuthorId(1);
        }

        TBlogTag blogTag = new TBlogTag();
        blogTag.setAuthorId(1);
        blogTag.setName(blogTagDTO.getName());
        blogTag.setAlias(blogTagDTO.getAlias());
        super.save(blogTag);
        return blogTag.getId();
    }

    @Override
    public boolean update(BlogTagDTO blogTagDTO) {
        TBlogTag blogTag = super.getById(blogTagDTO.getId());
        blogTag.setName(blogTagDTO.getName());
        blogTag.setAlias(blogTagDTO.getAlias());
        return super.saveOrUpdate(blogTag);
    }

    @Override
    public boolean delById(Integer id) {
        return super.removeById(id);
    }

    @Override
    public List<TBlogTag> listByAuthorId(Integer authorId) {

        if (null == authorId || authorId == 0) {
            authorId = 1;
        }

        Map<String, Object> columnMap = new HashMap<>();
        columnMap.put("author_id", authorId);

        return super.listByMap(columnMap).stream().collect(Collectors.toList());
    }


}
