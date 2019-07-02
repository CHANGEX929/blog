package com.changex.blog.controller.wechat;

import com.changex.blog.tools.SHA1;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Xie Chenxi
 * @date 2019-01-22 10:49
 */
@RestController
@RequestMapping("/wx")
public class WechatController {

    private String key = "7371b13a43d9f9c15eb5a91d021a970b";
    private String app_id = "wx232c6460386b756f";
    private String token = "17_UzuVNyCPzXfiTpwvX9gbVx4D8OUTQgu798I9lBCeZaTdRHAZiDzCo-BQ6hYqSBd5Hmnl7xLjgT-Xp_2JPwMnsGW846vYi8EJ6rFMyOlKzYYPhfo6q6QjuehmOtgsG82IVse9mjQQpDFecrqaMBWiADAGVQ";

    @GetMapping("")
    public String check(HttpServletRequest request) {
        //获取Get请求携带参数
        String content = request.getQueryString();
        System.out.println(content);
        if (content.startsWith("signature")) {
            //检查消息是否来自微信服务器
            return CheckSignature(content);
        }
        return null;
    }

    public static String CheckSignature(String str) {
        String[] content = str.split("&");
        String signature = content[0].split("=")[1];
        String timestamp = content[2].split("=")[1];
        String nonce = content[3].split("=")[1];
        //第一步中填写的token一致
        String token = "CHANGEX929changex929";

        ArrayList<String> list = new ArrayList<String>();
        list.add(nonce);
        list.add(timestamp);
        list.add(token);

        //字典序排序
        Collections.sort(list);
        //SHA1加密
        String checksignature = SHA1.encode(list.get(0) + list.get(1) + list.get(2));
        System.out.println(signature);
        System.out.println(checksignature);

        if (checksignature.equals(signature)) {
            return content[1].split("=")[1];
        }
        return null;
    }
}
