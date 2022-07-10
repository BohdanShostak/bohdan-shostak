package com.epam.payments.service.model;

import com.epam.payments.service.model.enums.Role;
import com.epam.payments.service.model.enums.UserStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private int id;
    private String login;
    private String password;
    private String firstName;
    private String secondName;
    private String email;
    private String tel;
    private UserStatus userStatus;
    private Role role;

}
