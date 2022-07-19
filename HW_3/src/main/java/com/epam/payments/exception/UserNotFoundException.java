package com.epam.payments.exception;

public class UserNotFoundException extends ServiceException {
    public UserNotFoundException(String email) {
        super("User with email " + email + " is not found");
    }
}
