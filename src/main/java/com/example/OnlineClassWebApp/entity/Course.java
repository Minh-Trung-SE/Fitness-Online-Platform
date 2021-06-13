package com.example.OnlineClassWebApp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.annotation.processing.Generated;
import javax.persistence.*;
@Getter @Setter
@Entity
@Table(name = "course_detail")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "course_id")
    private int courseId;
    @Column(name = "lesson_id")
    private int lessonId;
    @Column(name = "lesson_title")
    private String lessonTitle;
    @Column(name = "lesson_data")
    private String linkLesson;
}
