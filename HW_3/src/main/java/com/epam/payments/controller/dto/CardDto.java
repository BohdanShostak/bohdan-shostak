package com.epam.payments.controller.dto;

import com.epam.payments.controller.dto.group.OnCreate;
import com.epam.payments.controller.dto.group.OnUpdate;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CardDto {

    //@JsonProperty(access = READ_ONLY)
    private long cardNumber;

    @NotBlank(message = "'dueDate' shouldn't be empty", groups = {OnCreate.class, OnUpdate.class})
    @Pattern(regexp = "([0-9]{2}/[0-9]{2})")
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
