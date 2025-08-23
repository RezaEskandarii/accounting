package com.accounting.shared.exceptions;

public class ItemNotFoundException extends ApplicationException {

    public ItemNotFoundException(Object id) {
        super("item not found with id " + id);
    }
}
