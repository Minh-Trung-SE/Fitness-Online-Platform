package com.example.OnlineClassWebApp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter @Setter
@Entity
@Table(name = "course_register")
public class RegisterLesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_phone")
    private String userPhone;

    @Column(name = "course_id")
    private int idCourseRegister;

    @Column(name = "lesson_id")
    private int idLessonRegister;

    @Column(name = "is_bought")
    private int isBought;

    public RegisterLesson(int id, String userPhone, int idCourseRegister, int idLessonRegister, int isBought) {
        this.id = id;
        this.userPhone = userPhone;
        this.idCourseRegister = idCourseRegister;
        this.idLessonRegister = idLessonRegister;
        this.isBought = isBought;
    }

    public RegisterLesson(String userPhone, int idCourseRegister, int idLessonRegister, int isBought) {
        this.userPhone = userPhone;
        this.idCourseRegister = idCourseRegister;
        this.idLessonRegister = idLessonRegister;
        this.isBought = isBought;
    }

    public RegisterLesson() {

    }

    @Override
    public String toString() {
        return "RegisterLesson{" +
                "id=" + id +
                ", userPhone='" + userPhone + '\'' +
                ", idCourseRegister=" + idCourseRegister +
                ", idLessonRegister=" + idLessonRegister +
                ", isBought=" + isBought +
                '}';
    }
}
