package com.Tesla.Tesla.controller;

import com.Tesla.Tesla.model.User;
import com.Tesla.Tesla.model.Book;
import com.Tesla.Tesla.repository.UserRepository;
import com.Tesla.Tesla.repository.BookRepository;
import com.Tesla.Tesla.service.BookService;
import com.Tesla.Tesla.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterController {
    private final UserService userService;


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    public RegisterController(UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping("register")
    public String myRegister(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("register")
    public String registration(@ModelAttribute("user") User user, BindingResult error, Model model){
        //UserValidator uv = new UserValidator();
        //uv.validate(user, error);


        if(error.hasErrors())
           // model.addAttribute(userForm);
            return "register";
         userService.save(user);
        return "index";
    }

}
