package com.filos.application.common.email;

public record EmailAttachment(
        byte[] value,
        String name
        ) {
}
