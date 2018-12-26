package com.changex.blog.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Xie Chenxi
 * @date 2018-12-22 12:04
 */
public class SessionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        System.out.println("uri=" + request.getRequestURI());

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

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
