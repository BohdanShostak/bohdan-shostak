package com.epam.payments.controller;

import com.epam.payments.controller.dto.PaymentDto;
import com.epam.payments.controller.dto.group.OnCreate;
import com.epam.payments.controller.dto.group.OnUpdate;
import com.epam.payments.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
@Slf4j
public class PaymentController {

    private final PaymentService paymentService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<PaymentDto> getAllPayments() {
        log.info("getAllPayments");
        return paymentService.listPayments();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public PaymentDto getPaymentById(@PathVariable int id) {
        log.info("getPayment by id {}", id);
        return paymentService.getPayment(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public PaymentDto createPayment(@RequestBody @Validated(OnCreate.class) PaymentDto paymentDto) {
        log.info("createPayment with id {}", paymentDto.getId());
        return paymentService.createPayment(paymentDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public PaymentDto updatePayment(@PathVariable int id, @RequestBody @Validated(OnUpdate.class) PaymentDto paymentDto) {
        log.info("updatePayment by id {}", id);
        return paymentService.updatePayment(id, paymentDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deletePayment(@PathVariable int id) {
        log.info("deletePayment by id {}", id);
        paymentService.deletePayment(id);
    }

}
