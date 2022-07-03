package com.casestudy.bearapp.service;

import com.casestudy.bearapp.data.BearRepository;
import com.casestudy.bearapp.data.UserRepository;
import com.casestudy.bearapp.models.Bear;
import com.casestudy.bearapp.models.User;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Transactional(rollbackOn = {DataAccessException.class})
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
    public User getUserByUsername(String username) {
        Optional<User> optional = userRepository.findByUsername(username);
        User user;
        if(optional.isPresent()){
            user = optional.get();
        }
        else{
            throw new UsernameNotFoundException("User not found for username: " + username);
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
