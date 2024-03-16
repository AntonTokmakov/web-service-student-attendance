package com.example.webservice_student_attendance.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Entity
@Table
@Data
@NoArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 2, max = 40)
    private String firstName;
    @NotNull
    @Size(min = 2, max = 50)
    private String secondName;
    @Size(min = 2, max = 50)
    private String otchestvo;
    @ManyToOne
    @JoinColumn(name = "kafedra_id")
    private Kafedra kafedra;
//    @ManyToMany
//    @JoinTable(
//            name = "appointment_teacher_lesson",
//            joinColumns = @JoinColumn(name = "id"),
//            inverseJoinColumns = @JoinColumn(name = "id")
//    )
//    private List<Lesson> teacher;

//    @OneToMany
//    @JoinColumn(name = "id")
//    private List<CuratorGroup> studentGroupList;

}
