package de.ksbrwsk.streams.java21.consumer;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

public class SimpleConsumerTest {

    @Test
    void simple() {
        Consumer<String> hello = System.out::println;
        hello.accept("Hello World!");
    }
}
