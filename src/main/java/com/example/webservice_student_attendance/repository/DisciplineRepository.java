package com.example.webservice_student_attendance.repository;

import com.example.webservice_student_attendance.entity.Discipline;
import com.example.webservice_student_attendance.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.filter.OncePerRequestFilter;

import java.util.Optional;

@Repository
public interface DisciplineRepository extends JpaRepository<Discipline, Long> {

    Optional<Discipline> findByNameLikeIgnoreCase(String name);
    Optional<Discipline> findByShortNameLikeIgnoreCase(String name);

}
