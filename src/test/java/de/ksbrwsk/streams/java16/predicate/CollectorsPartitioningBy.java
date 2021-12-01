package de.ksbrwsk.streams.java16.predicate;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CollectorsPartitioningBy {

    @Test
    void collectorsPartitioningBy() {
        var values = List.of(3, -1, 2, 4, -1, 1, 2, 3, -4);
        Predicate<Integer> isPositive = e -> e > 0;

        Map<Boolean, List<Integer>> groups =
                values.stream()
                        .collect(Collectors.partitioningBy(isPositive));

        System.out.println("Positive: " + groups.get(true));
        System.out.println("Negative: " + groups.get(false));

        List<List<Integer>> subSets = new ArrayList<>(groups.values());
        System.out.println("Gruppen: " + subSets);
    }
}
