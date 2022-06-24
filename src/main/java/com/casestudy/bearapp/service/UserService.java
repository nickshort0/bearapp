package com.casestudy.bearapp.service;

import com.casestudy.bearapp.models.Bear;
import com.casestudy.bearapp.models.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);
    void deleteUser(User user);
    List<User> getAllUsers();
    User getUserById(long id);
    void addBear(long userId, Bear bear);
    void removeBear(long userId, Bear bear);
}
