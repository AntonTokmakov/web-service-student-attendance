package com.example.webservice_student_attendance.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
public class StudyGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "study_group_id")
    private Long id;

    @NotNull
    @Size(min = 2, max = 30)
    @Column(unique = true)
    private String name;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(unique = true)
    private String shortName;

    @Max(50)
    private Integer groupSize;

    @ManyToOne
    @JoinColumn(name = "kafedra_id")
    private Kafedra kafedra;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "specialization_id")
    private Specialization specialization;

    @NotNull
    private Date yearAdmission;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "assigning_group_lesson",
            joinColumns = @JoinColumn(name = "study_group_id"),
            inverseJoinColumns = @JoinColumn(name = "lesson_id")
    )
    private List<Lesson> lessonList;

}
