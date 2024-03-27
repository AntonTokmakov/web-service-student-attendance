package com.example.webservice_student_attendance.repository;

import com.example.webservice_student_attendance.entity.ActualLesson;
import com.example.webservice_student_attendance.entity.Lesson;
import com.example.webservice_student_attendance.entity.StudyGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ActualLessonRepository extends JpaRepository<ActualLesson, Long> {

    Optional<ActualLesson> findByLessonAndDate(Lesson lessonList, LocalDate date);

    @Query("SELECT al FROM ActualLesson al " +
            "JOIN al.lesson l " +
            "JOIN l.studyGroupList sg " +
            "WHERE al.date =  :date  AND sg.id = :studyGroup")
    List<ActualLesson> findActualLessonsByDateAndStudyGroup(@Param("date") LocalDate date, @Param("studyGroup") int studyGroup);

//    List<ActualLesson> findByDateAndStudyGroup(LocalDate date, StudyGroup studyGroup);


}
