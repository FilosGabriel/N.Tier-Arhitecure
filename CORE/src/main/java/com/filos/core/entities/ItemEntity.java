package com.filos.core.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Currency;

@Data
@Entity
@Table(name = "income-expenses", schema = "financial")
public class ItemEntity {
    @Id
    private String title;
    private BigDecimal amount;
    private Currency currency;
    private TimePeriod period;
    private String icon;
}
