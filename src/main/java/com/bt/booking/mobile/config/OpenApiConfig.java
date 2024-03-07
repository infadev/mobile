package com.bt.booking.mobile.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class OpenApiConfig {

    @Bean
    public OpenAPI OpenAPI() {
        return new OpenAPI().info(new Info()
                .title("Mobile Booking Application")
                .description("Testing team mobile booking application. User can list, book and return mobile phones. \n\n" +
                        " Main Functionalities:\n 1. Employees - List, Add, Delete Employees \n" +
                        "2. Mobile - List, Add, Delete Mobile Details \n" +
                        "3. Bookings- Reserve mobile for user, release, view reserved mobiles etc."));
    }
}
