package com.changex.blog.tools;

import com.alibaba.fastjson.JSON;
import com.changex.blog.core.pojo.vo.BlogArticleVo;
import lombok.Data;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author Xie Chenxi
 * @date 2019-01-13 01:11
 */
public class HkpUtils {

    private static final String ADD_ARTICLE_URL = "https://rhythm.b3log.org/api/article";

    private static final String TITLE = "CHANGEX-SITE";

    private static final String HOST = "http://changex.site";

    private static final String EMAIL = "joexie9299@outlook.com";

    private static final String KEY = "changexsitekey9299";

    private static RestTemplate template = new RestTemplate();

    public static void addArticle(BlogArticleVo articleVo) {

        ArticleDTO article = new ArticleDTO();
        article.id = articleVo.getId() + "";
        article.title = articleVo.getTitle();
        article.content = articleVo.getContent();
        article.tags = articleVo.getKeyWord();
        article.permalink = "/detail.html?id=" + articleVo.getId();

        DTO dto = new DTO();
        dto.article = article;

        HttpHeaders headers = new HttpHeaders();
        //  请勿轻易改变此提交方式，大部分的情况下，提交方式都是表单提交
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        //  封装参数，千万不要替换为Map与HashMap，否则参数无法传递

        HttpEntity<String> requestEntity = new HttpEntity<>(JSON.toJSONString(dto), headers);

        String response = template.postForEntity(ADD_ARTICLE_URL, requestEntity, String.class).toString();
        System.out.println(JSON.toJSONString(response));
    }

    public static void main(String[] args) {
        BlogArticleVo blogArticleVo = new BlogArticleVo();
        blogArticleVo.setId(16);
        blogArticleVo.setTitle("Linux搭建SSR");
        blogArticleVo.setKeyWord("科学上网,SSR");
        blogArticleVo.setContent("<p style=\"text-align: center;\"><img src=\"http://changex.oss-cn-beijing.aliyuncs.com/blog_img/605f3c43889344e899b4ef5fc6a9ff0bimage?Expires=1862058526&OSSAccessKeyId=LTAI8EVf6JFCeu8E&Signature=8bgrMppt3QtwZXwhZAi6e43qHiQ%3D\" title=\"upfile\" alt=\"image.png\"/></p><p style=\"text-align: center;\"><img src=\"http://changex.oss-cn-beijing.aliyuncs.com/blog_img/8f92521cfb8d463c8862c291d470f8a4image?Expires=1862058547&OSSAccessKeyId=LTAI8EVf6JFCeu8E&Signature=ukJ1%2FbPF%2Bp0ZeDD%2B%2FbkjNOHTSBg%3D\" title=\"upfile\" alt=\"image.png\"/></p><p><strong>命令：</strong></p><pre class=\"brush:bash;toolbar:false\">wget&nbsp;--no-check-certificate&nbsp;https://freed.ga/github/shadowsocksR.sh;&nbsp;bash&nbsp;shadowsocksR.sh\r\nyum&nbsp;install&nbsp;wget&nbsp;-y</pre><p><strong>软件：</strong></p><p></p><p style=\"line-height: 16px;\"><img style=\"vertical-align: middle; margin-right: 2px;\" src=\"http://changex.site/dialogs/attachment/fileTypeImages/icon_txt.gif\"/><a style=\"font-size:12px; color:#0066cc;\" href=\"http://changex.oss-cn-beijing.aliyuncs.com/blog_img/d26b279c0f784281998100bc73e25ce8%E6%89%8B%E6%9C%BA%E7%94%B5%E8%84%91%E9%93%BE%E6%8E%A5%E8%BD%AF%E4%BB%B6?Expires=1862058646&OSSAccessKeyId=LTAI8EVf6JFCeu8E&Signature=CwPWe3CmH5VYGVD34Tl4ap6lf5A%3D\" title=\"手机电脑链接软件.zip\">手机电脑链接软件.zip</a></p><p><strong>解压密码：</strong>8fls</p><p style=\"text-align: center;\"><img src=\"http://changex.oss-cn-beijing.aliyuncs.com/blog_img/375fbb0c58834319bf8f04663fb6676cimage?Expires=1862058709&OSSAccessKeyId=LTAI8EVf6JFCeu8E&Signature=K64e9JFIOS6rmby13qP1IqgBy1E%3D\" title=\"upfile\" alt=\"image.png\"/></p>");
        //addArticle(blogArticleVo);
        System.out.println(blogArticleVo.getContent());
    }

    @Data
    private static class DTO {
        private ArticleDTO article;
        private Client client = new Client();
    }

    @Data
    private static class ArticleDTO {
        private String id;
        private String title;
        private String permalink;
        private String tags;
        private String content;
    }

    @Data
    private static class Client {
        private String title = "CHANGEX-SITE";
        private String host = "http://changex.site";
        private String email = "joexie9299@outlook.com";
        private String key = "changexsitekey9299";
    }

}
