package com.ankit.UserService.repo;

import com.ankit.UserService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, String> {
}
