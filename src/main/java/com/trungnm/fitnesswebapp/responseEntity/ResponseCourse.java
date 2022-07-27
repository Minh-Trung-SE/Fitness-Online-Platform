package com.trungnm.fitnesswebapp.responseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseCourse {
    private int lessonId;
    private String lessonTitle;
    private String linkLesson;
    private int isBought = 0;

    public ResponseCourse() {
    }

    @Override
    public String toString() {
        return "ResponseCourse{" +
                "lessonId=" + lessonId +
                ", lessonTitle='" + lessonTitle + '\'' +
                ", linkLesson='" + linkLesson + '\'' +
                ", isBought=" + isBought +
                '}';
    }
}
