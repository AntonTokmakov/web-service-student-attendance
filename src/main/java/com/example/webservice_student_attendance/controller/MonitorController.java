package com.example.webservice_student_attendance.controller;

import com.example.webservice_student_attendance.Excaption.NotFountStudyGroup;
import com.example.webservice_student_attendance.dto.SetPassActualLessonGroupStudy;
import com.example.webservice_student_attendance.entity.ActualLesson;
import com.example.webservice_student_attendance.service.MonitorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/monitor")
public class MonitorController {

    private final MonitorService monitorService;


    @GetMapping("/student/pass")
    public SetPassActualLessonGroupStudy getStudentToPass(@RequestParam("lessonId") Long lessonId){

        // получение группы от зарегистрированного пользователя
        try {
            return monitorService.getStudentByStudyGroupToPass(13L, lessonId);
        } catch (NotFountStudyGroup e) {
            throw new RuntimeException(e);
        }
    }

}
