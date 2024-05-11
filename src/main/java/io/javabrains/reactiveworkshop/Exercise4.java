package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.util.Optional;

public class Exercise4 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emits
        Integer value = ReactiveSources.intNumberMono().block();
        ReactiveSources.intNumberMono().subscribe(
                number -> System.out.println(number), // in case of event is fired
                err -> System.out.println(err.getMessage()), //in case we have an error
                () -> System.out.println("Complete") //on complete event
        );

        // Get the value from the Mono into an integer variable
        Optional<User> user = ReactiveSources.userMono().blockOptional();


        System.out.println("Press a key to end");
        System.in.read();
    }

}
