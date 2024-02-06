package com.example.PP_31._springboot.controller;


import com.example.PP_31._springboot.model.User;
import com.example.PP_31._springboot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ModelAndView findAll() {
        return new ModelAndView("user-list").addObject("users", userService.findAll());
    }

    @GetMapping("/user-create")
    public ModelAndView createUserFrom(@ModelAttribute("user") User user) {
        return new ModelAndView("user-create");
    }

    @PostMapping("/user-create")
    public ModelAndView createUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return new ModelAndView("redirect:/");
    }

    @GetMapping("user-delete/{id}")
    public ModelAndView deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return new ModelAndView("redirect:/");
    }

//    @GetMapping("user-update/{id}")
//    public ModelAndView updateUserForm(@PathVariable("id") Long id) {
//        return new ModelAndView("user-update").addObject("user", userService.findById(id));
//    }
    @PostMapping("/user-update")
    public ModelAndView updateUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return new ModelAndView("redirect:/");
    }
    @GetMapping("user-update/{id}")
    public ModelAndView updateUserFrom(@PathVariable("id") Long id, Model model) {
        ModelAndView modelAndView = new ModelAndView();
        Optional<User> user = userService.findById(id);
        model.addAttribute("user", user);
        modelAndView.setViewName("/user-update");
        return modelAndView;
    }

}
