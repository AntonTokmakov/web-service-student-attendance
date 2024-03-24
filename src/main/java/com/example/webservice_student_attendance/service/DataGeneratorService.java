package com.example.webservice_student_attendance.service;

import com.example.webservice_student_attendance.entity.*;
import com.example.webservice_student_attendance.repository.*;
import com.github.javafaker.Faker;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.util.*;

@Service
@RequiredArgsConstructor
public class DataGeneratorService {

    private final TeacherRepository teacherRepository;
    private final ActualLessonRepository actualLessonRepository;
    private final ContactInfoRepository contactInfoRepository;
    private final CuratorGroupRepository curatorGroupRepository;
    private final DisciplineRepository disciplineRepository;
    private final DocumentConfirmRepository documentConfirmRepository;
    private final GeneralContactInfoRepository generalContactInfoRepository;
    private final InstituteRepository instituteRepository;
    private final KafedraRepository kafedraRepository;
    private final LessonRepository lessonRepository;
    private final NumberLessonRepository numberLessonRepository;
    private final PassRepository passRepository;
    private final SpecializationRepository specializationRepository;
    private final StatusPassRepository statusPassRepository;
    private final StudentContactRepository studentContactRepository;
    private final StudentRepository studentRepository;
    private final StudyGroupRepository studyGroupRepository;
    private final TypeContactInfoRepository typeContactInfoRepository;
    private final TypeLessonRepository typeLessonRepository;
    private final WeekdayRepository weekdayRepository;
    Faker faker = new Faker();
    Random random = new Random();
    int j = 1;
    public void allAddEntityDb(){

        for (int i = 1; i < 50; i++) {
            addInstitute();
            addKafedra(instituteRepository.findAll().get(random.nextInt(0, i)));
            addTeacher(kafedraRepository.findAll().get(random.nextInt(0, i)));
            addDiscipline(kafedraRepository.findAll().get(random.nextInt(0, i)));
            addStudyGroup(kafedraRepository.findAll().get(random.nextInt(0, i)));
            addStudent(studyGroupRepository.findAll().get(random.nextInt(0, i)));
            addCuratorGroup();
            addLesson();
        }

    }

    public void addInstitute(){
        Institute institute = new Institute();
        institute.setName(faker.educator().university());
        institute.setShortName("ПИТИП");
        institute.setOffice(j++ + "ГТ");
        instituteRepository.save(institute);

    }

    public void addKafedra(Institute institute){
        Kafedra kafedra = new Kafedra();
        kafedra.setName(faker.educator().university());
        kafedra.setShortName("ПИТИП");
        kafedra.setOffice(j++ + "ГТ");
        kafedra.setInstitute(institute);
        kafedraRepository.save(kafedra);
    }

    public void addTeacher(Kafedra kafedra){
        Teacher teacher = new Teacher();
        teacher.setFirstName(faker.name().firstName());
        teacher.setSecondName(faker.name().lastName());
        teacher.setOtchestvo(faker.name().lastName());
        teacher.setKafedra(kafedra);
        teacherRepository.save(teacher);
    }

    public void addDiscipline(Kafedra kafedra){
        Discipline discipline = new Discipline();
        discipline.setName(faker.educator().course());
        discipline.setShortName(faker.educator().course().substring(0, 5));
        discipline.setKafedra(kafedra);
        disciplineRepository.save(discipline);
    }

    public void addStudyGroup(Kafedra kafedra){
        StudyGroup studyGroup = new StudyGroup();
        studyGroup.setName("Информационные системы " + j++);
        studyGroup.setShortName("ИС - " + j++);
        studyGroup.setKafedra(kafedra);
        studyGroup.setGroupSize(30);
        //studyGroup.setYearAdmission(faker.date().birthday());
        Specialization specialization = new Specialization();
        specialization.setName("Программист");
        specialization.setShortName("Прг");
        specializationRepository.save(specialization);
        studyGroup.setSpecialization(specialization);
        studyGroupRepository.save(studyGroup);
    }

    public void addStudent(StudyGroup studyGroup){
        Student student = new Student();
        student.setFirstName(faker.name().firstName());
        student.setLastName(faker.name().lastName());
        student.setOtchestvo(faker.name().lastName());
        student.setBirthday(faker.date().birthday(18, 25));
        student.setMonitor(random.nextBoolean());
        student.setStudyGroup(studyGroup);
        studentRepository.save(student);
    }

    public void addCuratorGroup(){
        List<StudyGroup> studyGroupList = studyGroupRepository.findAll();
        List<Teacher> teacherList = teacherRepository.findAll();

        CuratorGroup curatorGroup = new CuratorGroup();
        Teacher teacher = teacherList.get(random.nextInt(teacherList.size()));
        curatorGroup.setTeacher(teacher);
        StudyGroup studyGroup = studyGroupList.get(random.nextInt(studyGroupList.size()));
        curatorGroup.setStudyGroup(studyGroup);
        curatorGroup.setDate(faker.date().birthday());
        curatorGroupRepository.save(curatorGroup);
    }

    public void addLesson(){
        List<Discipline> disciplineList = disciplineRepository.findAll();
        List<Kafedra> kafedraList = kafedraRepository.findAll();
        List<StudyGroup> studyGroupList = studyGroupRepository.findAll();
        List<Teacher> teacherList = teacherRepository.findAll();

        List<NumberLesson> numberLessonList = numberLessonRepository.findAll();
        List<TypeLesson> typeLessonList = typeLessonRepository.findAll();
        List<Weekday> weekdayList = weekdayRepository.findAll();

        Lesson lesson = new Lesson();
        lesson.setDiscipline(disciplineList.get(random.nextInt(disciplineList.size())));
        lesson.setKafedra(kafedraList.get(random.nextInt(kafedraList.size())));
        lesson.setNumberLesson(numberLessonList.get(random.nextInt(numberLessonList.size())));
        lesson.setWeekday(weekdayList.get(random.nextInt(weekdayList.size())));
        lesson.setTypeLesson(typeLessonList.get(random.nextInt(typeLessonList.size())));

        List<StudyGroup> randomStudyGroupList = new ArrayList<>();
        for (int j = 0; j < random.nextInt(3); j++) {
            randomStudyGroupList.add(studyGroupList.get(random.nextInt(studyGroupList.size())));
        }
        lesson.setStudyGroupList(randomStudyGroupList);

        List<Teacher> randomTeacherList = new ArrayList<>();
        for (int j = 0; j < random.nextInt(3); j++) {
            randomTeacherList.add(teacherList.get(random.nextInt(teacherList.size())));
        }
        lesson.setTeacherList(randomTeacherList);
        lessonRepository.save(lesson);
    }




}
