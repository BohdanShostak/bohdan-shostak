package com.epam.payments.exception;

public class PaymentNotFoundException extends ServiceException {
    public PaymentNotFoundException(int id) {
        super("Payment with id " + id + " is not found");
    }
}
