package com.epam.payments.service.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Account {
    private long id;
    private double sum;
    private double creditLimit;
    private  AccountStatus accountStatus;
    private int userId;
}
