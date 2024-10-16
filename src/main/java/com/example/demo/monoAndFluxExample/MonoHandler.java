package com.example.demo.monoAndFluxExample;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;

@Component
public class MonoHandler {

    public Mono<String> monoJust() {
        return Mono.just("Mono.just() example");
    }

    public Mono<String> monoEmpty() {
        return Mono.empty();
    }

    public Mono<String> monoError() {
        return Mono.error(new RuntimeException("Error occurred"));
    }

    public Mono<Long> monoDelay() {
        return Mono.delay(Duration.ofSeconds(2));
    }

    public Mono<String> monoFromCallable() {
        return Mono.fromCallable(() -> "Callable result");
    }

    public Mono<String> monoFromSupplier() {
        return Mono.fromSupplier(() -> "Supplier result");
    }

    public Mono<String> monoFromFuture() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Future result");
        return Mono.fromFuture(future);
    }

    public Mono<String> monoMap() {
        return Mono.just("hello").map(String::toUpperCase);
    }

    public Mono<String> monoFlatMap() {
        return Mono.just("flatMap").flatMap(val -> Mono.just(val + " transformed"));
    }

    public Mono<String> monoThen() {
        return Mono.just("ignored").then(Mono.just("result"));
    }

    public Mono<String> monoDoOnNext() {
        return Mono.just("value").doOnNext(val -> System.out.println("Value: " + val));
    }

    public Mono<String> monoDoOnSuccess() {
        return Mono.just("Success").doOnSuccess(val -> System.out.println("Success: " + val));
    }

    public Mono<Object> monoDoOnError() {
        return Mono.error(new RuntimeException("Error"))
                .doOnError(e -> System.out.println("Error: " + e.getMessage()));
    }

    public Mono<Object> monoOnErrorResume() {
        return Mono.error(new RuntimeException("Error"))
                .onErrorResume(e -> Mono.just("Fallback"));
    }

    public Mono<Object> monoOnErrorReturn() {
        return Mono.error(new RuntimeException("Error"))
                .onErrorReturn("Fallback value");
    }

    public Mono<Object> monoSwitchIfEmpty() {
        return Mono.empty().switchIfEmpty(Mono.just("Fallback"));
    }

    public Mono<Object> monoRetry() {
        return Mono.error(new RuntimeException("Error")).retry(3);
    }

    public Mono<String> monoZip() {
        return Mono.zip(Mono.just("First"), Mono.just("Second"),
                (a, b) -> a + " and " + b);
    }

    public Mono<String> monoBlock() {
        return Mono.just("Blocked value").doOnNext(value -> System.out.println(value));
    }

    public Mono<String> monoSubscribe() {
        return Mono.just("Subscribed").doOnNext(System.out::println);
    }

    public Mono<String> monoDoFinally() {
        return Mono.just("Final action").doFinally(signal -> System.out.println("Finally with: " + signal));
    }

    public Mono<String> monoDoOnTerminate() {
        return Mono.just("Terminating").doOnTerminate(() -> System.out.println("Terminated"));
    }

    public Mono<String> monoThenReturn() {
        return Mono.just("Ignored").thenReturn("New result");
    }

    public Mono<String> monoFilter() {
        return Mono.just("Filter me").filter(val -> val.contains("Filter"));
    }

    public Mono<String> monoLog() {
        return Mono.just("Log this").log();
    }
}
