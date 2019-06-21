package com.changex.blog.interceptor;

import com.alibaba.fastjson.JSON;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Xie Chenxi
 * @date 2018-12-22 12:04
 */
public class SessionInterceptor implements HandlerInterceptor {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(SessionInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

        //静态资源不打印
        if(!isStaticUrl(request.getRequestURI())){
            logger.info("uri:" + request.getRequestURI());
            logger.info("PARAM:" + JSON.toJSONString(request.getParameterMap()));
        }

        //登录不做拦截
        if (request.getRequestURI().equals("/back/login.html") || request.getRequestURI().equals("/back/login")) {
            return true;
        }
        //验证session是否存在
        if ((request.getRequestURI().contains("back")
                && request.getRequestURI().contains(".html"))
                || request.getRequestURI().contains("swagger-ui")) {
            Object obj = request.getSession().getAttribute("admin");
            if (obj == null) {
                response.sendRedirect("/back/login.html");
                return false;
            }
        }
        return true;
    }

    private boolean isStaticUrl(String uri){
        if(uri.startsWith("/css")){
            return true;
        }
        if(uri.startsWith("/dialogs")){
            return true;
        }
        if(uri.startsWith("/fonts")){
            return true;
        }
        if(uri.startsWith("/images")){
            return true;
        }
        if(uri.startsWith("/js")){
            return true;
        }
        if(uri.startsWith("/lang")){
            return true;
        }
        if(uri.startsWith("/themes")){
            return true;
        }
        if(uri.startsWith("/third-party")){
            return true;
        }
        if(uri.startsWith("/baidu_verify_2LMBwLjT3v.html")){
            return true;
        }
        if(uri.startsWith("/ueditor.all.js")){
            return true;
        }
        if(uri.startsWith("ueditor.config.js")){
            return true;
        }
        if(uri.startsWith("ueditor.parse.js")){
            return true;
        }
        if(uri.startsWith("/error")){
            return true;
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
