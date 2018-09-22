package com.ps.UsersPanel.service;

import com.ps.UsersPanel.entity.User;
import com.ps.UsersPanel.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserServiceImplementation implements UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserServiceImplementation(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    @Transactional
    public List<User> getUserList() {
        return userRepo.findAll();
    }
}
