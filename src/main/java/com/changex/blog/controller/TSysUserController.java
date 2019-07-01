package com.changex.blog.controller;

import com.changex.blog.core.pojo.TBlogChat;
import com.changex.blog.core.pojo.TSysUser;
import com.changex.blog.core.pojo.dto.UserDTO;
import com.changex.blog.core.pojo.vo.SysUserVO;
import com.changex.blog.core.resource.result.DataResponseResult;
import com.changex.blog.core.resource.result.ResponseResultFactory;
import com.changex.blog.service.TBlogChatService;
import com.changex.blog.service.TSysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Api(tags = "用户")
@RestController
@RequestMapping("/users/")
public class TSysUserController {

    @Autowired
    private TSysUserService userService;

    @Autowired
    private TBlogChatService tBlogChatService;

    @ApiOperation(value = "新增用户")
    @PostMapping("/user")
    public DataResponseResult<Boolean> add(@ApiParam(value = "用户") UserDTO userDTO) {

        return ResponseResultFactory.getData(userService.save(userDTO));
    }

    @ApiOperation(value = "查询除自己外的所有用户")
    @PostMapping("/queryUserList")
    public DataResponseResult<List<SysUserVO>> query(HttpSession session) {
        List<SysUserVO> userVOList = new ArrayList<>();
        TSysUser user = (TSysUser)session.getAttribute("admin");
        TBlogChat chat = new TBlogChat();
        chat.setReceiverId(user.getId());
        List<TSysUser> tSysUsers = userService.queryUser(user);

        for (TSysUser tSysUser: tSysUsers) {
            SysUserVO sysUserVO = new SysUserVO();
            BeanUtils.copyProperties(tSysUser,sysUserVO);
            chat.setSenderId(tSysUser.getId());
            List<TBlogChat> tBlogChats = tBlogChatService.queryChats(chat);
            if(!CollectionUtils.isEmpty(tBlogChats)){
                sysUserVO.setMassage(tBlogChats.get(0).getSendMsg());
            }
            sysUserVO.setCountMsg(tBlogChats.size());
            userVOList.add(sysUserVO);
        }
        return ResponseResultFactory.getData(userVOList);
    }
}
