package com.codegym.config;

import com.codegym.DAO.product.IProductDAO;
import com.codegym.DAO.product.ProductDAO;
import com.codegym.service.product.IProductService;
import com.codegym.service.product.ProductService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.codegym")
public class AppConfig extends WebMvcConfigurerAdapter {
    @Bean
    public ViewResolver ViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
    @Bean
    public IProductDAO productDAO() {
        return new ProductDAO();
    }

    @Bean
    public IProductService productService() {
        return new ProductService(productDAO());
    }
}
