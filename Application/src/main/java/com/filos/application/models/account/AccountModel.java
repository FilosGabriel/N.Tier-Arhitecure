package com.filos.application.models.account;

import java.time.LocalDate;
import java.util.List;

public record AccountModel(
        String name,
        LocalDate lastSeen,
        List<Item> incomes,
        List<Item> expenses,
        Saving savings,
        String note
) {
}
