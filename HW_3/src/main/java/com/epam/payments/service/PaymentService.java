package com.epam.payments.service;

import com.epam.payments.controller.dto.PaymentDto;

import java.util.List;

public interface PaymentService {

    PaymentDto getPayment(int id);

    List<PaymentDto> listPayments();

    PaymentDto createPayment(PaymentDto paymentDto);

    PaymentDto updatePayment(int id, PaymentDto paymentDto);

    void deletePayment(int id);

}
