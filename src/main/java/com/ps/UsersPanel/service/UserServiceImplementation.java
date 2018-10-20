package com.ps.UsersPanel.service;

import com.ps.UsersPanel.entity.User;
import com.ps.UsersPanel.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class UserServiceImplementation implements UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserServiceImplementation(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    @Transactional
    public Page<User> getUserList(Pageable pageable) {
        return userRepo.findAll(pageable);
    }

    @Override
    @Transactional
    public void save(User user) {
        userRepo.save(user);
    }

    @Override
    public Optional<User> getUser(long id) {
        return userRepo.findById(id);
    }

    @Override
    public void deleteUser(long id) {
        userRepo.deleteById(id);
    }

    @Override
    public Page<User> search(String searchName, Pageable pageable) {
        return userRepo.findAllByFirstName(searchName, pageable);
    }

}
