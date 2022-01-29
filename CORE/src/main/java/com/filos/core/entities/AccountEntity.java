package com.filos.core.entities;


import lombok.Data;

import javax.persistence.Id;
import java.time.LocalDate;
import java.util.List;

@Data
public class AccountEntity {
    @Id
    private String name;

    private LocalDate lastSeen;

    private List<ItemEntity> incomes;

    private List<ItemEntity> expenses;

    private SavingEntity saving;

    private String note;


}
