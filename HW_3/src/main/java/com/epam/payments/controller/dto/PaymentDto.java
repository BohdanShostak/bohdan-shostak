package com.epam.payments.controller.dto;

import com.epam.payments.controller.validation.group.OnCreate;
import com.epam.payments.controller.validation.group.OnUpdate;
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

    @Positive(message = "{validation.payment.recipientAccount.positive}", groups = {OnCreate.class, OnUpdate.class})
    @NotNull(message = "{validation.payment.recipientAccount.not_null}", groups = {OnCreate.class, OnUpdate.class})
    private long recipientAccount;

    @NotNull(message = "{validation.payment.recipientCardNumber.not_null}", groups = {OnCreate.class, OnUpdate.class})
    @Positive(message = "{validation.payment.recipientCardNumber.positive}", groups = {OnCreate.class, OnUpdate.class})
    private long recipientCardNumber;

    @NotNull(message = "{validation.payment.sum.not_null}", groups = {OnCreate.class, OnUpdate.class})
    @Positive(message = "{validation.payment.sum.positive}", groups = {OnCreate.class, OnUpdate.class})
    private double sum;

    private String description;

    @NotNull(message = "{validation.payment.paymentStatus.not_null}", groups = {OnCreate.class, OnUpdate.class})
    private PaymentStatus paymentStatus;

    @NotNull(message = "{validation.payment.accountId.not_null}", groups = {OnCreate.class, OnUpdate.class})
    private long accountId;

}
