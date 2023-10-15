package de.ksbrwsk.streams.java21.predicate;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ListRemoveIf {

    List<String> words = List.of(
            "sky",
            "warm",
            "winter",
            "cloud",
            "pen",
            "den",
            "tree",
            "sun",
            "silk"
    );

    @Test
    void removeIf() {
        Predicate<String> hasThreeChars = word -> word.length() == 3;
        var list = new ArrayList<>(words);
        list.removeIf(hasThreeChars);
        System.out.println(list);
    }
}
