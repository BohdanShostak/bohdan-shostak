package com.epam.payments.service.mapper;

import com.epam.payments.controller.dto.PaymentDto;
import com.epam.payments.service.model.Payment;
import org.mapstruct.Mapper;

@Mapper
public interface PaymentMapper {

    PaymentDto mapModelToDto(Payment payment);

    Payment mapDtoToModel(PaymentDto paymentDto);

}
