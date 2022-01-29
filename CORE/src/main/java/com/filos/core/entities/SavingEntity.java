package com.filos.core.entities;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Currency;

@Data
public class SavingEntity {
    private BigDecimal amount;
    private Currency currency;
    private BigDecimal interest;
    private Boolean deposit;
}
