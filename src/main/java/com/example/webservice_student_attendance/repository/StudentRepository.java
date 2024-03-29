package com.example.webservice_student_attendance.repository;

import com.example.webservice_student_attendance.entity.Student;
import com.example.webservice_student_attendance.entity.StudyGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


    List<Student> findByStudyGroup(StudyGroup groupId);
}
