package com.example.webservice_student_attendance.controller;

import com.example.webservice_student_attendance.Excaption.NotFountStudyGroup;
import com.example.webservice_student_attendance.entity.ActualLesson;
import com.example.webservice_student_attendance.entity.Lesson;
import com.example.webservice_student_attendance.enumPackage.ParityWeekEnum;
import com.example.webservice_student_attendance.repository.ActualLessonRepository;
import com.example.webservice_student_attendance.repository.LessonRepository;
import com.example.webservice_student_attendance.service.LessonAndActualLessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.security.InvalidParameterException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lessons")
public class LessonController {

    private final LessonAndActualLessonService lessonAndActualLessonService;

    int group = 0;

    // удалить
    private final ActualLessonRepository actualLessonRepository;


    @GetMapping("/weekdays")
    public ResponseEntity<List<ActualLesson>> getLessonGroupAndWeek(@RequestParam("day") int id){
        // по авторизованному пользоавтелю смотрим какая у него группа и выдаем ему расписания на неделю
        //group = SecurityContextHolder.getContext().getAuthentication().getName()).getStudyGroup().getId();
        List<ActualLesson> actualLessonList = null;
        try {
            group = 13;
            LocalDate date = LocalDate.of(2024, 2, id);
            actualLessonList = lessonAndActualLessonService.findActualLessonByDateAndStudy(date, group);
        } catch (HttpClientErrorException.BadRequest e){
            ProblemDetail problemDetail = e.getResponseBodyAs(ProblemDetail.class);
            problemDetail.getProperties().get("errors");
        } catch (NotFountStudyGroup e) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (DateTimeException e){
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

        return ResponseEntity.ok(actualLessonList);
    }

    private final LessonRepository lessonRepository;

    @GetMapping("/week2")
    public Lesson getLessonGroupAndWeek2(){
        // по авторизованному пользоавтелю смотрим какая у него группа и выдаем ему расписания на неделю

        int idLesson = 178;

        return lessonRepository.findById((long) idLesson).orElse(null);
    }


    ////// Обработка исключений

    @ExceptionHandler(NotFountStudyGroup.class)
    public ResponseEntity<ProblemDetail> handleNotFountStudyGroupException(NotFountStudyGroup e){

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,
                        this.toString()));
    }


}
