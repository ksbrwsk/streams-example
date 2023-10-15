package de.ksbrwsk.streams.java21.predicate;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.IntPredicate;

public class PredicateNegate {

    @Test
    void negate() {
        int[] nums = {2, 3, 1, 5, 6, 7, 8, 9, 12};

        IntPredicate p = n -> n > 5;

        Arrays.stream(nums)
                .filter(p)
                .forEach(System.out::println);

        System.out.println("**********");

        Arrays.stream(nums)
                .filter(p.negate())
                .forEach(System.out::println);
    }
}
