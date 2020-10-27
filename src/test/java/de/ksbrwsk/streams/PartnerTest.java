package de.ksbrwsk.streams;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PartnerTest {

    @Test
    void create() {
        Partner partner = new Partner("Meiser", "Hans", Geschlecht.MAENNLICH,
                LocalDate.of(1960, 5, 10));
        assertEquals(partner.getNachname(), "Meiser");
        assertEquals(partner.getVorname(), "Hans");
        assertEquals(partner.getGeschlecht(), Geschlecht.MAENNLICH);
        assertEquals(partner.getGeburtsdatum(), LocalDate.of(1960, 5, 10));
    }
}