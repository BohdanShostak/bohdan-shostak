package com.epam.payments.service.repository.impl;

import com.epam.payments.exception.PaymentNotFoundException;
import com.epam.payments.service.model.Payment;
import com.epam.payments.service.repository.PaymentRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PaymentRepositoryImpl implements PaymentRepository {

    private final List<Payment> paymentList = new ArrayList<>();

    @Override
    public Payment getPayment(int id) {
        return paymentList.stream()
                .filter(payment -> payment.getId() == id)
                .findFirst()
                .orElseThrow(() -> new PaymentNotFoundException(id));
    }

    @Override
    public List<Payment> listPayments() {
        return new ArrayList<>(paymentList);
    }

    @Override
    public Payment createPayment(Payment payment) {
        payment.setId(paymentList.size() + 1);
        paymentList.add(payment);
        return payment;
    }

    @Override
    public Payment updatePayment(int id, Payment payment) {
        Payment oldPayment = paymentList.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(() -> new PaymentNotFoundException(id));
        paymentList.remove(oldPayment);
        payment.setId(oldPayment.getId());
        paymentList.add(payment);
        return payment;
    }

    @Override
    public void deletePayment(int id) {
        paymentList.removeIf(payment -> payment.getId() == id);
    }

}
