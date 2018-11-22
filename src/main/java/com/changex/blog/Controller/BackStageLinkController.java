package com.changex.blog.Controller;

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

}
