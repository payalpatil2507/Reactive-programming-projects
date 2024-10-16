package com.example.demo.ContollerExample;

import com.example.demo.ContollerExample.User;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.WebExchangeBindException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {

    private final List<User> users = new ArrayList<>();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<User> createUser(@Valid @RequestBody Mono<User> userMono) {
        return userMono.doOnNext(users::add);
    }

    @GetMapping
    public Flux<User> getAllUsers() {
        return Flux.fromIterable(users);
    }

    @GetMapping("/{name}")
    public Mono<User> getUserByName(@PathVariable String name) {
        return Flux.fromIterable(users)
                .filter(user -> user.getName().equalsIgnoreCase(name))
                .next()
                .switchIfEmpty(Mono.error(new RuntimeException("User not found")));
    }

    // Handling validation errors
    @ExceptionHandler(WebExchangeBindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Mono<Map<String, String>> handleValidationExceptions(WebExchangeBindException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        return Mono.just(errors);  // Return validation errors as a Mono
    }
}
