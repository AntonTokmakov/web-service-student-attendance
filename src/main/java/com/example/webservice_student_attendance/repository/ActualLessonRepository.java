package com.example.webservice_student_attendance.repository;

import com.example.webservice_student_attendance.entity.ActualLesson;
import com.example.webservice_student_attendance.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ActualLessonRepository extends JpaRepository<ActualLesson, Long> {

    Optional<ActualLesson> findByLessonAndDate(Lesson lessonList, LocalDate date);

}
