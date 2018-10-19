package com.ps.UsersPanel.controller;

import com.ps.UsersPanel.entity.User;
import com.ps.UsersPanel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/showUpdate")
    public String updateForm(@RequestParam("id") long id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("usr", user);
        System.out.println(user.getFirstName());
        return "update-list";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("id") long id) {
        userService.deleteUser(id);
        return "redirect:/user/list";
    }

    @PostMapping("/search")
    public String searchUser(@RequestParam(value = "searchName") String searchName, Model model){
        User user = new User();
        List<User> userList = userService.search(searchName);
        model.addAttribute("usr", user);
        model.addAttribute("users", userList);
        return "user-list";
    }
}
