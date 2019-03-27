package org.superbiz.struts;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;
import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.Filter;


import static java.util.Collections.singletonList;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public FilterRegistrationBean sitemeshFilterRegistrationBean() {
/*        FilterRegistrationBean<SiteMeshFilter> result = new FilterRegistrationBean<SiteMeshFilter>(new SiteMeshFilter());
        result.setName("sitemeshFilter");
        result.addUrlPatterns(new String[]{"/*"});  // Comma separated url patterns.
        result.setOrder(0);
        return result;*/
        return buildFilterRegistration(0,new SiteMeshFilter());
    }

    @Bean
    public FilterRegistrationBean StrutsPrepareAndExecuteFilterRegistrationBean()
    {
/*        FilterRegistrationBean<StrutsPrepareAndExecuteFilter> result =new FilterRegistrationBean<StrutsPrepareAndExecuteFilter>(new StrutsPrepareAndExecuteFilter());
        result.setName("StrutsPrepareAndExecuteFilter");
        result.addUrlPatterns(new String[]{"/*"});
        result.setOrder(1);*/
        return buildFilterRegistration(1,new StrutsPrepareAndExecuteFilter());
    }

    private FilterRegistrationBean buildFilterRegistration(int order, Filter filter){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(filter);
        filterRegistrationBean.setUrlPatterns(singletonList("/*"));
        filterRegistrationBean.setOrder(order);
        return filterRegistrationBean;
    }
}

