package de.ksbrwsk.streams;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Partner {
    private String nachname;
    private String vorname;
    private Geschlecht geschlecht;
    private LocalDate geburtsdatum;
}
