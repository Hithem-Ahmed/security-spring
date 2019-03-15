package com.example.demo.h2;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

@Configuration
public class WebConfiguration implements ServletContextInitializer {

    private final Logger log = LoggerFactory.getLogger(WebConfiguration.class);

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        initH2Console(servletContext);
    }

    private void initH2Console(ServletContext servletContext) {
        log.info("Starting H2 console");
        ServletRegistration.Dynamic h2ConsoleServlet = servletContext.addServlet("H2Console",
                new org.h2.server.web.WebServlet());
        h2ConsoleServlet.addMapping("/h2/*");
        h2ConsoleServlet.setLoadOnStartup(1);
    }
}