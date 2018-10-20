package com.ps.UsersPanel.controller;

import com.ps.UsersPanel.entity.User;
import com.ps.UsersPanel.repository.UserRepo;
import com.ps.UsersPanel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    private UserRepo userRepo;

    @Autowired
    public UserController(UserService userService, UserRepo userRepo) {
        this.userService = userService;
        this.userRepo = userRepo;
    }

    @GetMapping("/list")
    public String listOfUsers(@RequestParam(defaultValue = "0") int page,  Model model) {
        User user = new User();
        model.addAttribute("usr", user);
        Page<User> userPage = userRepo.findAll(PageRequest.of(page, 10, Sort.by(Sort.Direction.ASC, "firstName")));
        model.addAttribute("page", userPage);
        return "user-list";
    }

    @PostMapping("/processForm")
    public String processFrom(@ModelAttribute("usr") User user) {
        userService.save(user);
        return "redirect:/user/list";
    }

    @GetMapping("/showUpdate")
    public String updateForm(@RequestParam("id") long id, Model model) {
        Optional<User> user = userService.getUser(id);
        model.addAttribute("usr", user);
        return "update-list";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("id") long id) {
        userService.deleteUser(id);
        return "redirect:/user/list";
    }

    @PostMapping("/search")
    public String searchUser(@RequestParam(value = "searchName") String searchName, @PageableDefault(size = 10) Pageable pageable, Model model){
        User user = new User();
        Page<User> userList = userService.search(searchName, pageable);
        model.addAttribute("usr", user);
        model.addAttribute("page", userList);
        return "user-list";
    }
}
