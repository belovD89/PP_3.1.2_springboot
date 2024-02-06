package com.example.PP_31._springboot.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String name;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "email")
    private String email;

}
