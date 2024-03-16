package com.example.webservice_student_attendance.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table
@Data
@NoArgsConstructor
public class CuratorGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @ManyToOne
//    @JoinColumn(name = "id")
//    private Teacher teacher;
//    @ManyToOne
//    @JoinColumn(name = "id")
//    private StudyGroup studyGroup;
//    @NotNull
//    private Date date;

}
