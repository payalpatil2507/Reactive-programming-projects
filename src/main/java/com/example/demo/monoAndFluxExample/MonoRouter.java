package com.example.demo.monoAndFluxExample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class MonoRouter {

    @Bean
    public RouterFunction<ServerResponse> monoRouter(MonoHandler handler) {
        return route(GET("/mono/just"), request -> ServerResponse.ok().body(handler.monoJust(), String.class))
                .andRoute(GET("/mono/empty"), request -> ServerResponse.ok().body(handler.monoEmpty(), String.class))
                .andRoute(GET("/mono/error"), request -> ServerResponse.ok().body(handler.monoError(), String.class))
                .andRoute(GET("/mono/delay"), request -> ServerResponse.ok().body(handler.monoDelay(), Long.class))
                .andRoute(GET("/mono/fromCallable"), request -> ServerResponse.ok().body(handler.monoFromCallable(), String.class))
                .andRoute(GET("/mono/fromSupplier"), request -> ServerResponse.ok().body(handler.monoFromSupplier(), String.class))
                .andRoute(GET("/mono/fromFuture"), request -> ServerResponse.ok().body(handler.monoFromFuture(), String.class))
                .andRoute(GET("/mono/map"), request -> ServerResponse.ok().body(handler.monoMap(), String.class))
                .andRoute(GET("/mono/flatMap"), request -> ServerResponse.ok().body(handler.monoFlatMap(), String.class))
                .andRoute(GET("/mono/then"), request -> ServerResponse.ok().body(handler.monoThen(), String.class))
                .andRoute(GET("/mono/doOnNext"), request -> ServerResponse.ok().body(handler.monoDoOnNext(), String.class))
                .andRoute(GET("/mono/doOnSuccess"), request -> ServerResponse.ok().body(handler.monoDoOnSuccess(), String.class))
                .andRoute(GET("/mono/doOnError"), request -> ServerResponse.ok().body(handler.monoDoOnError(), String.class))
                .andRoute(GET("/mono/onErrorResume"), request -> ServerResponse.ok().body(handler.monoOnErrorResume(), String.class))
                .andRoute(GET("/mono/onErrorReturn"), request -> ServerResponse.ok().body(handler.monoOnErrorReturn(), String.class))
                .andRoute(GET("/mono/switchIfEmpty"), request -> ServerResponse.ok().body(handler.monoSwitchIfEmpty(), String.class))
                .andRoute(GET("/mono/retry"), request -> ServerResponse.ok().body(handler.monoRetry(), String.class))
                .andRoute(GET("/mono/zip"), request -> ServerResponse.ok().body(handler.monoZip(), String.class))
                .andRoute(GET("/mono/block"), request -> ServerResponse.ok().body(handler.monoBlock(), String.class))
                .andRoute(GET("/mono/subscribe"), request -> ServerResponse.ok().body(handler.monoSubscribe(), String.class))
                .andRoute(GET("/mono/doFinally"), request -> ServerResponse.ok().body(handler.monoDoFinally(), String.class))
                .andRoute(GET("/mono/doOnTerminate"), request -> ServerResponse.ok().body(handler.monoDoOnTerminate(), String.class))
                .andRoute(GET("/mono/thenReturn"), request -> ServerResponse.ok().body(handler.monoThenReturn(), String.class))
                .andRoute(GET("/mono/filter"), request -> ServerResponse.ok().body(handler.monoFilter(), String.class))
                .andRoute(GET("/mono/log"), request -> ServerResponse.ok().body(handler.monoLog(), String.class));
    }
}


