package me.ztiany.springboot.web.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 注入自己的 Servlet 组件。
 */
@Configuration
@Slf4j
public class AppServletConfiguration {

    @Bean
    public FilterRegistrationBean<LogFilter> provideFilterRegistrationBean() {
        log.debug("AppServletConfiguration.provideFilterRegistrationBean");

        FilterRegistrationBean<LogFilter> filterRegistrationBean = new FilterRegistrationBean<>();

        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setOrder(0);
        filterRegistrationBean.setFilter(new LogFilter());

        return filterRegistrationBean;
    }

    public static final class LogFilter implements Filter {

        @Override
        public void init(FilterConfig filterConfig) {
            log.debug("LogFilter.init");
        }

        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
            log.debug("request--------------------->" + ((HttpServletRequest) request).getRequestURL());
            chain.doFilter(request, response);
        }

        @Override
        public void destroy() {
            Filter.super.destroy();
        }

    }

}