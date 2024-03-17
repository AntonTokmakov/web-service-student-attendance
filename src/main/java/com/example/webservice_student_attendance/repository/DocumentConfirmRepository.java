package com.example.webservice_student_attendance.repository;

import com.example.webservice_student_attendance.entity.DocumentConfirm;
import com.example.webservice_student_attendance.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentConfirmRepository extends JpaRepository<DocumentConfirm, Long> {
}
