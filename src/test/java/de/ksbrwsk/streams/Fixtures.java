package de.ksbrwsk.streams;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static de.ksbrwsk.streams.Geschlecht.MAENNLICH;
import static de.ksbrwsk.streams.Geschlecht.WEIBLICH;

public class Fixtures {

    public static List<Integer> createIntegerList() {
        return List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }

    public static List<Partner> createPartnerList() {
        List<Partner> people = new ArrayList<>();
        people.add(new Partner("Meiser", "Hans", MAENNLICH,
                LocalDate.of(1960, 5, 10)));
        people.add(new Partner("Poth", "Verona", WEIBLICH,
                LocalDate.of(1970, 4, 7)));
        people.add(new Partner("Beckenbauer", "Franz", MAENNLICH,
                LocalDate.of(1945, 9, 20)));
        people.add(new Partner("Nielsen", "Brigitte", WEIBLICH,
                LocalDate.of(1959, 7, 16)));
        people.add(new Partner("Neuer", "Manuel", MAENNLICH,
                LocalDate.of(1985, 8, 7)));
        return people;
    }
}
