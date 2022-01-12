package com.filos.application.models;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ApiResult<T> {

    boolean succeeded;
    T result;
    List<String> errors;

    public static <TT> ApiResult<TT> success(TT result) {
        return new ApiResult<>(true, result, List.of());
    }

    public static <TT> ApiResult<TT> failure(List<String> errors) {
        return new ApiResult<>(false, null, errors);
    }
}
