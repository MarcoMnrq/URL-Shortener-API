package com.marco.urlshortener.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean(name = "easystoryOpenApi")
    public OpenAPI easystoryOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("URL Shortener API")
                        .description("Spring Boot RESTful service and documented using springdoc-openapi and OpenAPI 3.0"));
    }

}