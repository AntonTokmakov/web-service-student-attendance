package com.example.webservice_student_attendance.controller;

import com.example.webservice_student_attendance.entity.Lesson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("lesson/")
public class LessonController {

    @GetMapping("weekday/{weekday}")
    public List<Lesson> getLessonGroupAndWeekday(@PathVariable String weekday){
        // по авторизованному пользоавателю смотрим какая у него группа и выдаем расписание на день

        return null;
    }

    @GetMapping("week")
    public List<Lesson> getLessonGroupAndWeek(){
        // по авторизованному пользоавтелю смотрим какая у него группа и выдаем ему расписания на неделю
        return null;
    }



}
