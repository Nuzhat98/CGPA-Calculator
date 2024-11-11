package com.example.CGPA_Calculator.Services;

import com.example.CGPA_Calculator.Dtos.StudentRequestModel;
import com.example.CGPA_Calculator.Entities.StudentEntity;
import com.example.CGPA_Calculator.Repositories.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void convertStudentEntityToRequestModel(StudentEntity studentEntity){

    }

    @Override
    public StudentEntity addStudent(StudentRequestModel studentRequestModel) {
        StudentEntity newStudentEntity = StudentEntity.builder().studentName(studentRequestModel.getStudentName()).studentDept(studentRequestModel.getStudentDept()).studentResult(studentRequestModel.getStudentResult()).build();
        return studentRepository.save(newStudentEntity);
    }
}
