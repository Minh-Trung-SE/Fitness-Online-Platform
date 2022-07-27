package com.trungnm.fitnesswebapp.repository;


import com.trungnm.fitnesswebapp.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    ArrayList<Course> getAllByCourseId(int courseId);
}
