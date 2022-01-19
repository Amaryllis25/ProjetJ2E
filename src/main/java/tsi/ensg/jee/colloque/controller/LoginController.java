package tsi.ensg.jee.colloque.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoginController implements WebMvcConfigurer {
    
	public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
		registry.addViewController("/site").setViewName("site");
        registry.addViewController("/login").setViewName("login");
	}
}
