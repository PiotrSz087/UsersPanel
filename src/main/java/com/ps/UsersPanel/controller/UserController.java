package com.ps.UsersPanel.controller;

import com.ps.UsersPanel.dao.UserDao;
import com.ps.UsersPanel.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserDao userDao;

    @Autowired
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @RequestMapping("/list")
    public String listOfUsers(Model model) {
        List<User> userList = userDao.getUserList();
        model.addAttribute("users", userList);
        return "user-list";
    }
}
