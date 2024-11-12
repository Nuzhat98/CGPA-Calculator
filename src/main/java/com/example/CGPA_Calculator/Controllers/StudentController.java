package com.example.CGPA_Calculator.Controllers;

import com.example.CGPA_Calculator.Dtos.StudentRequestModel;
import com.example.CGPA_Calculator.Entities.StudentEntity;
import com.example.CGPA_Calculator.Services.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Student-section")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/greet-student")
    public String greetStudent(){
        return "Welcome to Student section!";
    }

    @PostMapping("/add-student")
    public StudentEntity addStudent(@RequestBody StudentRequestModel studentRequestModel){
         return studentService.addStudent(studentRequestModel);
    }

    @DeleteMapping("/delete-student/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }
}
