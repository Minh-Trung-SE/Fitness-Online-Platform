package com.example.OnlineClassWebApp.urlControlMapping;

import com.example.OnlineClassWebApp.entity.User;
import com.example.OnlineClassWebApp.services.UserServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserControlMapping {
    private final UserServices userServices;

    public UserControlMapping(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping(value = "/home")
    public String showHome(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "index";
    }

    @PostMapping(value = "/homePage" )
    public String userLogin(Model model, @ModelAttribute("user") User user){
        if(userServices.userLogin(user)){
            model.addAttribute("user", user);
            return "homePage";
        }
        return "redirect:/home";
    }

    @PostMapping(value = "/register")
    public String userRegister(Model model, @ModelAttribute("user") User user){
        if(userServices.userRegister(user)){
            System.out.println(user.getUserPhone());
            model.addAttribute("user", user);
            return "homePage";
        }
        return "redirect:/home";
    }
}
