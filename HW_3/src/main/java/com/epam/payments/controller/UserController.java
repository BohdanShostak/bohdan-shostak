package com.epam.payments.controller;

import com.epam.payments.api.UserApi;
import com.epam.payments.controller.dto.UserDto;
import com.epam.payments.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController implements UserApi {

    private final UserService userService;

    @Override
    public List<UserDto> getAllUsers() {
        log.info("getAllUsers");
        return userService.listUsers();
    }

    @Override
    public UserDto getUserByEmail(String email) {
        log.info("getUser by email {}", email);
        return userService.getUser(email);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        log.info("createUser with email {}", userDto.getEmail());
        return userService.createUser(userDto);
    }

    @Override
    public UserDto updateUser(String email, UserDto userDto) {
        log.info("updateUser by email {}", email);
        return userService.updateUser(email, userDto);
    }

    @Override
    public void deleteUser(String email) {
        log.info("deleteUser by email {}", email);
        userService.deleteUser(email);
    }

}
