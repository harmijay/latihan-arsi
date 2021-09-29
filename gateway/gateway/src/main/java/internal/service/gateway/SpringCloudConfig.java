package internal.service.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("service-A",r -> r.path("/a/**")
                        .uri("http://localhost:7871/**"))
                .route("service-B",r -> r.path("/b/**")
                        .uri("http://localhost:7872/**"))
                .route("service-C",r -> r.path("/c/**")
                        .uri("http://localhost:7873/**"))
                .build();
    }

}