package com.epam.payments.service.repository;

import com.epam.payments.service.model.Payment;

import java.util.List;

public interface PaymentRepository {

    Payment getPayment(int id);

    List<Payment> listPayments();

    Payment createPayment(Payment payment);

    Payment updatePayment(int id, Payment payment);

    void deletePayment(int id);

}
