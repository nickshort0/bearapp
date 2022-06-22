package com.casestudy.bearapp.data;


import com.casestudy.bearapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
