package com.ps.UsersPanel.service;

import com.ps.UsersPanel.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> getUserList();

    void save(User user);

    User getUser(long id);

    void deleteUser(long id);
}
