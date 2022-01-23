package de.htwberlin.f4.apigateway.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI productOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("API Gateway")
                        .description("Access Calculator-Microservice and Product-Microservice")
                        .version("v1.0.1")
                        .license(new License().name("HTW Berlin").url("https://www.htw-berlin.de/")))
                .externalDocs(new ExternalDocumentation().description("Product API Source Code")
                        .url("https://github.com/GlebTanaka/kbe-api-gateway"));
    }
}
