package com.example.webservice_student_attendance.service;

import com.example.webservice_student_attendance.Excaption.NotFountStudyGroup;
import com.example.webservice_student_attendance.dto.SetPassActualLessonGroupStudy;
import com.example.webservice_student_attendance.entity.ActualLesson;
import com.example.webservice_student_attendance.entity.Student;
import com.example.webservice_student_attendance.entity.StudyGroup;
import com.example.webservice_student_attendance.repository.ActualLessonRepository;
import com.example.webservice_student_attendance.repository.StudentRepository;
import com.example.webservice_student_attendance.repository.StudyGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MonitorService {

    private final StudentRepository studentRepository;
    private final ActualLessonRepository actualLessonRepository;
    private final StudyGroupRepository studyGroupRepository;

    public SetPassActualLessonGroupStudy getStudentByStudyGroupToPass(long groupId, long lessonId) throws NotFountStudyGroup {

        StudyGroup studyGroup = studyGroupRepository.findById(groupId).orElseThrow(NotFountStudyGroup::new);
        ActualLesson actualLesson = actualLessonRepository.findById(lessonId).orElse(null);
        List<Student> studentList = studentRepository.findByStudyGroup(studyGroup);
        return SetPassActualLessonGroupStudy.builder()
                .actualLesson(actualLesson)
                .studentList(studentList)
                .build();

    }

    public ActualLesson getActualLessonById(Long lessonId) {
        return actualLessonRepository.findById(lessonId).orElse(null);
    }
}
