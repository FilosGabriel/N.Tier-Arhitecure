package com.filos.core.entities;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "account", schema = "financial")
public class AccountEntity {
    @Id
    @GeneratedValue(generator = "sequence-generator", strategy = GenerationType.SEQUENCE)
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "account_sequence"),
                    @Parameter(name = "schema", value = "financial"),
            }
    )
    private long id;

    private String name;

    private LocalDate lastSeen;

    @OneToMany
    private List<ItemEntity> incomes;

    @OneToMany
    private List<ItemEntity> expenses;

//    private SavingEntity saving;

    private String note;


}
