package de.ksbrwsk.streams.java16;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static de.ksbrwsk.streams.java16.Geschlecht.WEIBLICH;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;
import static org.junit.jupiter.api.Assertions.*;

@Log4j2
public class StreamTest {

    @Test
    @DisplayName("Summmiere alle Integer in der Liste")
    void sum() {
        Stream<Integer> numbers = Fixtures.createIntegerList();
        int sum = numbers
                .mapToInt(Integer::intValue)
                .sum();
        assertEquals(sum, 55L);
    }

    @Test
    @DisplayName("Wandle Strings in Imteger, summmiere alle Integer in der Liste")
    void sumOfStringValues() {
        Stream<String> stringNumbers = Stream.of("1", "2", "3", "4", "5", "6");
        int sum = stringNumbers
                .mapToInt(Integer::parseInt)
                .sum();
        assertEquals(sum, 21L);
    }

    @Test
    @DisplayName("Liste alle geraden Zahlen der Liste")
    void evenNumbers() {
        Stream<Integer> numbers = Fixtures.createIntegerList();
        List<Integer> even = numbers
                .filter(number -> number % 2 == 0)
                .toList();
        even.forEach(log::info);
    }

    @Test
    @DisplayName("Gruppiere die Partner Liste nach Geschlecht")
    void groupBy() {
        Stream<Partner> partners = Fixtures.createPartnerList();
        Map<Geschlecht, List<Partner>> groupedBy = partners
                .collect(groupingBy(Partner::geschlecht));
        groupedBy.entrySet().forEach(log::info);
    }

    @Test
    @DisplayName("Liefere den Partner mit dem ältesten Geburtsdatum")
    void min() {
        Stream<Partner> partners = Fixtures.createPartnerList();
        partners
                .min(comparing(Partner::geburtsdatum))
                .ifPresent(log::info);
    }

    @Test
    @DisplayName("Liefere den Partner mit dem jüngsten Geburtsdatum")
    void max() {
        Stream<Partner> partners = Fixtures.createPartnerList();
        partners
                .max(comparing(Partner::geburtsdatum))
                .ifPresent(log::info);
    }

    @Test
    @DisplayName("Liefere den ersten Partner mit Nachnamen X")
    void find() {
        Stream<Partner> partners = Fixtures.createPartnerList();
        Optional<Partner> meiser = partners
                .filter(partner -> partner.nachname().equalsIgnoreCase("meiser"))
                .findFirst();
        assertTrue(meiser.isPresent());
        log.info(meiser.get());
    }

    @Test
    @DisplayName("Kein Treffer bei Nachname X")
    void noneMatch() {
        Stream<Partner> partners = Fixtures.createPartnerList();
        boolean noneMatch = partners
                .noneMatch(partner -> partner.nachname().equalsIgnoreCase("borat"));
        assertTrue(noneMatch);
    }

    @Test
    @DisplayName("Ein Treffer bei Nachhname X")
    void oneMatch() {
        Stream<Partner> partners = Fixtures.createPartnerList();
        boolean match = partners
                .anyMatch(partner -> partner.nachname().equalsIgnoreCase("meiser"));
        assertTrue(match);
    }

    @Test
    @DisplayName("Alle Treffer mit Geburtsdatum später X")
    void allMatch() {
        Stream<Partner> partners = Fixtures.createPartnerList();
        boolean allMatch = partners
                .allMatch(partner -> partner.geburtsdatum()
                        .isAfter(LocalDate.of(1980, 1, 1)));
        assertFalse(allMatch);
    }

    @Test
    @DisplayName("Liefere alle weiblichen Partner")
    void filter() {
        Stream<Partner> partners = Fixtures.createPartnerList();
        List<Partner> frauen = partners
                .filter(partner -> partner.geschlecht().equals(WEIBLICH))
                .toList();
        frauen.forEach(log::info);
        assertEquals(frauen.size(), 2);
    }

    @Test
    @DisplayName("Sortiere die Partnerliste nach Nach- und Vorname")
    void sort() {
        Stream<Partner> partners = Fixtures.createPartnerList();
        List<Partner> sorted = partners
                .sorted(comparing(Partner::nachname)
                        .thenComparing(Partner::vorname))
                .toList();
        sorted.forEach(log::info);
    }

    @Test
    @DisplayName("Logge alle Partner im Stream")
    void stream() {
        Stream<Partner> partners = Fixtures.createPartnerList();
        partners.forEach(log::info);
    }
}
