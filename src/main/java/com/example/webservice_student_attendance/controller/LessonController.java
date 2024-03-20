package com.example.webservice_student_attendance.controller;

import com.example.webservice_student_attendance.Excaption.NotFountStudyGroup;
import com.example.webservice_student_attendance.entity.Lesson;
import com.example.webservice_student_attendance.enumPackage.WeekdayEnum;
import com.example.webservice_student_attendance.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidParameterException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("lessons/")
public class LessonController {

    private final LessonService lessonService;

    @GetMapping("weekdays/{weekday}") // надо обработать возможную ошибку
    public ResponseEntity<List<Lesson>> getLessonGroupAndWeekday(@PathVariable WeekdayEnum weekday){
        // по авторизованному пользоавателю смотрим какая у него группа и выдаем расписание на день
        int group = 98;
        List<Lesson> lessonList = null;
        try {
            lessonList = lessonService.findLessonsGroupAndWeekday(group, weekday).orElseThrow();
        } catch (NotFountStudyGroup | InvalidParameterException e){
            e.getStackTrace();
        }

        return ResponseEntity.ok(lessonList);
    }

    @GetMapping("weekdays")
    public Lesson getLessonGroupAndWeekda(){
        // по авторизованному пользоавателю смотрим какая у него группа и выдаем расписание на день

        return lessonService.findById(1).orElseThrow();

    }

    @GetMapping("week")
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
