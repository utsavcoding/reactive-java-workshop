package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise2 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userFlux()

        // Print all numbers in the ReactiveSources.intNumbersFlux stream
        // StreamSources was synchronous and the elements used to be printed with one after another till the stream was finished
        // Here, whenever the event happens, we are going to print the event/element. This is completely random. So, we have kept a input at the end for delay
        ReactiveSources.intNumbersFlux().subscribe(e -> System.out.println(e));

        // Print all users in the ReactiveSources.userFlux stream
        ReactiveSources.userFlux().subscribe(user -> System.out.println(user));

        System.out.println("Press a key to end");
        System.in.read();
    }

}
