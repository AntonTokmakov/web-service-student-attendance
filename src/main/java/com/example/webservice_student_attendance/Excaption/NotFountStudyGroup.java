package com.example.webservice_student_attendance.Excaption;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class NotFountStudyGroup extends Exception {
    String name = "Группа не надена.\nПопробуйте ввести другую группу";
}
