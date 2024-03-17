package com.example.webservice_student_attendance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("schedule/")
public class FillScheduleController {

    // сделать чтение из pdf на сайте сибгиу и в сервисе сохранить расписание в БД

    @GetMapping("update")
    public void updateSchedule(){

    }

}
