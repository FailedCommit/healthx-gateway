package com.maat.healthxgateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

  @Value("${server.url}")
  private String serverUrl;

  @Bean
  public RouteLocator myRoutes(RouteLocatorBuilder builder) {
    return builder.routes()
            .route(p -> p
                    .path("/metric/**")
                    .uri(serverUrl + "/metric"))
            .route(p -> p
                    .path("/profile/**")
                    .uri(serverUrl + "/profile"))
            .route(p -> p
                    .path("/advice/**")
                    .uri(serverUrl + "/advice"))
            .build();
  }
}
