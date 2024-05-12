package com.librarymanagement.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI(){
        Server server = new Server();
        server.setUrl("http://localhost:8001");
        server.setDescription("Development Environment");

        Contact contact = new Contact();
        contact.setEmail("support@librarymanagement.com");
        contact.setName("Library Management Service API");
        contact.setUrl("https://www.librarymanagement.com");

        License mitLicense = new License().name("Library Management Software License")
                .url("https://www.librarymanagement.com/licenses/");

        Info info = new Info()
                .title("Library Management Service")
                .version("1.0")
                .contact(contact)
                .description("This API exposes endpoints for the Library Management Service.")
                .termsOfService("https://www.librarymanagement.com/terms-of-service")
                .license(mitLicense);

        return new OpenAPI().info(info).servers(List.of(server));
    }

}
