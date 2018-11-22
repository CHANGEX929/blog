package com.changex.blog.controller;

import com.changex.blog.config.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Xie Chenxi
 * @Date 2018/11/21 20:18
 */
@Controller
@RequestMapping("/back")
public class BackStageLinkController {

    @GetMapping("/index.html")
    public String welcome() {
        return Constant.BACK_DESK + "index";
    }

    @GetMapping("/login.html")
    public String login() {
        return Constant.BACK_DESK + "login";
    }

    @GetMapping("/loginlog.html")
    public String loginlog() {
        return Constant.BACK_DESK + "loginlog";
    }

    @GetMapping("/add-article.html")
    public String addArticle() {
        return Constant.BACK_DESK + "add-article";
    }

    @GetMapping("/add-category.html")
    public String addCategory() {
        return Constant.BACK_DESK + "add-category";
    }

    @GetMapping("/add-flink.html")
    public String addFlink() {
        return Constant.BACK_DESK + "add-flink";
    }

    @GetMapping("/add-notice.html")
    public String addNotice() {
        return Constant.BACK_DESK + "add-notice";
    }

    @GetMapping("/article.html")
    public String article() {
        return Constant.BACK_DESK + "article";
    }

    @GetMapping("/category.html")
    public String category() {
        return Constant.BACK_DESK + "category";
    }

    @GetMapping("/comment.html")
    public String comment() {
        return Constant.BACK_DESK + "comment";
    }

    @GetMapping("/flink.html")
    public String flink() {
        return Constant.BACK_DESK + "flink";
    }

    @GetMapping("/manage-user.html")
    public String manageUser() {
        return Constant.BACK_DESK + "manage-user";
    }

    @GetMapping("/notice.html")
    public String notice() {
        return Constant.BACK_DESK + "notice";
    }

    @GetMapping("/readset.html")
    public String readset() {
        return Constant.BACK_DESK + "readset";
    }

    @GetMapping("/setting.html")
    public String setting() {
        return Constant.BACK_DESK + "setting";
    }

    @GetMapping("/update-article.html")
    public String updateArticle() {
        return Constant.BACK_DESK + "update-article";
    }

    @GetMapping("/update-category.html")
    public String updateCategory() {
        return Constant.BACK_DESK + "update-category";
    }

    @GetMapping("/update-flink.html")
    public String updateFlink() {
        return Constant.BACK_DESK + "update-flink";
    }


}
