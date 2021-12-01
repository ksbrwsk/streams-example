package de.ksbrwsk.streams.java17;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static de.ksbrwsk.streams.java17.Geschlecht.MAENNLICH;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PartnerTest {

    @Test
    void create() {
        Partner partner = new Partner("Meiser", "Hans", MAENNLICH,
                LocalDate.of(1960, 5, 10));
        assertEquals(partner.nachname(), "Meiser");
        assertEquals(partner.vorname(), "Hans");
        assertEquals(partner.geschlecht(), MAENNLICH);
        assertEquals(partner.geburtsdatum(), LocalDate.of(1960, 5, 10));
    }
}