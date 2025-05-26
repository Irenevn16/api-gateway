package api_gateway.api_gateway.config;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator (RouteLocatorBuilder builder) {
        return builder
                .routes()
                .route(p -> p.path("/api/students/**")
                        .uri("lb://STUDENT-INFO-SERVICE"))
                .route(p -> p.path("/api/grades/**")
                        .uri("lb://GRADES-DATA-SERVICE"))
                .route(p -> p.path("/api/catalog/**")
                        .uri("lb://STUDENT-CATALOG-SERVICE"))
                //.route() poner luego aqui las rutas
                .build();
    }
}