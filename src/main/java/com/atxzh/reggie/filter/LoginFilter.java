package com.atxzh.reggie.filter;


import com.alibaba.fastjson.JSON;
import com.atxzh.reggie.common.BaseContext;
import com.atxzh.reggie.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Slf4j
@WebFilter(filterName = "LoginFilter",urlPatterns = "/*")
public class LoginFilter implements Filter {

    //路径匹配器
    public  static  final AntPathMatcher PATH_MATCHER = new AntPathMatcher();
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //获取本次请求的uri
        String requestURI = request.getRequestURI();
        log.info("拦截的请求{}",requestURI);

        //定义不需要处理的路径
        String[] urls = new String[]{
                "/employee/login",
                "/employee/logout",
                "/backend/**",
                "/front/**",
                "/common/**",
                "/user/sendMsg",
                "/user/login"
        };
        //判断本次请求是否需要处理
        boolean check = check(urls, requestURI);
        //如果不需要处理，直接放行
        if (check){
            log.info("本次请求{}不需要处理",requestURI);
            filterChain.doFilter(request,response);
            return;
        }
        //4-1判断登入状态，如果已登录，则直接放行
        if (request.getSession().getAttribute("employee")!=null){
            log.info("用户已登入，用户id为:{}",request.getSession().getAttribute("employee"));

            Long empId = (Long) request.getSession().getAttribute("employee");
            BaseContext.setCurrentId(empId);
            filterChain.doFilter(request,response);
            return;
        }

        //4-2判断登入状态，如果已登录，则直接放行
        if (request.getSession().getAttribute("user")!=null){
            log.info("用户已登入，用户id为:{}",request.getSession().getAttribute("user"));

            Long userId = (Long) request.getSession().getAttribute("user");
            BaseContext.setCurrentId(userId);
            filterChain.doFilter(request,response);
            return;
        }

        //如果未登入，则返回登入结果，通过输出流想客户端响应数据
        log.info("用户未登入");
        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));

    }

    /**
     * 匹配路径。检查本次请求是否需要放行
     * @param urls
     * @param requsetURI
     * @return
     */
    public boolean check(String[] urls, String requsetURI){
        for (String url:urls){
            boolean match = PATH_MATCHER.match(url, requsetURI);
            if (match){
                return true;
            }
        }
        return false;
    }
}
