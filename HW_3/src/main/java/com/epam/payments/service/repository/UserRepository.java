package com.epam.payments.service.repository;

import com.epam.payments.service.model.User;

import java.util.List;

public interface UserRepository {

    User getUser(String email);

    List<User> listUsers();

    User createUser(User user);

    User updateUser(String email, User user);

    void deleteUser(String email);

}
