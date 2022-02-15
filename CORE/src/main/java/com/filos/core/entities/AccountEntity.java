package com.filos.core.entities;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "account", schema = "financial")
public class AccountEntity {
    @Id
    private Long id;

    private String name;

    private LocalDate lastSeen;

    @OneToMany
    private List<ItemEntity> incomes;

    @OneToMany
    private List<ItemEntity> expenses;

//    private SavingEntity saving;

    private String note;


}
