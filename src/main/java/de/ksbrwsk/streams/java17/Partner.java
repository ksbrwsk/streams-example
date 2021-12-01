package de.ksbrwsk.streams.java17;

import java.time.LocalDate;

public record Partner(
        String nachname,
        String vorname,
        Geschlecht geschlecht,
        LocalDate geburtsdatum) {
}
