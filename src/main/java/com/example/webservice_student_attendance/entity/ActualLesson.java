package com.example.webservice_student_attendance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActualLesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actual_lesson_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;
    private LocalDate date;



}
