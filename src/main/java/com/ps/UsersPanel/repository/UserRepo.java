package com.ps.UsersPanel.repository;

import com.ps.UsersPanel.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
