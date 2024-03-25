package com.example.webservice_student_attendance.repository;

import com.example.webservice_student_attendance.entity.ActualLesson;
import com.example.webservice_student_attendance.entity.ParityOfWeek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParityOfWeekRepository extends JpaRepository<ParityOfWeek, Long> {

    Optional<ParityOfWeek> findByNameIgnoreCase(String name);

}
