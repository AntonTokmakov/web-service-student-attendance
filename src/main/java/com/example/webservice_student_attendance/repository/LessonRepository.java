package com.example.webservice_student_attendance.repository;

import com.example.webservice_student_attendance.entity.Lesson;
import com.example.webservice_student_attendance.entity.ParityOfWeek;
import com.example.webservice_student_attendance.entity.StudyGroup;
import com.example.webservice_student_attendance.entity.Weekday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {

//    Optional<List<Lesson>> findLessonsByStudyGroupListAndWeekdayOrderByNumberLesson(StudyGroup studyGroup, Weekday weekday);
    Optional<List<Lesson>> findLessonsByStudyGroupListAndWeekdayAndParityOfWeekOrderByNumberLesson(StudyGroup studyGroup, Weekday weekday, ParityOfWeek parityOfWeek);

    Optional<List<Lesson>> findByStudyGroupListOrderByWeekday(StudyGroup studyGroup);

}
