package com.ps.UsersPanel.repository;

import com.ps.UsersPanel.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {

//    @Query("SELECT u FROM User u WHERE u.firstName = ?1")
    @Query(nativeQuery = true, value = "SELECT * FROM users WHERE first_name = ?1")
    Page<User> findAllByFirstName(String searchName, Pageable pageable);
}
