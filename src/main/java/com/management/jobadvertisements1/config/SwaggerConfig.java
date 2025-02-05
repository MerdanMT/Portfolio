package com.management.jobadvertisements1.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class SwaggerConfig {

    @Bean
    public OpenAPI getOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Job Advertisements API")
                        .version("v1")
                        .description("Job Advertisements Backend APIs")
                        .contact(new Contact()
                                .url("https://www.linkedin.com/in/merdan-memmedov-449bb8181/")
                                .email("memmedovmerdan686@gmail.com")
                                .name("Merdan Memmedov")
                        )
                );
    }
}

