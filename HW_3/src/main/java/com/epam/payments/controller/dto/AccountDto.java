package com.epam.payments.controller.dto;

import com.epam.payments.service.model.AccountStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountDto {

    private long id;
    private double sum;
    private double creditLimit;
    private AccountStatus accountStatus;
    private int userId;

}
