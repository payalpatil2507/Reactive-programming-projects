package com.example.demo.routerExample;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import org.springframework.stereotype.Component;

@Component
public class UserHandler {

    public Mono<ServerResponse> getUserById(ServerRequest request) {
        String userId = request.pathVariable("id");
        return ServerResponse.ok().bodyValue("User ID: " + userId);
    }

    public Mono<ServerResponse> createUser(ServerRequest request) {
        return ServerResponse.ok().bodyValue("User created!");
    }

    public Mono<ServerResponse> deleteUser(ServerRequest request) {
        String userId = request.pathVariable("id");
        return ServerResponse.ok().bodyValue("User ID " + userId + " deleted!");
    }

    public Mono<ServerResponse> updateUser(ServerRequest request) {
        String userId = request.pathVariable("id");
        return ServerResponse.ok().bodyValue("User ID " + userId + " updated!");
    }
}

