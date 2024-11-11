package com.example.CGPA_Calculator.Controllers;

import com.example.CGPA_Calculator.Dtos.CourseRequestModel;
import com.example.CGPA_Calculator.Entities.CourseEntity;
import com.example.CGPA_Calculator.Services.CourseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/course-section")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/add-multiple-courses")
    public List<CourseEntity> addMultipleCourses(@RequestBody List<CourseRequestModel> courseRequestModels){
        return courseService.addMultipleCourses(courseRequestModels);
    }
}
