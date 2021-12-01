package de.ksbrwsk.streams.java16.function;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

public class SimpleFunctionTest {

    @Test
    void simple() {
        Function<String,Integer> func = string -> string.length();
        System.out.println(func.apply("Hello World!"));
    }

    @Test
    void simpleMethodReference() {
        Function<String,Integer> func = String::length;
        System.out.println(func.apply("Hello World!"));
    }
}
