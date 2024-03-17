package com.example.webservice_student_attendance.repository;

import com.example.webservice_student_attendance.entity.Lesson;
import com.example.webservice_student_attendance.entity.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecializationRepository extends JpaRepository<Specialization, Long> {
}
