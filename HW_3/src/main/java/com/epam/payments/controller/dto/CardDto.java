package com.epam.payments.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CardDto {

    private long cardNumber;
    private String dueDate;
    private int cvv;
    private String cardName;
    private long accountId;

}
