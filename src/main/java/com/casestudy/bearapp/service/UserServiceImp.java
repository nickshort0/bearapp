package com.casestudy.bearapp.service;

import com.casestudy.bearapp.data.BearRepository;
import com.casestudy.bearapp.data.UserRepository;
import com.casestudy.bearapp.models.Bear;
import com.casestudy.bearapp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService{

    UserRepository userRepository;
    BearRepository bearRepository;

    @Autowired
    public UserServiceImp(UserRepository userRepository, BearRepository bearRepository) {
        this.userRepository = userRepository;
        this.bearRepository = bearRepository;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(long id) {
        Optional<User> optional = userRepository.findById(id);
        User user;
        if(optional.isPresent()){
            user = optional.get();
        }
        else{
            throw new RuntimeException("User not found for id " + id);
        }
        return user;
    }

    @Override
    public void addBear(long userId, Bear bear) {
        User user = getUserById(userId);
        user.addBear(bear);
        userRepository.save(user);

    }

    @Override
    public void removeBear(long userId, Bear bear) {
        User user = getUserById(userId);
        user.removeBear(bear);
    }
}
