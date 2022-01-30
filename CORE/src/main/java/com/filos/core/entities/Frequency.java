package com.filos.core.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum Frequency {
    WEEKLY(7), MONTHLY(30), QUARTERLY(90);

    private int days;

    public static Frequency withDays(int days) {
        return Stream.of(Frequency.values())
                .filter(f -> f.getDays() == days)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
