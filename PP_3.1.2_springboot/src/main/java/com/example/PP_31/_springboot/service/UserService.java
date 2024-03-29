package com.example.PP_31._springboot.service;

import com.example.PP_31._springboot.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> findById(Long id);

    List<User> findAll();

    void saveUser(User user);

    void deleteById(Long id);
}
