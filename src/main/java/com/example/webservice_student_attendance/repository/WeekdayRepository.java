package com.example.webservice_student_attendance.repository;

import com.example.webservice_student_attendance.entity.Lesson;
import com.example.webservice_student_attendance.entity.Weekday;
import com.example.webservice_student_attendance.enumPackage.WeekdayEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WeekdayRepository extends JpaRepository<Weekday, Long> {

    Optional<Weekday> findByNameIgnoreCase(String weekdayEnum);

}
