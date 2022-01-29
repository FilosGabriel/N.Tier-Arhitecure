package com.filos.application.models.account;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.Currency;

public record Item(
        @NotNull
        @Length(min = 1, max = 20)
        String title,
        @NotNull
        Currency currency,
        @NotNull
        TimePeriod period,
        @NotNull
        String icon
) {
}
