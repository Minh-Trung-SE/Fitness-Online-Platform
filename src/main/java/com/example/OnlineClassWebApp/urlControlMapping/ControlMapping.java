package com.example.OnlineClassWebApp.urlControlMapping;

import com.example.OnlineClassWebApp.entity.Course;
import com.example.OnlineClassWebApp.entity.User;
import com.example.OnlineClassWebApp.responseEntity.ResponseCourse;
import com.example.OnlineClassWebApp.services.CourseServices;
import com.example.OnlineClassWebApp.services.UserServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class ControlMapping {
    private final UserServices userServices;
    private final CourseServices courseServices;

    public ControlMapping(UserServices userServices, CourseServices courseServices) {
        this.userServices = userServices;
        this.courseServices = courseServices;
    }

    @GetMapping(value = {"/home", "/"})
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
//            System.out.println(user.getUserPhone());
            model.addAttribute("user", user);
            return "homePage";
        }
        return "redirect:/home";
    }

    @GetMapping(value = "/study")
    @ResponseBody
    public ArrayList<ResponseCourse> study(@RequestParam String userPhone, @RequestParam int courseId){
        return courseServices.studyCourse(userPhone, courseId);
    }

    @GetMapping(value = "/register")
    @ResponseBody
    public void registerFullCourse(@RequestParam String userPhone, @RequestParam int courseId){
        System.out.println(userPhone + " : " + courseId);
        courseServices.registerCourse(userPhone, courseId);
    }

    @GetMapping(value = "/registerByUnit")
    @ResponseBody
    public void registerCourseByLesson(@RequestParam String userPhone, @RequestParam int courseId, @RequestParam int lessonId){
        courseServices.registerCourseByLesson(userPhone, courseId, lessonId);
    }

    @GetMapping(value = "/studyHome")
    public String learnCourse(Model model, @RequestParam String userPhone){
        ArrayList<ResponseCourse> listLesson = new ArrayList<ResponseCourse>();
        listLesson = courseServices.studyCourse(userPhone, 1);
        if (listLesson == null){
            return "redirect:/home";
        }
        model.addAttribute("listLesson", listLesson);
        return "study";
    }

    @GetMapping(value = "/course")
    public String showPageBuyCourse(Model model, @RequestParam String userPhone, @RequestParam int courseId){
        ArrayList<Course> listLessons = courseServices.getListLessonByCourseId(courseId);
        model.addAttribute("userName", userServices.getUserName(userPhone));
        model.addAttribute("userPhone", userPhone);
        model.addAttribute("courseId", courseId);
        model.addAttribute("listLessons", listLessons);
        return "buyCourse";
    }
}
