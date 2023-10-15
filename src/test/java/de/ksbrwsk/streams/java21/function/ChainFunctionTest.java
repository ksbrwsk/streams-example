package de.ksbrwsk.streams.java21.function;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

public class ChainFunctionTest {
    @Test
    void chainFunction() {
        Function<String, Integer> func = String::length;
        Function<Integer, Integer> func2 = x -> x * 2;
        Integer result = func.andThen(func2).apply("Hello World");
        System.out.println(result);
    }
}
