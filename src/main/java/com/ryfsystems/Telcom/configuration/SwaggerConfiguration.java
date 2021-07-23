package com.ryfsystems.Telcom.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Value("${spring.application.name}")
    private String applicationName;

    @Bean
    public Docket serviceApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Infrastructure")
                .apiInfo(serviceApiInfo()).select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo serviceApiInfo() {

        return new ApiInfoBuilder()
                .title(applicationName)
                .description("Microservices Farm to Manage Administrative Operations")
                .version("1.0.0")
                .termsOfServiceUrl("Null")
                .licenseUrl("https://help.github.com/articles/open-source-licensing/")
                .contact(new Contact("Ing. Rayne Flores", "","raynitoflores@gmail.com"))
                .build();

    }

}
