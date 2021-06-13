package com.example.OnlineClassWebApp.repository;

import com.example.OnlineClassWebApp.entity.RegisterLesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository
public interface RegisterLessonRepository extends JpaRepository<RegisterLesson, Integer> {
    RegisterLesson findFirstByUserPhoneAndIdCourseRegister(String userPhone, int courseId);
    RegisterLesson findFirstByUserPhoneAndIdCourseRegisterAndIdLessonRegister(String userPhone, int courseId, int lessonId);
    ArrayList<RegisterLesson> findAllByUserPhoneAndIdCourseRegister(String userPhone, int courseId);

}
