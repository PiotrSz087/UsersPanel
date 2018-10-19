package com.ps.UsersPanel.repository;

import com.ps.UsersPanel.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.firstName = ?1")
    List<User> findAllByFirstName(String searchName);
}
