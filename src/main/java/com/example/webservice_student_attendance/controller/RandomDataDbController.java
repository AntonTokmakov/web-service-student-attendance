package com.example.webservice_student_attendance.controller;

import com.example.webservice_student_attendance.service.DataGeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("data")
@RequiredArgsConstructor
public class RandomDataDbController {

    private final DataGeneratorService dataGeneratorService;

    @GetMapping("random")
    public void random(){
        dataGeneratorService.allAddEntityDb();
    }

}
