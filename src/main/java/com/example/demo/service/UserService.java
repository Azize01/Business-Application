package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.web_dto.UserRegistrationDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
   /* @Query(value = "SELECT * FROM user WHERE role = 'sales representative'", nativeQuery = true)
     List<User> listAll();*/
}
