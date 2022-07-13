package com.epam.payments.exception;

public class AccountNotFoundException extends ServiceException {
    public AccountNotFoundException(long id) {
        super("Account with id " + id + " is not found");
    }
}
