package com.accounting.shared.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ConflictException extends RuntimeException {
    public List<String> getErrors() {
        return errors;
    }

    private final List<String> errors;

    public ConflictException addError(String error) {
        this.errors.add(error);
        return this;
    }

    public ConflictException() {
        this.errors = new ArrayList<>();
    }
}
