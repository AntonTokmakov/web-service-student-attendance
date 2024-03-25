package com.example.webservice_student_attendance.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity

public class ParityOfWeek {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parity_week_id")
    private Long id;

    @NotNull
    @Column(unique = true)
    private String name;
}