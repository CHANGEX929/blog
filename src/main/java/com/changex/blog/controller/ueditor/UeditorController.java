package com.changex.blog.controller.ueditor;

import com.baidu.ueditor.ActionEnter;
import com.baidu.ueditor.upload.BinaryUploader;
import com.changex.blog.tools.AliyunOssUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Author Xie Chenxi
 * @Date 2018/11/29 21:23
 */
@Controller
public class UeditorController {

    @GetMapping("/config")
    public void config(HttpServletRequest request, HttpServletResponse response) {
        doExe(request, response);
    }

    @PostMapping("/config")
    public void postConfig(HttpServletRequest request, HttpServletResponse response) {
        doExe(request, response);
    }

    private void doExe(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        String rootPath = request.getSession().getServletContext().getRealPath("/");
        try {
            String exec = new ActionEnter(request, rootPath).exec();
            PrintWriter writer = response.getWriter();
            writer.write(exec);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
