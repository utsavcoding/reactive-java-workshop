package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.util.List;

public class Exercise3 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Get all numbers in the ReactiveSources.intNumbersFlux stream
        // into a List and print the list and its size
        // This 15 line is a blocking operation. It cannot move ahead unless list of numbers has been allocated
        List<Integer> numbers = ReactiveSources.intNumbersFlux().toStream().toList();
        System.out.println("List: " + numbers);
        System.out.println("List Size:" + numbers.size());

        System.out.println("Press a key to end");
        System.in.read();
    }

}
