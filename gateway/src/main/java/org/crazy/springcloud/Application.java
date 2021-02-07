package org.crazy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.function.Function;

/**
 * @author chenyao
 * @date 2020/2/17 20:25
 * @description
 */
@SpringBootApplication
@RestController
@EnableConfigurationProperties(UriConfiguration.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
    @RequestMapping("/fallback")
    public Mono<String> fallback() {
        return Mono.just("fallback");
    }
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder,UriConfiguration uriConfiguration) {
        String httpUri = uriConfiguration.getHttpbin();

        return builder.routes()
                .route(p -> p
                        .path("/get")
                        .filters(f -> f.addRequestHeader("Hello", "World"))
                        .uri(httpUri))
                .route(p -> p
                        .host("*.hystrix.com")
                        .filters(f -> f.hystrix(config ->
                                                        config.setName("mycmd")
                                                              .setFallbackUri("forward:/fallback")))
                        .uri(httpUri))
                .build();
    }
}
