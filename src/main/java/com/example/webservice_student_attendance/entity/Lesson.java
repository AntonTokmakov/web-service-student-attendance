package com.example.webservice_student_attendance.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lesson_id")
    private Long id;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "discipline_id")
    private Discipline discipline;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "kafedra_id")
    private Kafedra kafedra;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "number_lesson_id")
    private NumberLesson numberLesson;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "weekday_id")
    private Weekday weekday;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "type_lesson_id")
    private TypeLesson typeLesson;
    @ManyToMany
    @JoinTable(
            name = "assigning_group_lesson",
            joinColumns = @JoinColumn(name = "lesson_id"),
            inverseJoinColumns = @JoinColumn(name = "id")
    )
    private List<StudyGroup> studyGroupList;

    @ManyToMany
    @JoinTable(
            name = "appointment_teacher_lesson",
            joinColumns = @JoinColumn(name = "lesson_id"),
            inverseJoinColumns = @JoinColumn(name = "id")
    )
    private List<Teacher> teacherList;

}
