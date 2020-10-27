package de.ksbrwsk.streams;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static de.ksbrwsk.streams.Geschlecht.WEIBLICH;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.*;

@Log4j2
public class StreamTest {

    @Test
    @DisplayName("Summmiere alle Integer in der Liste")
    void sum() {
        List<Integer> numbers = Fixtures.createIntegerList();
        int sum = numbers
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
        assertEquals(sum, 55L);
    }

    @Test
    @DisplayName("Liste alle geraden Zahlen der Liste")
    void evenNumbers() {
        List<Integer> numbers = Fixtures.createIntegerList();
        List<Integer> even = numbers
                .stream()
                .filter(number -> number % 2 == 0)
                .collect(toList());
        even.forEach(log::info);
    }

    @Test
    @DisplayName("Gruppiere die Partner Liste nach Geschlecht")
    void groupBy() {
        List<Partner> partners = Fixtures.createPartnerList();
        Map<Geschlecht, List<Partner>> groupedBy = partners
                .stream()
                .collect(groupingBy(Partner::getGeschlecht));
        groupedBy.entrySet().forEach(log::info);
    }

    @Test
    @DisplayName("Liefere den Partner mit dem ältesten Geburtsdatum")
    void min() {
        List<Partner> partners = Fixtures.createPartnerList();
        partners
                .stream()
                .min(comparing(Partner::getGeburtsdatum))
                .ifPresent(log::info);
    }

    @Test
    @DisplayName("Liefere den Partner mit dem jüngsten Geburtsdatum")
    void max() {
        List<Partner> partners = Fixtures.createPartnerList();
        partners
                .stream()
                .max(comparing(Partner::getGeburtsdatum))
                .ifPresent(log::info);
    }

    @Test
    @DisplayName("Liefere den ersten Partner mit Nachnamen X")
    void find() {
        List<Partner> partners = Fixtures.createPartnerList();
        Optional<Partner> meiser = partners
                .stream()
                .filter(partner -> partner.getNachname().equalsIgnoreCase("meiser"))
                .findFirst();
        assertTrue(meiser.isPresent());
        log.info(meiser.get());
    }

    @Test
    @DisplayName("Kein Treffer bei Nachname X")
    void noneMatch() {
        List<Partner> partners = Fixtures.createPartnerList();
        boolean noneMatch = partners
                .stream()
                .noneMatch(partner -> partner.getNachname().equalsIgnoreCase("borat"));
        assertTrue(noneMatch);
    }

    @Test
    @DisplayName("Ein Treffer bei Nachhname X")
    void oneMatch() {
        List<Partner> partners = Fixtures.createPartnerList();
        boolean match = partners
                .stream()
                .anyMatch(partner -> partner.getNachname().equalsIgnoreCase("meiser"));
        assertTrue(match);
    }

    @Test
    @DisplayName("Alle Treffer mit Geburtsdatum später X")
    void allMatch() {
        List<Partner> partners = Fixtures.createPartnerList();
        boolean allMatch = partners
                .stream()
                .allMatch(partner -> partner.getGeburtsdatum()
                        .isAfter(LocalDate.of(1980, 1, 1)));
        assertFalse(allMatch);
    }

    @Test
    @DisplayName("Liefere alle weiblichen Partner")
    void filter() {
        List<Partner> partners = Fixtures.createPartnerList();
        List<Partner> frauen = partners
                .stream()
                .filter(partner -> partner.getGeschlecht().equals(WEIBLICH))
                .collect(toList());
        frauen.forEach(log::info);
        assertTrue(frauen.size()==2);
    }

    @Test
    @DisplayName("Sortiere die Partnerliste nach Nach- und Vorname")
    void sort() {
        List<Partner> partners = Fixtures.createPartnerList();
        List<Partner> sorted = partners
                .stream()
                .sorted(comparing(Partner::getNachname)
                        .thenComparing(Partner::getVorname))
                .collect(toList());
        sorted.forEach(log::info);
    }

    @Test
    @DisplayName("Logge alle Partner im Stream")
    void stream() {
        List<Partner> partners = Fixtures.createPartnerList();
        partners
                .forEach(log::info);
    }
}
