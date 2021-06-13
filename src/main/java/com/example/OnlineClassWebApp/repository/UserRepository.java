package com.example.OnlineClassWebApp.repository;

import com.example.OnlineClassWebApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUserPhone(String userPhone);
    User findByUserPhoneAndUserEmail(String userPhone, String userEmail);
}
