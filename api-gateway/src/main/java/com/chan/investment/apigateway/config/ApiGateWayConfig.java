package com.chan.investment.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGateWayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeBuilder) {
        return routeBuilder.routes()
                .route("securities-service-openapi", r -> {
                    return r.path("/api/securities-service/v3/api-docs/**")
                            .filters(f -> f.rewritePath(
                                    "/api/securities-service/(?<path>.*)", "/${path}"))
                            .uri("lb://SECURITIES-SERVICE");
                })
                .route("securities-service", r -> {
                    return r.path("/stockprice/**", "/stockinfo/**")
                            .uri("lb://SECURITIES-SERVICE");
                })
                .route("calculator-service-openapi", r -> {
                    return r.path("/api/calculator-service/v3/api-docs/**")
                            .filters(f -> f.rewritePath(
                                    "/api/calculator-service/(?<path>.*)", "/${path}"))
                            .uri("lb://CALCULATOR-SERVICE");
                })
                .route("calculator-service", r -> {
                    return r.path("/calculator/**")
                            .uri("lb://CALCULATOR-SERVICE");
                })
                .route("backtest-service-openapi", r -> {
                    return r.path("/api/backtest-service/v3/api-docs/**")
                            .filters(f -> f.rewritePath(
                                    "/api/backtest-service/(?<path>.*)", "/${path}"))
                            .uri("lb://BACKTEST-SERVICE");
                })
                .route("backtest-service", r -> {
                    return r.path("/backtest/**")
                            .uri("lb://BACKTEST-SERVICE");
                })
                .route("portfolio-backtest-service-openapi", r -> {
                    return r.path("/api/portfolio-backtest-service/v3/api-docs/**")
                            .filters(f -> f.rewritePath(
                                    "/api/portfolio-backtest-service/(?<path>.*)", "/${path}"))
                            .uri("lb://PORTFOLIO-BACKTEST-SERVICE");
                })
                .route("portfolio-backtest-service", r -> {
                    return r.path("/portfolio-backtest/**")
                            .uri("lb://PORTFOLIO-BACKTEST-SERVICE");
                })
                .route("portfolio-composition-service-openapi", r -> {
                    return r.path("/api/portfolio-composition-service/v3/api-docs/**")
                            .filters(f -> f.rewritePath(
                                    "/api/portfolio-composition-service/(?<path>.*)", "/${path}"))
                            .uri("lb://PORTFOLIO-COMPOSITION-SERVICE");
                })
                .route("portfolio-composition-service", r -> {
                    return r.path("/portfolio-composition/**")
                            .uri("lb://PORTFOLIO-COMPOSITION-SERVICE");
                })
                .route("portfolio-service-openapi", r -> {
                    return r.path("/api/portfolio-service/v3/api-docs/**")
                            .filters(f -> f.rewritePath(
                                    "/api/portfolio-service/(?<path>.*)", "/${path}"))
                            .uri("lb://PORTFOLIO-SERVICE");
                })
                .route("portfolio-service", r -> {
                    return r.path("/portfolio/**")
                            .uri("lb://PORTFOLIO-SERVICE");
                })
                .build();
    }
}
