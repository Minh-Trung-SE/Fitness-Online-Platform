package com.example.OnlineClassWebApp.urlControlMapping;

import com.example.OnlineClassWebApp.entity.User;
import com.example.OnlineClassWebApp.responseEntity.ResponseCourse;
import com.example.OnlineClassWebApp.services.CourseServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class CourseControlMapping {
    private final CourseServices courseServices;

    public CourseControlMapping(CourseServices courseServices) {
        this.courseServices = courseServices;
    }

    @GetMapping(value = "/study")
    @ResponseBody
    public ArrayList<ResponseCourse> study(@RequestParam String userPhone, @RequestParam int courseId){
        return courseServices.studyCourse(userPhone, courseId);
    }

    @GetMapping(value = "/register")
    @ResponseBody
    public String registerFullCourse(@RequestParam String userPhone, @RequestParam int courseId){
        courseServices.registerCourse(userPhone, courseId);
        return "ok";
    }

    @GetMapping(value = "/registerByUnit")
    @ResponseBody
    public String registerCourseByLesson(@RequestParam String userPhone, @RequestParam int courseId, @RequestParam int lessonId){
        courseServices.registerCourseByLesson(userPhone, courseId, lessonId);
        return "ok";
    }

    @GetMapping(value = "/studyHome")
    public String learnCourse(Model model, @RequestParam String userPhone){
        ArrayList<ResponseCourse> listLesson = new ArrayList<ResponseCourse>();
        listLesson = courseServices.studyCourse(userPhone, 1);
        model.addAttribute("listLesson", listLesson);
        return "study";
    }

}
