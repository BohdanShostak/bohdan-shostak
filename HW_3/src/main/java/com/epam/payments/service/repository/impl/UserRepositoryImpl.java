package com.epam.payments.service.repository.impl;

import com.epam.payments.exception.EntityExistsException;
import com.epam.payments.exception.UserNotFoundException;
import com.epam.payments.service.model.User;
import com.epam.payments.service.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final List<User> userList = new ArrayList<>();

    @Override
    public User getUser(String email) {
        return userList.stream()
                .filter(user -> user.getEmail()
                        .equals(email))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException(email));
    }

    @Override
    public List<User> listUsers() {
        return new ArrayList<>(userList);
    }

    @Override
    public User createUser(User user) {
        if (userList.stream().anyMatch((u)->u.getEmail().equals(user.getEmail()))) {
            throw new EntityExistsException("User with this email already exists");
        }
        user.setId(userList.size() + 1);
        userList.add(user);
        return user;
    }

    @Override
    public User updateUser(String email, User user) {
        User oldUser = userList.stream()
                .filter(u -> u.getEmail()
                        .equals(email))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException(email));
        userList.remove(oldUser);
        user.setId(oldUser.getId());
        userList.add(user);
        return user;
    }

    @Override
    public void deleteUser(String email) {
        userList.removeIf(user -> user.getEmail().equals(email));
    }

}
