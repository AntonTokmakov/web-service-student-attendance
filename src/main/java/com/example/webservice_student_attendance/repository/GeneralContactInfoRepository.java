package com.example.webservice_student_attendance.repository;

import com.example.webservice_student_attendance.entity.GeneralContactInfo;
import com.example.webservice_student_attendance.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneralContactInfoRepository extends JpaRepository<GeneralContactInfo, Long> {
}
