package de.ksbrwsk.streams.java16.predicate;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOfPredicatesTest {

    @Test
    void listOfPredicates() {
        var words = List.of("sky", "curtain", "sin", "shy", "way", "club",
                "spy", "silk", "summer", "war", "cup", "cloud", "coin", "small",
                "set", "terse", "tree", "sea", "sip", "snow", "snail", "sly",
                "six", "sod", "see", "sit", "sad", "wry", "why");

        Predicate<String> p1 = e -> e.startsWith("s") || e.startsWith("w");
        Predicate<String> p2 = e -> e.endsWith("y");
        Predicate<String> p3 = e -> e.length() == 3;

        var prs = List.of(p1, p2, p3);

        var result = words.stream()
                .filter(prs.stream().reduce(x -> true, Predicate::and))
                .collect(Collectors.toList());

        result.forEach(System.out::println);
    }
}
