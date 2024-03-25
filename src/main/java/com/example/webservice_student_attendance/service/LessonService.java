package com.example.webservice_student_attendance.service;

import com.example.webservice_student_attendance.Excaption.NotFountStudyGroup;
import com.example.webservice_student_attendance.entity.Lesson;
import com.example.webservice_student_attendance.entity.ParityOfWeek;
import com.example.webservice_student_attendance.entity.StudyGroup;
import com.example.webservice_student_attendance.entity.Weekday;
import com.example.webservice_student_attendance.enumPackage.ParityWeekEnum;
import com.example.webservice_student_attendance.enumPackage.WeekdayEnum;
import com.example.webservice_student_attendance.repository.LessonRepository;
import com.example.webservice_student_attendance.repository.ParityOfWeekRepository;
import com.example.webservice_student_attendance.repository.StudyGroupRepository;
import com.example.webservice_student_attendance.repository.WeekdayRepository;
import jakarta.persistence.EntityNotFoundException;
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
    private final ParityOfWeekRepository parityOfWeekRepository;

    public Optional<List<Lesson>> findLessonsGroupAndWeekday(Integer group,
                                                             WeekdayEnum weekdayEnum,
                                                             ParityWeekEnum parityWeekEnum)
            throws NotFountStudyGroup, InvalidParameterException {

        StudyGroup studyGroup = studyGroupRepository.findById((long) group)
                .orElseThrow(NotFountStudyGroup::new);
        Weekday weekday = weekdayRepository.findByNameIgnoreCase(weekdayEnum.name())
                .orElseThrow(() -> new InvalidParameterException("День недели не найден"));
        ParityOfWeek parityOfWeek = parityOfWeekRepository.findByNameIgnoreCase(parityWeekEnum.name())
                .orElseThrow(() -> new EntityNotFoundException("Четность недели не найдена"));

        return lessonRepository
                .findLessonsByStudyGroupListAndWeekdayAndParityOfWeekOrderByNumberLesson(studyGroup, weekday, parityOfWeek);
    }

    public Optional<Lesson> findById(int id){
        return lessonRepository.findById((long) id);
    }
}
