package com.filos.application.models.account;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Currency;

public record Saving(
        @NotNull
        BigDecimal amount,
        @NotNull
        Currency currency,
        @NotNull
        BigDecimal interest,
        @NotNull
        Boolean deposit,
        @NotNull
        Boolean capitalization
) {
}
