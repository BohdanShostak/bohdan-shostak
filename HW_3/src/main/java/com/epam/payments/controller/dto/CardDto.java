package com.epam.payments.controller.dto;

import com.epam.payments.controller.dto.validation.group.OnCreate;
import com.epam.payments.controller.dto.validation.group.OnUpdate;
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

    @NotBlank(message = "'dueDate' shouldn't be empty", groups = {OnCreate.class, OnUpdate.class})
    @Pattern(regexp = "[0-9]{2}/[0-9]{2}", message = "'dueDate' should be correct", groups = {OnCreate.class, OnUpdate.class})
    private String dueDate;

    @NotNull(message = "'cvv' shouldn't be empty", groups = {OnCreate.class, OnUpdate.class})
    @Min(value = 100, message = "'cvv' shouldn't be less than 100", groups = {OnCreate.class, OnUpdate.class})
    @Max(value = 999, message = "'cvv' shouldn't be more than 999", groups = {OnCreate.class, OnUpdate.class})
    private int cvv;

    @NotBlank(message = "'cardName' shouldn't be empty", groups = {OnCreate.class, OnUpdate.class})
    private String cardName;

    @NotNull(message = "'accountId' shouldn't be empty", groups = {OnCreate.class, OnUpdate.class})
    @Positive(message = "'accountId' shouldn't be negative", groups = {OnCreate.class, OnUpdate.class})
    private long accountId;

}
