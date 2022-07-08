package com.epam.payments.service.impl;

import com.epam.payments.controller.dto.PaymentDto;
import com.epam.payments.service.PaymentService;
import com.epam.payments.service.mapper.PaymentMapper;
import com.epam.payments.service.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentMapper paymentMapper;
    private final PaymentRepository paymentRepository;

    @Override
    public PaymentDto getPayment(int id) {
        return paymentMapper.mapModelToDto(paymentRepository.getPayment(id));
    }

    @Override
    public List<PaymentDto> listPayments() {
        return paymentRepository.listPayments()
                .stream()
                .map(paymentMapper::mapModelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public PaymentDto createPayment(PaymentDto paymentDto) {
        log.info("Payment with id {} was created", paymentDto.getId());
        return paymentMapper.mapModelToDto(paymentRepository.createPayment(paymentMapper.mapDtoToModel(paymentDto)));
    }

    @Override
    public PaymentDto updatePayment(int id, PaymentDto paymentDto) {
        paymentDto.setId(id);
        log.info("Payment with id {} was updated", paymentDto.getId());
        return paymentMapper.mapModelToDto(paymentRepository.updatePayment(id, paymentMapper.mapDtoToModel(paymentDto)));
    }

    @Override
    public void deletePayment(int id) {
        paymentRepository.deletePayment(id);
        log.info("Payment with id {} was deleted", id);
    }

}
