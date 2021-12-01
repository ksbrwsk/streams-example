package de.ksbrwsk.streams.java16.predicate;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

class BiggerThan5PredicateTest {

    List<Integer> numbers = List.of(2, 3, 6, 4, 3, 1, 7, 4, 9);

    @Test
    void btfAsLambda() {
        Predicate<Integer> btf = number -> number > 5;
        numbers.stream()
                .filter(btf)
                .forEach(System.out::println);
    }

    @Test
    void intPredicate() {
        var numArray = new Integer[]{2, 3, 6, 4, 3, 1, 7, 4, 9};
        Predicate<Integer> btf = number -> number > 5;
        Arrays.stream(numArray)
                .filter(btf)
                .forEach(System.out::println);
    }

    @Test
    void valuesGt5() {
        var btf = new BiggerThan5Predicate();
        numbers.stream()
                .filter(btf)
                .forEach(System.out::println);
    }

    static class BiggerThan5Predicate implements Predicate<Integer> {

        @Override
        public boolean test(Integer integer) {
            return integer > 5;
        }
    }

}