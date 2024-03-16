package com.example.webservice_student_attendance.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
public class Institute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "institute_id")
    private Long id;
    @NotNull
    @Size(min = 2, max = 30)
    private String firstname;
    @NotNull
    @Size(min = 4, max = 50)
    private String lastname;
    @Size(min = 4, max = 50)
    private String otchestvo;
    private String office;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "institute")
    private List<Kafedra> kafedraList;
}
