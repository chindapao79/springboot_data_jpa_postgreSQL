package com.api.demo.security;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfiguration implements WebMvcConfigurer {
        @Bean
        public Docket api() {
                return new Docket(DocumentationType.SWAGGER_2)
                                .select()
                                .apis(RequestHandlerSelectors.any())
                                .paths(PathSelectors.any())
                                .build()
                                .apiInfo(metaInfo());
        }

        private ApiInfo metaInfo() {

                return new ApiInfo(
                                "Cursos API REST",
                                "API REST de registro de alunos.",
                                "1.0",
                                "Terms of Service",
                                new Contact("Romulo Sorato",
                                                "https://www.linkedin.com/in/r%C3%B4mulo-sorato-domingos-a6524437/",
                                                "romulosorato@hotmail.com"),
                                "Apache License Version 2.0",
                                "https://www.apache.org/licesen.html", new ArrayList<>());

        }

        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
                registry.addResourceHandler("swagger-ui.html")
                                .addResourceLocations("classpath:/META-INF/resources/");

                registry.addResourceHandler("/webjars/**")
                                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        }

}
