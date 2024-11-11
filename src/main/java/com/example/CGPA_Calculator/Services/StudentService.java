package com.example.CGPA_Calculator.Services;

import com.example.CGPA_Calculator.Dtos.StudentRequestModel;
import com.example.CGPA_Calculator.Entities.StudentEntity;

public interface StudentService {
    StudentEntity addStudent(StudentRequestModel studentRequestModel);
}
