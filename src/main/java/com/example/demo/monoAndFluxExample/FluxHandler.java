package com.example.demo.monoAndFluxExample;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

@Component
public class FluxHandler {

    // Returns a Flux with a single value
    public Flux<String> fluxJust() {
        return Flux.just("Hello, Flux!");
    }

    // Returns an empty Flux
    public Flux<String> fluxEmpty() {
        return Flux.empty();
    }

    // Simulates an error scenario
    public Flux<String> fluxError() {
        return Flux.error(new RuntimeException("Simulated error"));
    }

    // Returns a Flux with delayed emission of values
    public Flux<Long> fluxDelay() {
        return Flux.interval(Duration.ofSeconds(1)).take(5); // Emits values every second for 5 seconds
    }

    // Returns a Flux from an Iterable
    public Flux<String> fluxFromIterable() {
        List<String> items = Arrays.asList("Item 1", "Item 2", "Item 3");
        return Flux.fromIterable(items);
    }

    // Returns a Flux from a Stream
    public Flux<String> fluxFromStream() {
        return Flux.fromStream(Arrays.asList("Stream Item 1", "Stream Item 2", "Stream Item 3").stream());
    }

    // Maps values in the Flux
    public Flux<String> fluxMap() {
        return Flux.just("apple", "banana", "cherry")
                .map(String::toUpperCase); // Transforms to uppercase
    }

    // Flat maps values in the Flux
    public Flux<String> fluxFlatMap() {
        return Flux.just("A", "B", "C")
                .flatMap(letter -> Flux.just(letter + "1", letter + "2", letter + "3")); // Creates multiple items from each letter
    }

    // Merges two Flux streams
    public Flux<String> fluxMerge() {
        Flux<String> flux1 = Flux.just("A1", "A2", "A3");
        Flux<String> flux2 = Flux.just("B1", "B2", "B3");
        return Flux.merge(flux1, flux2); // Merges both streams
    }

    // Filters values in the Flux
    public Flux<String> fluxFilter() {
        return Flux.just("apple", "banana", "cherry", "date")
                .filter(fruit -> fruit.startsWith("b")); // Filters fruits starting with "b"
    }

    // Executes a side effect on each element
    public Flux<String> fluxDoOnNext() {
        return Flux.just("1", "2", "3")
                .doOnNext(item -> System.out.println("Processing item: " + item)); // Logs each item
    }

    // Retries the Flux upon error
    public Flux<String> fluxRetry() {
        return Flux.<String>error(new RuntimeException("Simulated error"))
                .retry(3) // Retries 3 times on error
                .onErrorReturn("Fallback value"); // Provides a fallback value
    }

    // Zips two Flux streams together
    public Flux<String> fluxZip() {
        Flux<String> flux1 = Flux.just("A", "B", "C");
        Flux<Integer> flux2 = Flux.just(1, 2, 3);
        return Flux.zip(flux1, flux2, (letter, number) -> letter + number); // Combines items
    }

    // Blocks to get the first item (not recommended in reactive programming)
    public String fluxBlock() {
        return Flux.just("One", "Two", "Three").blockFirst(); // Blocks until the first item is available
    }

    // Subscribes to the Flux (demonstrating subscription)
    public Flux<String> fluxSubscribe() {
        Flux<String> flux = Flux.just("Item A", "Item B", "Item C");
        flux.subscribe(item -> System.out.println("Received: " + item)); // Prints received items
        return flux;
    }

    // Executes a side effect when the Flux completes
    public Flux<String> fluxDoFinally() {
        return Flux.just("X", "Y", "Z")
                .doFinally(signalType -> System.out.println("Flux finished with signal: " + signalType)); // Logs completion
    }

    // Handles errors with onErrorResume
    public Flux<Object> fluxOnErrorResume() {
        return Flux.error(new RuntimeException("Simulated error"))
                .onErrorResume(e -> Flux.just("Error handled: " + e.getMessage())); // Handles the error
    }

    // Returns a fallback value in case of error
    public Flux<Object> fluxOnErrorReturn() {
        return Flux.error(new RuntimeException("Simulated error"))
                .onErrorReturn("Fallback value"); // Returns a fallback value
    }

    // Switches to an alternative Flux if the source is empty
    public Flux<Object> fluxSwitchIfEmpty() {
        return Flux.empty()
                .switchIfEmpty(Flux.just("Alternative value")); // Switches to an alternative Flux
    }

    // Logs items
    public Flux<String> fluxLog() {
        return Flux.just("Logged item 1", "Logged item 2")
                .log(); // Logs events for this Flux
    }
    // Returns a Flux that emits a range of integers
    public Flux<Integer> fluxRange() {
        return Flux.range(1, 10); // Emits integers from 1 to 10
    }

    // Returns a Flux that emits a sequence with delay
    public Flux<String> fluxDelayElements() {
        return Flux.just("Delayed A", "Delayed B", "Delayed C")
                .delayElements(Duration.ofSeconds(1)); // Delays each element by 1 second
    }

    // Concatenates two Flux sources
    public Flux<String> fluxConcat() {
        Flux<String> flux1 = Flux.just("1", "2", "3");
        Flux<String> flux2 = Flux.just("A", "B", "C");
        return Flux.concat(flux1, flux2); // Concatenates both Flux sources
    }

    // Combines two Flux sources and returns a tuple
    public Flux<String> fluxCombineLatest() {
        Flux<String> flux1 = Flux.just("A", "B", "C").delayElements(Duration.ofSeconds(1));
        Flux<Integer> flux2 = Flux.just(1, 2, 3);
        return Flux.combineLatest(flux1, flux2, (letter, number) -> letter + number); // Combines latest items from both
    }

    // Demonstrates distinct values in a Flux
    public Flux<String> fluxDistinct() {
        return Flux.just("apple", "banana", "apple", "orange", "banana")
                .distinct(); // Emits distinct values only
    }

    // Returns a Flux that emits items with a specified interval
    public Flux<Long> fluxInterval() {
        return Flux.interval(Duration.ofSeconds(1)).take(5); // Emits values every second for 5 seconds
    }

    // Returns a Flux that converts a string to a list of characters
    public Flux<Character> fluxFlatMapToCharacters() {
        return Flux.just("hello", "world")
                .flatMap(word -> Flux.fromArray(word.chars().mapToObj(c -> (char) c).toArray(Character[]::new))); // Emits characters from each word
    }

    // Demonstrates the use of `doOnComplete`
    public Flux<String> fluxDoOnComplete() {
        return Flux.just("First", "Second", "Third")
                .doOnComplete(() -> System.out.println("Flux has completed!")); // Logs completion
    }

    // Skips the first n elements
    public Flux<String> fluxSkip() {
        return Flux.just("A", "B", "C", "D", "E")
                .skip(2); // Skips the first 2 elements
    }

    // Limits the number of emitted items
    public Flux<String> fluxTake() {
        return Flux.just("1", "2", "3", "4", "5")
                .take(3); // Takes the first 3 elements
    }

    // Returns a Flux that emits items that pass a predicate
    public Flux<String> fluxTakeWhile() {
        return Flux.just("apple", "banana", "cherry", "date")
                .takeWhile(fruit -> fruit.startsWith("b")); // Emits items while the predicate is true
    }

    // Returns a Flux that repeats elements
    public Flux<String> fluxRepeat() {
        return Flux.just("Repeat me!")
                .repeat(3); // Repeats the element 3 times
    }

    // Returns a Flux with a delayed error
    public Flux<String> fluxDelayError() {
        return Flux.just("A", "B", "C")
                .concatWith(Flux.error(new RuntimeException("Delayed error")))
                .delaySubscription(Duration.ofSeconds(1)); // Emits items first, then the error
    }

    // Returns a Flux that collects items into a List
    public Flux<List<String>> fluxCollectList() {
        return Flux.just("Item 1", "Item 2", "Item 3")
                .collectList()
                .flux(); // Collects items into a List
    }

    // Merges multiple Flux sources
    public Flux<String> fluxMergeMultiple() {
        Flux<String> flux1 = Flux.just("X1", "X2", "X3");
        Flux<String> flux2 = Flux.just("Y1", "Y2", "Y3");
        Flux<String> flux3 = Flux.just("Z1", "Z2", "Z3");
        return Flux.merge(flux1, flux2, flux3); // Merges three Flux sources
    }

    // Returns a Flux with a timeout
    public Flux<String> fluxTimeout() {
        return Flux.just("A", "B", "C")
                .delayElements(Duration.ofSeconds(1))
                .timeout(Duration.ofSeconds(2)); // Times out if no elements are emitted within 2 seconds
    }

    public Flux<String> fluxExpandDeep() {
        return Flux.just("A")
                .expandDeep(letter -> Flux.just(letter + "1", letter + "2").delayElements(Duration.ofSeconds(1)))
                .take(10); // Limits the output to the first 10 items to prevent infinite expansion
    }
    public Flux<String> fluxExpand() {
        return Flux.just("A")
                .expand(letter -> Flux.just(letter + "1", letter + "2").delayElements(Duration.ofSeconds(1))) // Expands each letter
                .take(5); // Limits the output to the first 5 items
    }

    // Reduces the items emitted by a Flux into a single result using an accumulator
    public Flux<Integer> fluxReduceWith() {
        return Flux.just(1, 2, 3, 4, 5)
                .reduceWith(() -> 0, (total, next) -> total + next) // Sums up the integers
                .flux(); // Converts the Mono result back to Flux
    }

}

