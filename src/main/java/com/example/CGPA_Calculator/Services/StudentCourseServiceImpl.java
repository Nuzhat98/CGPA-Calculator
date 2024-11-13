package com.example.CGPA_Calculator.Services;

import com.example.CGPA_Calculator.Dtos.SampleGradeRequestModel;
import com.example.CGPA_Calculator.Dtos.StudentCourseRequestModel;
import com.example.CGPA_Calculator.Entities.CourseEntity;
import com.example.CGPA_Calculator.Entities.StudentCourseEntity;
import com.example.CGPA_Calculator.Entities.StudentEntity;
import com.example.CGPA_Calculator.Repositories.CourseRepository;
import com.example.CGPA_Calculator.Repositories.StudentCourseRepository;
import com.example.CGPA_Calculator.Repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentCourseServiceImpl implements StudentCourseService{

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final StudentCourseRepository studentCourseRepository;

    public StudentCourseServiceImpl(StudentRepository studentRepository, CourseRepository courseRepositoryRepository, CourseRepository courseRepository, StudentCourseRepository studentCourseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.studentCourseRepository = studentCourseRepository;
    }

    @Override
    public StudentCourseRequestModel addGradeToStudent(Long studentId, String courseId, Double courseGrade, Integer earnedCredit) {
        StudentEntity newStudentEntity=studentRepository.findById(studentId).orElseThrow(()->new RuntimeException("Student Id not Found!"));
        newStudentEntity.setAttemptedCredit(newStudentEntity.getAttemptedCredit()+earnedCredit);

        CourseEntity newCourseEntity=courseRepository.findById(courseId).orElseThrow(()->new RuntimeException("Course Id not found!"));
        StudentCourseEntity newStudentCourseEntity = StudentCourseEntity.builder().studentEntity(newStudentEntity).courseEntity(newCourseEntity).courseGrade(courseGrade).build();

        StudentCourseEntity studentCourseEntity = studentCourseRepository.save(newStudentCourseEntity);
        calculateGrade(studentId);
        studentRepository.save(newStudentEntity);
        return convertEntityToModel(studentCourseEntity);
    }

    @Override
    public Double testGrade(Long studentId, List<SampleGradeRequestModel> sampleGradeRequestModels){
        StudentEntity newStudentEntity= studentRepository.findById(studentId).orElseThrow(()->new RuntimeException("Student Id not found!"));
        Double gradeSum = newStudentEntity.getStudentCourseEntities().stream().mapToDouble(eachCourse-> eachCourse.getCourseGrade()*eachCourse.getCourseEntity().getCourseCredit()).sum() + sampleGradeRequestModels.stream().mapToDouble(eachSample->eachSample.getExpCredit()*eachSample.getExpGrade()).sum();
        return gradeSum/(newStudentEntity.getAttemptedCredit()+ sampleGradeRequestModels.stream().mapToInt(eachSample->{
            CourseEntity newCourseEntity=courseRepository.findById(eachSample.getCourseId()).orElseThrow(()->new RuntimeException("Course Id not Found!"));
            return newCourseEntity.getCourseCredit();
        }).sum());
    }

    public StudentCourseRequestModel convertEntityToModel(StudentCourseEntity studentCourseEntity){
        return StudentCourseRequestModel.builder().studentId(studentCourseEntity.getStudentEntity().getStudentId()).courseId(studentCourseEntity.getCourseEntity().getCourseId()).courseGrade(studentCourseEntity.getCourseGrade()).build();

    }

    public void calculateGrade(Long studentId){
        StudentEntity newStudentEntity= studentRepository.findById(studentId).orElseThrow(()->new RuntimeException("Student Id not found!"));
        Double gradeSum = newStudentEntity.getStudentCourseEntities().stream().mapToDouble(eachCourse-> eachCourse.getCourseGrade()*eachCourse.getCourseEntity().getCourseCredit()).sum();
        Double result= gradeSum/newStudentEntity.getAttemptedCredit();
        newStudentEntity.setStudentResult(result);
        studentRepository.save(newStudentEntity);
    }
}
