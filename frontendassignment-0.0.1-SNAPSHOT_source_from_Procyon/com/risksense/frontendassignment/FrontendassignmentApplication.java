// 
// Decompiled by Procyon v0.5.36
// 

package com.risksense.frontendassignment;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import org.springframework.boot.SpringApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Configuration
@ControllerAdvice
@EnableSwagger2
public class FrontendassignmentApplication
{
    public static void main(final String[] args) {
        SpringApplication.run((Class)FrontendassignmentApplication.class, args);
    }
    
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any()).paths(PathSelectors.ant("/api/jobdescriptions/*")).build().apiInfo(this.metaData());
    }
    
    private ApiInfo metaData() {
        return new ApiInfoBuilder().title("RiskSense REST API").description("\"RiskSense REST API for front end assignment. ([datasource](http://localhost:9090/h2-console))\"").version("1.0.0").build();
    }
}
