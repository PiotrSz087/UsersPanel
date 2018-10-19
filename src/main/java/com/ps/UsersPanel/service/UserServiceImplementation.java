package com.ps.UsersPanel.service;

import com.ps.UsersPanel.entity.User;
import com.ps.UsersPanel.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
        return userRepo.findAll(sortByName());
    }

    private Sort sortByName() {
        return new Sort(Sort.Direction.ASC, "firstName");
    }

    @Override
    @Transactional
    public void save(User user) {
        userRepo.save(user);
    }

    @Override
    public User getUser(long id) {
        return userRepo.getOne(id);
    }

    @Override
    public void deleteUser(long id) {
        userRepo.deleteById(id);
    }

    @Override
    public List<User> search(String searchName) {
        return userRepo.findAllByFirstName(searchName);
    }

}
