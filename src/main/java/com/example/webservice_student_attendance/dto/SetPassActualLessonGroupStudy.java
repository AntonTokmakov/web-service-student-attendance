package com.example.webservice_student_attendance.dto;

import com.example.webservice_student_attendance.entity.ActualLesson;
import com.example.webservice_student_attendance.entity.Student;
import com.example.webservice_student_attendance.entity.StudyGroup;
import lombok.Builder;

import java.util.List;

@Builder
public record SetPassActualLessonGroupStudy
        (List<Student> studentList,
         ActualLesson actualLesson){

}
