package de.ksbrwsk.streams.java21;

import java.time.LocalDate;
import java.util.stream.Stream;

import static de.ksbrwsk.streams.java21.Geschlecht.MAENNLICH;
import static de.ksbrwsk.streams.java21.Geschlecht.WEIBLICH;

public class Fixtures {

    public static Stream<Integer> createIntegerList() {
        return Stream.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }

    public static Stream<Partner> createPartnerList() {
        return Stream.of(
                new Partner("Meiser", "Hans", MAENNLICH, LocalDate.of(1960, 5, 10)),
                new Partner("Poth", "Verona", WEIBLICH, LocalDate.of(1970, 4, 7)),
                new Partner("Müller", "Fritz", MAENNLICH, LocalDate.of(1958, 4, 9)),
                new Partner("Beckenbauer", "Franz", MAENNLICH, LocalDate.of(1945, 9, 20)),
                new Partner("Nielsen", "Brigitte", WEIBLICH, LocalDate.of(1959, 7, 16)),
                new Partner("Müller", "Frieda", WEIBLICH, LocalDate.of(1958, 4, 6)),
                new Partner("Neuer", "Manuel", MAENNLICH, LocalDate.of(1985, 8, 7)));
    }
}
