package com.chan.investment.portfoliobacktestservice.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .components(new Components())
                .addServersItem(new Server().url("/"))
                .info(apiInfo());
    }

    private Info apiInfo() {
        return new Info()
                .title("Portfolio backtest service")
                .description("Portfolio backtest service")
                .version("1.0.0");
    }
}
