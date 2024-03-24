package com.example.webservice_student_attendance.controller;

import com.example.webservice_student_attendance.service.FillSheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequiredArgsConstructor
@RequestMapping("schedule/")
public class FillScheduleController {

    // сделать чтение из pdf на сайте сибгиу и в сервисе сохранить расписание в БД

    private final FillSheduleService sheduleService;

    @GetMapping("update")
    public ResponseEntity<String> updateSchedule(){

        String response = sheduleService.importDb(sheduleService.convertPdfToXlsx(sheduleService.downloadFilePdf()));

        return ResponseEntity.ok(response + "   " + new Date(System.currentTimeMillis()).toString());

    }

}
