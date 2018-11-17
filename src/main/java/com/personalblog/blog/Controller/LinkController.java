package com.personalblog.blog.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LinkController {
    @GetMapping("index.html")
    public String index(){    return "index";    }
    @GetMapping("update.html")
    public String update(){return "update";}
    @GetMapping("link.html")
    public String link(){return "link";}
    @GetMapping("archives.html")
    public String archives(){return "archives";}
    @GetMapping("gustbook.html")
    public String gustbook(){return "gustbook";}
    @GetMapping("detail.html")
    public String detail(){return "detail";}
    @GetMapping("search.html")
    public String search(){return "search";}



}
