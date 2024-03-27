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
import org.springframework.web.bind.annotation.*;

import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lessons")
public class LessonController {

    private final LessonAndActualLessonService lessonAndActualLessonService;

    int group = 0;

    // надо выдавать пару по определенных датам, а не только днеё недели
    @GetMapping("/weekdays") // надо обработать возможную ошибку
    public ResponseEntity<List<ActualLesson>> getActualLessonByDateAndStudyGroup(@RequestParam("weekday") String weekday){
        // по авторизованному пользоавателю смотрим какая у него группа и выдаем расписание на день

        group = 13;

//        lessonAndActualLessonService.findActualLessonByDateAndStudy(date, group);

        ParityWeekEnum parity = ParityWeekEnum.НЕЧЕТНАЯ;
        List<ActualLesson> lessonList = null;
        try {
            lessonList = lessonAndActualLessonService.findLessonsGroupAndWeekday(group, weekday, parity);
        } catch (NotFountStudyGroup | InvalidParameterException e){
            e.getStackTrace();
        }

        return ResponseEntity.ok(lessonList);
    }



    // удалить
    private final ActualLessonRepository actualLessonRepository;


    @GetMapping("/week")
    public ResponseEntity<List<ActualLesson>> getLessonGroupAndWeek(@RequestParam("id") int id){
        // по авторизованному пользоавтелю смотрим какая у него группа и выдаем ему расписания на неделю


        group = 21;

        LocalDate date = LocalDate.of(2024, 2, id);
        List<ActualLesson> actualLessonList;

        try {
            actualLessonList = lessonAndActualLessonService.findActualLessonByDateAndStudy(date, group);
        } catch (NotFountStudyGroup e) {
            throw new RuntimeException("Ошибка, упсс");
        }

        return ResponseEntity.ok(actualLessonList);
//        LocalDate date = LocalDate.of(2024, 2, 5);
//
//        return actualLessonRepository.findById((long) id).orElse(null);
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
