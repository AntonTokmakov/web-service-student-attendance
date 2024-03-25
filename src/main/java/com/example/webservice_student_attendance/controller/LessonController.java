package com.example.webservice_student_attendance.controller;

import com.example.webservice_student_attendance.Excaption.NotFountStudyGroup;
import com.example.webservice_student_attendance.entity.ActualLesson;
import com.example.webservice_student_attendance.entity.Lesson;
import com.example.webservice_student_attendance.enumPackage.ParityWeekEnum;
import com.example.webservice_student_attendance.service.LessonAndActualLessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidParameterException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lessons")
public class LessonController {

    private final LessonAndActualLessonService lessonService;

    int group = 0;

    // надо выдавать пару по определенных датам, а не только днеё недели
    @GetMapping("/weekdays") // надо обработать возможную ошибку
    public ResponseEntity<List<ActualLesson>> getLessonGroupAndWeekday(@RequestParam("weekday") String weekday){
        // по авторизованному пользоавателю смотрим какая у него группа и выдаем расписание на день

        group = 13;


        ParityWeekEnum parity = ParityWeekEnum.НЕЧЕТНАЯ;
        List<ActualLesson> lessonList = null;
        try {
            lessonList = lessonService.findLessonsGroupAndWeekday(group, weekday, parity);
        } catch (NotFountStudyGroup | InvalidParameterException e){
            e.getStackTrace();
        }

        return ResponseEntity.ok(lessonList);
    }

    @GetMapping("/week")
    public List<Lesson> getLessonGroupAndWeek(){
        // по авторизованному пользоавтелю смотрим какая у него группа и выдаем ему расписания на неделю



        return null;
    }


    ////// Обработка исключений

    @ExceptionHandler(NotFountStudyGroup.class)
    public ResponseEntity<ProblemDetail> handleNotFountStudyGroupException(NotFountStudyGroup e){

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,
                        this.toString()));
    }


}
