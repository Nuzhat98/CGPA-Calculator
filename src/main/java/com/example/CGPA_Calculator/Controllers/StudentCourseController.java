package com.example.CGPA_Calculator.Controllers;

import com.example.CGPA_Calculator.Dtos.SampleGradeRequestModel;
import com.example.CGPA_Calculator.Dtos.StudentCourseRequestModel;
import com.example.CGPA_Calculator.Entities.StudentCourseEntity;
import com.example.CGPA_Calculator.Services.StudentCourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student-course")
public class StudentCourseController {

    private final StudentCourseService studentCourseService;

    public StudentCourseController(StudentCourseService studentCourseService) {
        this.studentCourseService = studentCourseService;
    }

    @GetMapping("/hi")
    public String hello(){
        return "hi";
    }

    @PostMapping("/{studentId}/add-grade/{courseId}")
    public StudentCourseRequestModel addGradeToStudent(@PathVariable("studentId") Long studentId, @PathVariable("courseId") String courseId, @RequestParam("courseGrade") Double courseGrade,@RequestParam("earnedCredit") Integer earnedCredit){
    return studentCourseService.addGradeToStudent(studentId,courseId,courseGrade,earnedCredit);
    }

    @GetMapping("/test-grade/{studentId}")
    public Double testGrade(@PathVariable("studentId")Long studentId, @RequestBody List<SampleGradeRequestModel> sampleGradeRequestModels){
       return studentCourseService.testGrade(studentId,sampleGradeRequestModels);
    }
}