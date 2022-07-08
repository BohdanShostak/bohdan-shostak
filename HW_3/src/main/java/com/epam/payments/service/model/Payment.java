package com.epam.payments.service.model;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
public class Payment {

    private int id;
    private long recipientAccount;
    private long recipientCardNumber;
    private double sum;
    private Date date;
    private String description;
    private PaymentStatus paymentStatus;
    private long accountId;

}
