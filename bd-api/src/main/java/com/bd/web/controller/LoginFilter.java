package com.bd.web.controller;

import com.bd.common.exception.GlobalException;
import com.bd.common.utils.StringUtils;
import com.bd.system.domain.SysUser;
import com.bd.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author luxuewei
 * @since 2019/4/30
 */
@Order(1)
//@WebFilter(filterName = "loginFilter", urlPatterns = "/*")
public class LoginFilter implements Filter {

    @Autowired
    private ISysUserService userService ;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String token = request.getParameter("token");
        String userId = request.getParameter("userId");

        if(StringUtils.isEmpty(token) || StringUtils.isEmpty(userId)) {
            throw new GlobalException("请求参数不完整");
        }

        SysUser sysUser = userService.selectUserById(Long.parseLong(userId));

        if(StringUtils.isNull(sysUser) ){
            throw new GlobalException("无此用户"+userId);
        }

        if(!token.equals(sysUser.getToken())){
            throw new GlobalException("token值错误");
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }

}
