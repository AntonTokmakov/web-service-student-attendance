package com.example.webservice_student_attendance.service;

import com.example.webservice_student_attendance.Excaption.NotFountStudyGroup;
import com.example.webservice_student_attendance.entity.Lesson;
import com.example.webservice_student_attendance.entity.StudyGroup;
import com.example.webservice_student_attendance.entity.Weekday;
import com.example.webservice_student_attendance.enumPackage.WeekdayEnum;
import com.example.webservice_student_attendance.repository.LessonRepository;
import com.example.webservice_student_attendance.repository.StudyGroupRepository;
import com.example.webservice_student_attendance.repository.WeekdayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LessonService {

    private final LessonRepository lessonRepository;
    private final StudyGroupRepository studyGroupRepository;
    private final WeekdayRepository weekdayRepository;

    public Optional<List<Lesson>> findLessonsGroupAndWeekday(Integer group, WeekdayEnum weekdayEnum) throws NotFountStudyGroup, InvalidParameterException {

        StudyGroup studyGroup = studyGroupRepository.findById((long) group).orElseThrow(() -> new NotFountStudyGroup());
        Weekday weekday = weekdayRepository.findByNameIgnoreCase(weekdayEnum.name()).orElseThrow(() -> new InvalidParameterException("День недели не найден"));

        return lessonRepository.findLessonsByStudyGroupListAndWeekdayOrderByNumberLesson(studyGroup, weekday);

    }

    public Optional<Lesson> findById(int id){
        return lessonRepository.findById((long) id);
    }
}
