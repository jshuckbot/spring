package ru.gb.apiGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
	@Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
                .route("notes-server",r->r.path("/notes/**")
                        .uri("http://localhost:8889/"))
                .route("tasks-server",r->r.path("/tasks/**")
                        .uri("http://localhost:8888/")).build();}
}
