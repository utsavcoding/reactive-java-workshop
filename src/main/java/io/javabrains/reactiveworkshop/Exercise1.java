package io.javabrains.reactiveworkshop;

import java.util.stream.Collectors;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        StreamSources.intNumbersStream().forEach(x -> System.out.println(x));

        // Print numbers from intNumbersStream that are less than 5
        StreamSources.intNumbersStream().filter(x -> x < 5)
                .forEach(x -> System.out.println(x));

        // Print the second and third numbers in intNumbersStream that's greater than 5
        StreamSources.intNumbersStream().filter(x -> x > 5)
                .skip(1)
                .limit(2)
                .forEach(x -> System.out.println(x));

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        Integer value = StreamSources.intNumbersStream().filter(x -> x > 5)
                .findFirst()
                .orElse(-1);
        System.out.println(value);

        // Print first names of all users in userStream
        StreamSources.userStream().forEach(x -> System.out.println(x.getFirstName()));
        StreamSources.userStream().map(x -> x.getFirstName()).forEach(x -> System.out.println(x));

        // Print first names in userStream for users that have IDs from number stream
        System.out.println("Test Last");
        StreamSources.userStream()
                .filter(x -> StreamSources.intNumbersStream().collect(Collectors.toSet()).contains(x.getId()))
                .forEach(x -> System.out.println(x));

        StreamSources.userStream()
                .filter(x -> StreamSources.intNumbersStream().anyMatch(i -> i == x.getId()))
                .forEach(x -> System.out.println(x));
    }

}
