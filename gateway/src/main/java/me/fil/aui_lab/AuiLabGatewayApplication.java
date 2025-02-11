package me.fil.aui_lab;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AuiLabGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuiLabGatewayApplication.class, args);
    }

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder,
                                     @Value("${film.microservice.url}") String filmMicroserviceUrl,
                                     @Value("${film_repository.microservice.url}") String filmRepositoryMicroserviceUrl,
                                     @Value("${gateway.host}") String host) {
        return builder
                .routes()
                .route("categories", route -> route
                        .host(host)
                        .and()
                        .path(
                                "/api/categories/{uuid}",
                                "/api/categories"
                        )
                        .uri(filmRepositoryMicroserviceUrl)
                )
                .route("films", route -> route
                        .host(host)
                        .and()
                        .path(
                                "/api/films/{uuid}",
                                "/api/films",
                                "/api/categories/{uuid}/films"
                        )
                        .uri(filmMicroserviceUrl)
                )
                .build();
    }
}
