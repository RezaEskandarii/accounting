package com.accounting.exceptions;

import java.util.List;

public class DuplicatedItemException extends RuntimeException {
    public List<String> getErrors() {
        return errors;
    }

    private final List<String> errors;

    public DuplicatedItemException(List<String> errors) {
        this.errors = errors;
    }
}
