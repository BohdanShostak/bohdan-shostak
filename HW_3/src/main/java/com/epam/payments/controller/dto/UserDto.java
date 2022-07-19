package com.epam.payments.controller.dto;

import com.epam.payments.controller.validation.Phone;
import com.epam.payments.controller.validation.group.OnCreate;
import com.epam.payments.controller.validation.group.OnUpdate;
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

    @NotBlank(message = "{validation.user.login.not_null}", groups = {OnCreate.class, OnUpdate.class})
    private String login;

    @NotBlank(message = "{validation.user.firstName.not_null}", groups = {OnCreate.class, OnUpdate.class})
    private String firstName;

    @NotBlank(message = "{validation.user.secondName.not_null}", groups = {OnCreate.class, OnUpdate.class})
    private String secondName;

    @Email(groups = {OnCreate.class, OnUpdate.class})
    @NotBlank(message = "{validation.user.email.not_null}", groups = {OnCreate.class, OnUpdate.class})
    private String email;

    @Phone(groups = {OnCreate.class, OnUpdate.class})
    private String tel;

    @NotNull(message = "{validation.user.userStatus.not_null}", groups = {OnCreate.class, OnUpdate.class})
    private UserStatus userStatus;

    @NotNull(message = "{validation.user.role.not_null}", groups = {OnCreate.class, OnUpdate.class})
    private Role role;

}
