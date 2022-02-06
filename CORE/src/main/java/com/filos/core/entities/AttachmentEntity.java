package com.filos.core.entities;

import com.filos.core.common.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Access(value = AccessType.FIELD)
@Table(name = "attachments", schema = "todos")
@Setter
@Getter
@NoArgsConstructor
public class AttachmentEntity extends BaseEntity {
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "attachment", columnDefinition = "BLOB")
    private byte[] attachemnt;
    @OneToOne
    private TodoItem todoItem;
}
