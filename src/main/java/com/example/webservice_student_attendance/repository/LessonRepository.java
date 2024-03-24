package com.example.webservice_student_attendance.repository;

import com.example.webservice_student_attendance.entity.Lesson;
import com.example.webservice_student_attendance.entity.StudyGroup;
import com.example.webservice_student_attendance.entity.Weekday;
import com.example.webservice_student_attendance.enumPackage.WeekdayEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {

    Optional<List<Lesson>> findLessonsByStudyGroupListAndWeekdayOrderByNumberLesson(StudyGroup studyGroup, Weekday weekday);


//    Optional<List<Lesson>> findLessonsByStudyGroupListAndWeekdaysList

//    List<Lesson> findLessonsByStudyGroupList(StudyGroup studyGroup/*, WeekdayEnum weekday*/);
//    List<Lesson> findLessonsByStudyGroupListEqualsAndWeekdayOrderByNumberLesson(StudyGroup studyGroup, WeekdayEnum weekday);
}
