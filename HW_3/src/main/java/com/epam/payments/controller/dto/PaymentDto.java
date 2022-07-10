package com.epam.payments.controller.dto;

import com.epam.payments.service.model.enums.PaymentStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentDto {

    private int id;
    private long recipientAccount;
    private long recipientCardNumber;
    private double sum;
    private String description;
    private PaymentStatus paymentStatus;
    private long accountId;

}
