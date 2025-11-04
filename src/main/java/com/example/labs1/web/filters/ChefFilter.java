//package com.example.labs1.web.filters;
//
//import jakarta.servlet.*;
//import jakarta.servlet.annotation.WebFilter;
//import jakarta.servlet.annotation.WebInitParam;
//
//import java.io.IOException;
//
//@WebFilter(filterName = "dish-filter", urlPatterns = "/*",
//        dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD},
//        initParams = @WebInitParam(name = "ignore-path", value = "/login")
//)
//public class ChefFilter implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//
//    }
//
//    @Override
//    public void destroy() {
//        Filter.super.destroy();
//    }
//}
