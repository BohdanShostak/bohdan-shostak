package com.epam.payments.controller.dto;

import com.epam.payments.controller.validation.group.OnCreate;
import com.epam.payments.controller.validation.group.OnUpdate;
import com.epam.payments.service.model.enums.AccountStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountDto {

    @JsonProperty(access = READ_ONLY)
    private long id;

    @NotNull(message = "{validation.account.sum.not_null}", groups = {OnCreate.class, OnUpdate.class})
    private double sum;

    @NotNull(message = "{validation.account.creditLimit.not_null}", groups = {OnCreate.class, OnUpdate.class})
    @PositiveOrZero(message = "{validation.account.creditLimit.positive}", groups = {OnCreate.class, OnUpdate.class})
    private double creditLimit;

    @NotNull(message = "{validation.account.accountStatus.not_null}", groups = {OnCreate.class, OnUpdate.class})
    private AccountStatus accountStatus;

    @NotNull(message = "{validation.account.userId.not_null}", groups = {OnCreate.class, OnUpdate.class})
    @Positive(message = "{validation.account.userId.positive}", groups = {OnCreate.class, OnUpdate.class})
    private int userId;

}
