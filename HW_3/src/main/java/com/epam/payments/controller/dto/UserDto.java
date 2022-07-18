package com.epam.payments.controller.dto;

import com.epam.payments.controller.dto.validation.Phone;
import com.epam.payments.controller.dto.validation.group.OnCreate;
import com.epam.payments.controller.dto.validation.group.OnUpdate;
import com.epam.payments.service.model.enums.Role;
import com.epam.payments.service.model.enums.UserStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

    @JsonProperty(access = READ_ONLY)
    private int id;

    @NotBlank(message = "'login' shouldn't be empty", groups = {OnCreate.class, OnUpdate.class})
    private String login;

    @NotBlank(message = "'firstName' shouldn't be empty", groups = {OnCreate.class, OnUpdate.class})
    private String firstName;

    @NotBlank(message = "'secondName' shouldn't be empty", groups = {OnCreate.class, OnUpdate.class})
    private String secondName;

    @Email(groups = {OnCreate.class, OnUpdate.class})
    @NotBlank(message = "'email' shouldn't be empty", groups = {OnCreate.class, OnUpdate.class})
    private String email;

    @Phone(groups = {OnCreate.class, OnUpdate.class})
    private String tel;

    @NotNull(message = "'userStatus' shouldn't be empty", groups = {OnCreate.class, OnUpdate.class})
    private UserStatus userStatus;

    @NotNull(message = "'role' shouldn't be empty", groups = {OnCreate.class, OnUpdate.class})
    private Role role;

}
