package com.example.OnlineClassWebApp.services;

import com.example.OnlineClassWebApp.entity.User;
import com.example.OnlineClassWebApp.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServices {
    private final UserRepository userRepository;

    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean userLogin(User user){
        User userLogin = userRepository.findByUserPhone(user.getUserPhone());
        if(userLogin == null){
            System.out.println("Not exist!");
            return false;
        }
        user.setUserName(userLogin.getUserName());
        System.out.println(user.getUserName());
        return userLogin.getUserPassword().equals(user.getUserPassword());
    }

    public boolean userRegister(User user){
        User userExist = new User();
        userExist = userRepository.findByUserPhoneAndUserEmail(user.getUserPhone(), user.getUserEmail());
        if( userExist != null){
            return false;
        }
        userRepository.save(user);
        return true;
    }

    public String getUserName(String userPhone){
        User user = userRepository.findByUserPhone(userPhone);
        return user.getUserName();
    }

}
