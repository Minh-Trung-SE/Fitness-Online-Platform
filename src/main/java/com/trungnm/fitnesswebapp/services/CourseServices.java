package com.trungnm.fitnesswebapp.services;

import com.trungnm.fitnesswebapp.entity.Course;
import com.trungnm.fitnesswebapp.entity.RegisterLesson;
import com.trungnm.fitnesswebapp.repository.CourseRepository;
import com.trungnm.fitnesswebapp.repository.RegisterLessonRepository;
import com.trungnm.fitnesswebapp.responseEntity.ResponseCourse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class CourseServices {
    private final CourseRepository courseRepository;
    private final RegisterLessonRepository lessonRepository;

    public CourseServices(CourseRepository courseRepository, RegisterLessonRepository lessonRepository) {
        this.courseRepository = courseRepository;
        this.lessonRepository = lessonRepository;
    }

    public void registerCourse(String userPhone, int courseId){
        ArrayList<RegisterLesson> registerLesson = lessonRepository.findAllByUserPhoneAndIdCourseRegister(userPhone, courseId);
        if(registerLesson.size() == 0){
            ArrayList<Course> listLesson = courseRepository.getAllByCourseId(courseId);
            ArrayList<RegisterLesson> listLessonRegister = new ArrayList<RegisterLesson>();
            for (Course course : listLesson) {
                RegisterLesson register = new RegisterLesson();
                register.setIdCourseRegister(course.getCourseId());
                register.setIdLessonRegister(course.getLessonId());
                register.setUserPhone(userPhone);
                register.setIsBought(1);
                lessonRepository.save(register);
            }
        }else {
            for(RegisterLesson register: registerLesson){
                register.setIsBought(1);
                lessonRepository.save(register);
            }
        }
    }

    public void registerCourseByLesson(String userPhone, int courseId, int lessonId){
        RegisterLesson registerLessonExist = lessonRepository.findFirstByUserPhoneAndIdCourseRegister(userPhone, courseId);
        if(registerLessonExist == null){
            ArrayList<Course> listLesson = courseRepository.getAllByCourseId(courseId);
            ArrayList<RegisterLesson> listLessonRegister = new ArrayList<RegisterLesson>();
            for (Course course : listLesson) {
                RegisterLesson register = new RegisterLesson();
                register.setIdCourseRegister(course.getCourseId());
                register.setIdLessonRegister(course.getLessonId());
                register.setUserPhone(userPhone);
                register.setIsBought(0);
                lessonRepository.save(register);
            }
        }
        RegisterLesson registerLesson = lessonRepository.findFirstByUserPhoneAndIdCourseRegisterAndIdLessonRegister(userPhone, courseId, lessonId);
        registerLesson.setIsBought(1);
        lessonRepository.save(registerLesson);
    }

    public ArrayList<ResponseCourse> studyCourse(String userPhone, int courseId){
        ArrayList<Course> listCourseLesson = courseRepository.getAllByCourseId(courseId);
        ArrayList<RegisterLesson> listLessonActive = lessonRepository.findAllByUserPhoneAndIdCourseRegister(userPhone, courseId);
        if(listLessonActive.size() == 0){
            return null;
        }
        ArrayList<ResponseCourse> listLesson = new ArrayList<ResponseCourse>();
        for(int i = 0; i < listCourseLesson.size(); i++){
            ResponseCourse responseCourse = new ResponseCourse();
            responseCourse.setLessonId(listCourseLesson.get(i).getLessonId());
            responseCourse.setLessonTitle(listCourseLesson.get(i).getLessonTitle());
            responseCourse.setLinkLesson(listCourseLesson.get(i).getLinkLesson());
            if(listLessonActive.get(i).getIsBought() == 1){
                responseCourse.setIsBought(1);
            }
            listLesson.add(responseCourse);
        }
        return listLesson;
    }

    public ArrayList<Course> getListLessonByCourseId(int courseId){
        return courseRepository.getAllByCourseId(courseId);
    }

}
