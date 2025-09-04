package com.zzs.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

// 启动类：流程

/**
 * Tomcat 启动 → 发现 ServletConfig（因为实现了 WebApplicationInitializer 机制）。
 *
 * Spring 调用 getRootConfigClasses() → 创建 Root 容器（加载 SpringConfig，里面有数据库 & Service）。
 *
 * Spring 调用 getServletConfigClasses() → 创建 Servlet 容器（加载 SpringMvcConfig，里面有 Controller & ViewResolver）。
 *
 * DispatcherServlet 被注册到 / 路径，负责接收所有请求。
 *
 * 注册过滤器（UTF-8 编码），保证请求/响应不会乱码。
 */

public class ServletConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    // Root 容器（父容器），即Spring容器，一般存放 业务层（Service）、数据层（DAO）、数据库配置、事务配置。
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    // Servlet 容器（子容器），即SpringMVC容器，一般存放 控制器（Controller）、视图解析器（ViewResolver）、格式化器（Formatters），拦截器。
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMvcConfig.class};
    }

    // 配置 DispatcherServlet前端控制器 的映射路径
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    // 添加过滤器：解决中文乱码问题
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        return new Filter[]{filter};
    }

}
