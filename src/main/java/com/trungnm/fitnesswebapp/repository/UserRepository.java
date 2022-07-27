package com.trungnm.fitnesswebapp.repository;


import com.trungnm.fitnesswebapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUserPhone(String userPhone);
    User findByUserPhoneAndUserEmail(String userPhone, String userEmail);
}
