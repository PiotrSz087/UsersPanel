package com.ps.UsersPanel.service;

import com.ps.UsersPanel.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {
    Page<User> getUserList(Pageable pageable);

    void save(User user);

    Optional<User> getUser(long id);

    void deleteUser(long id);

    Page<User> search(String searchName, Pageable pageable);

}
