package com.example.PP_31._springboot.repository;

import com.example.PP_31._springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

}
