package com.tcs.edu.decorator;

import java.util.stream.Stream;

import static java.util.Arrays.stream;

public class DoubleTracker {
    public static Stream<String> checkDoubles (Doubling doubling, String... messages) {
        var type = stream(messages);

        if(doubling == Doubling.DISTINCT) {
            type = type.distinct();
        }
        return type;
    }
}
