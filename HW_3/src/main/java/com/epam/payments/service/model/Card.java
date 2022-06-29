package com.epam.payments.service.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Card {
    private long cardNumber;
    private String dueDate;
    private int cvv;
    private String cardName;
    private long accountId;

}
