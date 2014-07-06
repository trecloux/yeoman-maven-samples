package com.github.trecloux.yeoman.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(final ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(Config.class);
        context.setServletContext(servletContext);
        ServletRegistration.Dynamic servlet = servletContext.addServlet("rest", new DispatcherServlet(context));
        servlet.addMapping("/rest/*");
        servlet.setLoadOnStartup(1);
    }
}
