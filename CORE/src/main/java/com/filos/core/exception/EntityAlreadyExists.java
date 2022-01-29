package com.filos.core.exception;

import com.filos.core.entities.AccountEntity;

public class EntityAlreadyExists extends RuntimeException {
    public static void from(AccountEntity e) {

    }
}
