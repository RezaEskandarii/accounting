package com.accounting.shared.exceptions;

import java.util.ArrayList;
import java.util.List;

public class InvalidDataException extends RuntimeException {

    public List<String> getErrors() {
        return errors;
    }

    private final List<String> errors;

    public InvalidDataException addError(String error) {
        this.errors.add(error);
        return this;
    }

    public InvalidDataException() {
        this.errors = new ArrayList<>();
    }

}
