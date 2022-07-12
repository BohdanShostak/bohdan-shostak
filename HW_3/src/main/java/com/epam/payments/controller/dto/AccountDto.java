package com.epam.payments.controller.dto;

import com.epam.payments.controller.dto.group.OnCreate;
import com.epam.payments.controller.dto.group.OnUpdate;
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

    //@JsonProperty(access = READ_ONLY)
    private long id;

    @NotNull(message = "'sum' shouldn't be empty", groups = {OnCreate.class, OnUpdate.class})
    private double sum;

    @NotNull(message = "'creditLimit' shouldn't be empty", groups = {OnCreate.class, OnUpdate.class})
    @PositiveOrZero(message = "'creditLimit' shouldn't be negative", groups = {OnCreate.class, OnUpdate.class})
    private double creditLimit;

    @NotNull(message = "'accountStatus' shouldn't be empty", groups = {OnCreate.class, OnUpdate.class})
    private AccountStatus accountStatus;

    @NotNull(message = "'userId' shouldn't be empty", groups = {OnCreate.class, OnUpdate.class})
    @Positive(message = "'userId' shouldn't be negative", groups = {OnCreate.class, OnUpdate.class})
    private int userId;

}
