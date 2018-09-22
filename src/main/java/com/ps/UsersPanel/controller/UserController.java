package com.ps.UsersPanel.controller;

import com.ps.UsersPanel.service.UserService;
import com.ps.UsersPanel.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public String listOfUsers(Model model) {
        User user = new User();
        List<User> userList = userService.getUserList();
        model.addAttribute("usr", user);
        model.addAttribute("users", userList);
        return "user-list";
    }

    @PostMapping("/processForm")
    public String processFrom(@ModelAttribute("usr") User user) {
        userService.save(user);
        return "redirect:/user/list";
    }
}
