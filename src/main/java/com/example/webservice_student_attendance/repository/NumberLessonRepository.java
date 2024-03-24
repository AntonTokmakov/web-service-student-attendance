package com.example.webservice_student_attendance.repository;

import com.example.webservice_student_attendance.entity.Lesson;
import com.example.webservice_student_attendance.entity.NumberLesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NumberLessonRepository extends JpaRepository<NumberLesson, Long> {
    Optional<NumberLesson> findByNameIgnoreCase(String name);

}
