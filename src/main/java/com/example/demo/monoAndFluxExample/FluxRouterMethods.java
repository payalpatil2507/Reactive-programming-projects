package com.example.demo.monoAndFluxExample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.util.List;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class FluxRouterMethods {

    @Bean
    public RouterFunction<ServerResponse> fluxRouter(FluxHandler handler) {
        return route(GET("/flux/just"), request -> ServerResponse.ok().body(handler.fluxJust(), String.class))
                .andRoute(GET("/flux/empty"), request -> ServerResponse.ok().body(handler.fluxEmpty(), String.class))
                .andRoute(GET("/flux/error"), request -> ServerResponse.ok().body(handler.fluxError(), String.class))
                .andRoute(GET("/flux/delay"), request -> ServerResponse.ok().body(handler.fluxDelay(), Long.class))
                .andRoute(GET("/flux/fromIterable"), request -> ServerResponse.ok().body(handler.fluxFromIterable(), String.class))
                .andRoute(GET("/flux/fromStream"), request -> ServerResponse.ok().body(handler.fluxFromStream(), String.class))
                .andRoute(GET("/flux/map"), request -> ServerResponse.ok().body(handler.fluxMap(), String.class))
                .andRoute(GET("/flux/flatMap"), request -> ServerResponse.ok().body(handler.fluxFlatMap(), String.class))
                .andRoute(GET("/flux/merge"), request -> ServerResponse.ok().body(handler.fluxMerge(), String.class))
                .andRoute(GET("/flux/filter"), request -> ServerResponse.ok().body(handler.fluxFilter(), String.class))
                .andRoute(GET("/flux/doOnNext"), request -> ServerResponse.ok().body(handler.fluxDoOnNext(), String.class))
                .andRoute(GET("/flux/retry"), request -> ServerResponse.ok().body(handler.fluxRetry(), String.class))
                .andRoute(GET("/flux/zip"), request -> ServerResponse.ok().body(handler.fluxZip(), String.class))
                .andRoute(GET("/flux/block"), request -> ServerResponse.ok().body(handler.fluxBlock(), String.class))
                .andRoute(GET("/flux/subscribe"), request -> ServerResponse.ok().body(handler.fluxSubscribe(), String.class))
                .andRoute(GET("/flux/doFinally"), request -> ServerResponse.ok().body(handler.fluxDoFinally(), String.class))
                .andRoute(GET("/flux/onErrorResume"), request -> ServerResponse.ok().body(handler.fluxOnErrorResume(), String.class))
                .andRoute(GET("/flux/onErrorReturn"), request -> ServerResponse.ok().body(handler.fluxOnErrorReturn(), String.class))
                .andRoute(GET("/flux/switchIfEmpty"), request -> ServerResponse.ok().body(handler.fluxSwitchIfEmpty(), String.class))
                .andRoute(GET("/flux/log"), request -> ServerResponse.ok().body(handler.fluxLog(), String.class))
                .andRoute(GET("/flux/range"), request -> ServerResponse.ok().body(handler.fluxRange(), Integer.class))
                .andRoute(GET("/flux/delayElements"), request -> ServerResponse.ok().body(handler.fluxDelayElements(), String.class))
                .andRoute(GET("/flux/concat"), request -> ServerResponse.ok().body(handler.fluxConcat(), String.class))
                .andRoute(GET("/flux/combineLatest"), request -> ServerResponse.ok().body(handler.fluxCombineLatest(), String.class))
                .andRoute(GET("/flux/distinct"), request -> ServerResponse.ok().body(handler.fluxDistinct(), String.class))
                .andRoute(GET("/flux/interval"), request -> ServerResponse.ok().body(handler.fluxInterval(), Long.class))
                .andRoute(GET("/flux/flatMapToCharacters"), request -> ServerResponse.ok().body(handler.fluxFlatMapToCharacters(), Character.class))
                .andRoute(GET("/flux/doOnComplete"), request -> ServerResponse.ok().body(handler.fluxDoOnComplete(), String.class))
                .andRoute(GET("/flux/skip"), request -> ServerResponse.ok().body(handler.fluxSkip(), String.class))
                .andRoute(GET("/flux/take"), request -> ServerResponse.ok().body(handler.fluxTake(), String.class))
                .andRoute(GET("/flux/takeWhile"), request -> ServerResponse.ok().body(handler.fluxTakeWhile(), String.class))
                .andRoute(GET("/flux/repeat"), request -> ServerResponse.ok().body(handler.fluxRepeat(), String.class))
                .andRoute(GET("/flux/delayError"), request -> ServerResponse.ok().body(handler.fluxDelayError(), String.class))
                .andRoute(GET("/flux/collectList"), request -> ServerResponse.ok().body(handler.fluxCollectList(), List.class))
                .andRoute(GET("/flux/mergeMultiple"), request -> ServerResponse.ok().body(handler.fluxMergeMultiple(), String.class))
                .andRoute(GET("/flux/timeout"), request -> ServerResponse.ok().body(handler.fluxTimeout(), String.class))
                .andRoute(GET("/flux/expand"), request -> ServerResponse.ok().body(handler.fluxExpand(), String.class))
                .andRoute(GET("/flux/reduceWith"), request -> ServerResponse.ok().body(handler.fluxReduceWith(), Integer.class))
                .andRoute(GET("/flux/expandDeep"), request -> ServerResponse.ok().body(handler.fluxExpandDeep(), String.class)); // Route for expandDeep
    }
}

