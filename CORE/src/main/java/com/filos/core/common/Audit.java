package com.filos.core.common;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Embeddable
public class Audit {
    private String createdBy;
    private String updatedBy;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdOn;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime updatedOn;
    private Long noUpdates;
}
