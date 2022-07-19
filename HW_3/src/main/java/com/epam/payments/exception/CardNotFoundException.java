package com.epam.payments.exception;

public class CardNotFoundException extends ServiceException {
    public CardNotFoundException(long cardNumber) {
        super("Card with cardNumber " + cardNumber + " is not found");
    }
}
