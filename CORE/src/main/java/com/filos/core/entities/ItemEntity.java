package com.filos.core.entities;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Currency;

@Data
public class ItemEntity {
    private String title;
    private BigDecimal amount;
    private Currency currency;
    private TimePeriod period;
    private String icon;
}
