package com.epam.payments.controller;

import com.epam.payments.api.PaymentApi;
import com.epam.payments.controller.dto.PaymentDto;
import com.epam.payments.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class PaymentController implements PaymentApi {

    private final PaymentService paymentService;

    public List<PaymentDto> getAllPayments() {
        log.info("getAllPayments");
        return paymentService.listPayments();
    }

    public PaymentDto getPaymentById(int id) {
        log.info("getPayment by id {}", id);
        return paymentService.getPayment(id);
    }

    public PaymentDto createPayment(PaymentDto paymentDto) {
        log.info("createPayment with id {}", paymentDto.getId());
        return paymentService.createPayment(paymentDto);
    }

    public PaymentDto updatePayment(int id, PaymentDto paymentDto) {
        log.info("updatePayment by id {}", id);
        return paymentService.updatePayment(id, paymentDto);
    }

    public void deletePayment(int id) {
        log.info("deletePayment by id {}", id);
        paymentService.deletePayment(id);
    }

}
