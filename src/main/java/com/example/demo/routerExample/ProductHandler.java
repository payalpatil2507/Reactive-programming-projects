package com.example.demo.routerExample;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import org.springframework.stereotype.Component;

@Component
public class ProductHandler {

    public Mono<ServerResponse> getProductById(ServerRequest request) {
        String productId = request.pathVariable("id");
        return ServerResponse.ok().bodyValue("Product ID: " + productId);
    }

    public Mono<ServerResponse> createProduct(ServerRequest request) {
        return ServerResponse.ok().bodyValue("Product created!");
    }

    public Mono<ServerResponse> deleteProduct(ServerRequest request) {
        String productId = request.pathVariable("id");
        return ServerResponse.ok().bodyValue("Product ID " + productId + " deleted!");
    }

    public Mono<ServerResponse> updateProduct(ServerRequest request) {
        String productId = request.pathVariable("id");
        return ServerResponse.ok().bodyValue("Product ID " + productId + " updated!");
    }
}

