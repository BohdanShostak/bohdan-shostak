package com.epam.payments.controller.dto;

import com.epam.payments.controller.validation.group.OnCreate;
import com.epam.payments.controller.validation.group.OnUpdate;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CardDto {

    //@JsonProperty(access = READ_ONLY)
    private long cardNumber;

    @NotBlank(message = "{validation.card.dueDate.not_null}", groups = {OnCreate.class, OnUpdate.class})
    @Pattern(regexp = "[0-9]{2}/[0-9]{2}", message = "{validation.card.dueDate.pattern}", groups = {OnCreate.class, OnUpdate.class})
    private String dueDate;

    @NotNull(message = "{validation.card.cvv.not_null}", groups = {OnCreate.class, OnUpdate.class})
    @Min(value = 100, message = "{validation.card.cvv.min}", groups = {OnCreate.class, OnUpdate.class})
    @Max(value = 999, message = "{validation.card.cvv.max}", groups = {OnCreate.class, OnUpdate.class})
    private int cvv;

    @NotBlank(message = "{validation.card.cardName.not_null}", groups = {OnCreate.class, OnUpdate.class})
    private String cardName;

    @NotNull(message = "{validation.card.accountId.not_null}", groups = {OnCreate.class, OnUpdate.class})
    @Positive(message = "{validation.card.accountId.positive}", groups = {OnCreate.class, OnUpdate.class})
    private long accountId;

}
