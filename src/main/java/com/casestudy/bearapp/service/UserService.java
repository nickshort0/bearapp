package com.casestudy.bearapp.service;

import com.casestudy.bearapp.models.Bear;
import com.casestudy.bearapp.models.User;

public interface UserService {

    void saveUser(User user);
    User getUserById(long id);
    void addBear(long userId, Bear bear);
    void removeBear(long userId, long bearId);
}
