package com.oklimenko.sampleapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger config for auto generation of REST API documentation.
 * Do not forget disable it for PROD (for most of Enterprise cases this is required).
 *
 * @author oklimenko@gmail.com
 */
@EnableSwagger2
@Configuration
@Profile("!prod")
public class SwaggerConfiguration {

    @Value("${springfox.documentation.service-version}")
    private String serviceVersion;

    @Value("${sampleapp.documentaion-url}")
    private String documentationUrl;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.oklimenko.sampleapp"))
                .paths(PathSelectors.any())
                .build()
                .tags(new Tag("Sampleapp", "API for payment"))
                .apiInfo(apiEndPointsInfo());
    }

    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder()
                .title("API for service payment")
                .description("")
                .contact(new Contact("Link to documentation", documentationUrl, ""))
                .version(serviceVersion)
                .build();
    }
}