package com.filos.application.helpers.extensions;

public class BasicExtension {

    public static <T> T orIfNull(T object, T ifNull) {
        return object != null ? object : ifNull;
    }
}
