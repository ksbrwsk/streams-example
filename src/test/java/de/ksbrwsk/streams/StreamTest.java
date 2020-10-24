package de.ksbrwsk.streams;

import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static de.ksbrwsk.streams.Geschlecht.MAENNLICH;
import static de.ksbrwsk.streams.Geschlecht.WEIBLICH;
import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.*;

@Log4j2
public class StreamTest {

    @Test
    @DisplayName("Summmiere alle Integer in der Liste")
    void sum() {
        List<Integer> numbers = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum = numbers
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
        assertEquals(sum, 55L);
    }

    @Test
    @DisplayName("Liste alle geraden Zahlen der Liste")
    void evenNumbers() {
        List<Integer> numbers = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> even = numbers
                .stream()
                .filter(number -> number % 2 == 0)
                .collect(toList());
        even.forEach(log::info);
    }

    @Test
    @DisplayName("Gruppiere die Partner Liste nach Geschlecht")
    void groupBy() {
        List<Partner> partners = this.createPartnerList();
        Map<Geschlecht, List<Partner>> groupedBy = partners
                .stream()
                .collect(Collectors.groupingBy(Partner::getGeschlecht));
        groupedBy.entrySet().forEach(log::info);
    }

    @Test
    @DisplayName("Liefere den Partner mit dem ältesten Geburtsdatum")
    void min() {
        List<Partner> partners = this.createPartnerList();
        partners
                .stream()
                .min(Comparator.comparing(Partner::getGeburtsdatum))
                .ifPresent(log::info);
    }

    @Test
    @DisplayName("Liefere den Partner mit dem jüngsten Geburtsdatum")
    void max() {
        List<Partner> partners = this.createPartnerList();
        partners
                .stream()
                .max(Comparator.comparing(Partner::getGeburtsdatum))
                .ifPresent(log::info);
    }

    @Test
    @DisplayName("Liefere den ersten Partner mit Nachnamen X")
    void find() {
        List<Partner> partners = this.createPartnerList();
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
        List<Partner> partners = this.createPartnerList();
        boolean noneMatch = partners
                .stream()
                .noneMatch(partner -> partner.getNachname().equalsIgnoreCase("borat"));
        assertTrue(noneMatch);
    }

    @Test
    @DisplayName("Ein Treffer bei Nachhname X")
    void oneMatch() {
        List<Partner> partners = this.createPartnerList();
        boolean match = partners
                .stream()
                .anyMatch(partner -> partner.getNachname().equalsIgnoreCase("meiser"));
        assertTrue(match);
    }

    @Test
    @DisplayName("Alle Treffer mit Geburtsdatum später X")
    void allMatch() {
        List<Partner> partners = this.createPartnerList();
        boolean allMatch = partners
                .stream()
                .allMatch(partner -> partner.getGeburtsdatum()
                        .isAfter(LocalDate.of(1980, 1, 1)));
        assertFalse(allMatch);
    }

    @Test
    @DisplayName("Liefere alle weiblichen Partner")
    void filter() {
        List<Partner> partners = this.createPartnerList();
        List<Partner> frauen = partners
                .stream()
                .filter(partner -> partner.getGeschlecht().equals(WEIBLICH))
                .collect(toList());
        frauen.forEach(log::info);
    }

    @Test
    @DisplayName("Sortiere die Partnerliste nach Nach- und Vorname")
    void sort() {
        List<Partner> partners = this.createPartnerList();
        List<Partner> sorted = partners
                .stream()
                .sorted(Comparator.comparing(Partner::getNachname)
                        .thenComparing(Partner::getVorname))
                .collect(toList());
        sorted.forEach(log::info);
    }

    @Test
    @DisplayName("Logge alle Partner im Stream")
    void stream() {
        List<Partner> partners = this.createPartnerList();
        partners
                .forEach(System.out::println);
    }

    @NotNull
    private List<Partner> createPartnerList() {
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
