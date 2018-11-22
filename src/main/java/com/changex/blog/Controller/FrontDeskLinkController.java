package com.changex.blog.Controller;

import com.changex.blog.config.Constant;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;

/**
 * @Author Xie Chenxi
 * @Date 2018/11/18 4:39
 */
@Controller
public class FrontDeskLinkController {

    @GetMapping("")
    public String welcome() {
        return Constant.FRONT_DESK + "index";
    }


    @GetMapping("index.html")
    public String index() {
        return Constant.FRONT_DESK + "index";
    }

    @GetMapping("update.html")
    public String update() {
        return Constant.FRONT_DESK + "update";
    }

    @GetMapping("link.html")
    public String link() {
        return Constant.FRONT_DESK + "link";
    }

    @GetMapping("archives.html")
    public String archives() {
        return Constant.FRONT_DESK + "archives";
    }

    @GetMapping("gustbook.html")
    public String gustbook() {
        return Constant.FRONT_DESK + "gustbook";
    }

    @GetMapping("detail.html")
    public String detail() {
        return Constant.FRONT_DESK + "detail";
    }

    @GetMapping("search.html")
    public String search() {
        return Constant.FRONT_DESK + "search";
    }
}
