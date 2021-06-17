package de.ksbrwsk.streams.java8;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
public class ImperativeTest {

    @Test
    @DisplayName("Summmiere alle Integer in der Liste")
    void sum() {
        List<Integer> numbers = Fixtures.createIntegerList();
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        log.info("Summe: {}", sum);
        assertEquals(sum, 55L);
    }

    @Test
    @DisplayName("Liste alle geraden Zahlen der Liste")
    void evenNumbers() {
        List<Integer> numbers = Fixtures.createIntegerList();
        List<Integer> even = new ArrayList<>();
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                even.add(number);
            }
        }
        log.info("Even: {}", even);
    }

    @Test
    @DisplayName("Gruppiere die Partner Liste nach Geschlecht")
    void groupBy() {
        List<Partner> partners = Fixtures.createPartnerList();
        Map<Geschlecht, List<Partner>> groupedBy = new HashMap<>();
        for (Partner partner : partners) {
            if (!groupedBy.containsKey(partner.getGeschlecht())) {
                List<Partner> list = new ArrayList<>();
                list.add(partner);
                groupedBy.put(partner.getGeschlecht(), list);
            } else {
                List<Partner> list = groupedBy.get(partner.getGeschlecht());
                list.add(partner);
            }
        }
        for (Map.Entry<Geschlecht, List<Partner>> geschlechtListEntry : groupedBy.entrySet()) {
            log.info(geschlechtListEntry);
        }
    }

    @Test
    @DisplayName("Liefere den Partner mit dem ältesten Geburtsdatum")
    void min() {
        List<Partner> partners = Fixtures.createPartnerList();
        Partner min = partners.get(0);
        for (Partner partner : partners) {
            if (partner.getGeburtsdatum().isBefore(min.getGeburtsdatum())) {
                min = partner;
            }
        }
        log.info(min);
    }

    @Test
    @DisplayName("Liefere den Partner mit dem jüngsten Geburtsdatum")
    void max() {
        List<Partner> partners = Fixtures.createPartnerList();
        Partner max = partners.get(0);
        for (Partner partner : partners) {
            if (partner.getGeburtsdatum().isAfter(max.getGeburtsdatum())) {
                max = partner;
            }
        }
        log.info(max);
    }

    @Test
    @DisplayName("Liefere den ersten Partner mit Nachnamen X")
    void find() {
        List<Partner> partners = Fixtures.createPartnerList();
        Partner meiser = null;
        for (Partner partner : partners) {
            if (partner.getNachname().equalsIgnoreCase("meiser")) {
                meiser = partner;
                break;
            }
        }
        log.info(meiser);
    }

    @Test
    @DisplayName("Kein Treffer bei Nachname X")
    void noneMatch() {
        List<Partner> partners = Fixtures.createPartnerList();
        boolean noneMatch = true;
        for (Partner partner : partners) {
            if (partner.getNachname().equalsIgnoreCase("borat")) {
                noneMatch = false;
                break;
            }
        }
        assertTrue(noneMatch);
    }

    @Test
    @DisplayName("Ein Treffer bei Nachhname X")
    void oneMatch() {
        List<Partner> partners = Fixtures.createPartnerList();
        boolean oneMatch = false;
        int count = 0;
        for (Partner partner : partners) {
            if (partner.getNachname().equalsIgnoreCase("meiser")) {
                count++;
            }
        }
        oneMatch = count == 1;
        assertTrue(oneMatch);
    }

    @Test
    @DisplayName("Alle Treffer mit Geburtsdatum später X")
    void allMatch() {
        List<Partner> partners = Fixtures.createPartnerList();
        boolean allMatch = true;
        for (Partner partner : partners) {
            if (partner.getGeburtsdatum()
                    .isAfter(LocalDate.of(1980, 1, 1))) {
                allMatch = false;
                break;
            }
        }
        assertFalse(allMatch);
    }

    @Test
    @DisplayName("Liefere alle weiblichen Partner")
    void filter() {
        List<Partner> partners = Fixtures.createPartnerList();
        List<Partner> frauen = new ArrayList<>();
        for (Partner partner : partners) {
            if (partner.getGeschlecht().equals(Geschlecht.WEIBLICH)) {
                frauen.add(partner);
            }
        }
        for (Partner frau : frauen) {
            log.info(frau);
        }
        assertEquals(frauen.size(), 2);
    }

    @Test
    @DisplayName("Sortiere die Partnerliste nach Nach- und Vorname")
    void sort() {
        List<Partner> partners = new ArrayList<>(Fixtures.createPartnerList());
        partners.sort(new Comparator<Partner>() {
            @Override
            public int compare(Partner o1, Partner o2) {
                return o1.getNachname().compareTo(o2.getNachname());
            }
        });
        for (Partner partner : partners) {
            log.info(partner);
        }
    }

    @Test
    @DisplayName("Logge alle Partner im Stream")
    void stream() {
        List<Partner> partners = Fixtures.createPartnerList();
        for (Partner partner : partners) {
            log.info(partner);
        }
    }
}
