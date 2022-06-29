package com.epam.payments.service.model;

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
