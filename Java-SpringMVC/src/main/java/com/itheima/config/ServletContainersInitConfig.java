package com.itheima.config;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

//注意：这个项目必须右键项目名maven:tomcat运行, 在/save页面才能看到回显


// SpringMVC固定模板：

// 定义一个servlet容器启动类的配置类，在里面加载spring配置
public class ServletContainersInitConfig extends AbstractDispatcherServletInitializer {
    // 在tomcat启动时，加载springMVC容器配置
    @Override
    protected WebApplicationContext createServletApplicationContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(SpringMvcConfig.class);
        return context;
    }

    // 设置哪些请求归属springMVC处理: 所有请求
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    // 加载spring容器配置，这个demo我们暂时不用spring，故返回Null即可
    @Override
    protected WebApplicationContext createRootApplicationContext() {
        return null;
    }
}
