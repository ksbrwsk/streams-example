package de.ksbrwsk.streams.java17.predicate;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.regex.Pattern;

public class AsMatchPredicate {

    @Test
    void asMatchPredicate() {
        var words = List.of("book", "bookshelf", "bookworm",
                "bookcase", "bookish", "bookkeeper", "booklet", "bookmark");
        var pred = Pattern.compile("book(worm|mark|keeper)?")
                .asMatchPredicate();
        words.stream()
                .filter(pred)
                .forEach(System.out::println);
        List<String> strings = words.stream()
                .filter(pred)
                .toList();
        System.out.println(strings);
    }
}
