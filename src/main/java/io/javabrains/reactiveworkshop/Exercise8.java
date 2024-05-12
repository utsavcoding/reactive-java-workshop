package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Flux;

import java.io.IOException;

public class Exercise8 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFluxWithException()

        // Print values from intNumbersFluxWithException and print a message when error happens
        ReactiveSources.intNumbersFluxWithException()
                .subscribe(x -> System.out.println(x),
                        err -> System.out.println(err.getMessage())); //incase we want to suppress the error

        ReactiveSources.intNumbersFluxWithException()
                .doOnError(err -> System.out.println("Error!!" + err.getMessage()))
                .subscribe(e -> System.out.println(e)); // error will reach subscribe

        // Print values from intNumbersFluxWithException and continue on errors
        ReactiveSources.intNumbersFluxWithException()
                .onErrorContinue((e, item) -> System.out.println("Error!!" + e.getMessage() + item))
                .subscribe(e -> System.out.println(e));
        // Print values from intNumbersFluxWithException and when errors
        // happen, replace with a fallback sequence of -1 and -2
        ReactiveSources.intNumbersFluxWithException()
                .onErrorResume(err -> Flux.just(-1, -2))
                .subscribe(num -> System.out.println(num));

        System.out.println("Press a key to end");
        System.in.read();
    }

}
