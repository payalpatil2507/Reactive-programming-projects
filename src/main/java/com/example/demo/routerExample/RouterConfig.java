package com.example.demo.routerExample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfig {

    @Bean
    public RouterFunction<ServerResponse> mainRouter(UserHandler userHandler, ProductHandler productHandler) {
        return RouterFunctions.route()
                .path("/api", builder -> builder
                        .add(userRouter(userHandler))     // Add user routes
                        .add(productRouter(productHandler)) // Add product routes
                )
                .build();
    }

    private RouterFunction<ServerResponse> userRouter(UserHandler userHandler) {
        // Use RouterFunctions.route() for each route and chain them using .and()
        return RouterFunctions.route(RequestPredicates.GET("/{id}"), userHandler::getUserById)
                .andRoute(RequestPredicates.POST("/create"), userHandler::createUser) // Add POST route
                .andRoute(RequestPredicates.DELETE("/{id}"), userHandler::deleteUser) // Add DELETE route
                .andRoute(RequestPredicates.PUT("/{id}"), userHandler::updateUser); // Add PUT route
    }


    private RouterFunction<ServerResponse> productRouter(ProductHandler productHandler) {
        return RouterFunctions.nest(RequestPredicates.path("/products"),  // Nest all routes under '/products'
                RouterFunctions.route(RequestPredicates.GET("/{id}"), productHandler::getProductById)
                        .andRoute(RequestPredicates.POST("/create"), productHandler::createProduct)  // POST route
                        .andRoute(RequestPredicates.DELETE("/{id}"), productHandler::deleteProduct)  // DELETE route
                        .andRoute(RequestPredicates.PUT("/{id}"), productHandler::updateProduct)     // PUT route
        );
    }


}
