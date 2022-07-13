package com.epam.payments.controller.dto;

import com.epam.payments.controller.dto.group.OnCreate;
import com.epam.payments.controller.dto.group.OnUpdate;
import com.epam.payments.service.model.enums.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentDto {

    @JsonProperty(access = READ_ONLY)
    private int id;

    @Positive(message = "'recipientAccount' must not be less than 0", groups = {OnCreate.class, OnUpdate.class})
    @NotNull(message = "'recipientAccount' shouldn't be empty", groups = {OnCreate.class, OnUpdate.class})
    private long recipientAccount;

    @NotNull(message = "'recipientCardNumber' shouldn't be empty", groups = {OnCreate.class, OnUpdate.class})
    @Positive(message = "'recipientCardNumber' must not be less than 0", groups = {OnCreate.class, OnUpdate.class})
    private long recipientCardNumber;

    @NotNull(message = "'sum' shouldn't be empty", groups = {OnCreate.class, OnUpdate.class})
    @Positive(message = "'sum' must not be less than 0", groups = {OnCreate.class, OnUpdate.class})
    private double sum;

    private String description;

    @NotNull(message = "'paymentStatus' shouldn't be empty", groups = {OnCreate.class, OnUpdate.class})
    private PaymentStatus paymentStatus;

    @NotNull(message = "'accountId' shouldn't be empty", groups = {OnCreate.class, OnUpdate.class})
    private long accountId;

}
