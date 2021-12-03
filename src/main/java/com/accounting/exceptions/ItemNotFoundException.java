package com.accounting.exceptions;

public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException(Object id) {
        super("item not found with id " + id);
    }
}
