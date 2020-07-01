package com.Tesla.Tesla.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.Tesla.Tesla.model.User;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping({"/", "", "index", "home"})
    public String myHome(Model model) {
        model.addAttribute("user",new User());

        return "index";
    }
}
