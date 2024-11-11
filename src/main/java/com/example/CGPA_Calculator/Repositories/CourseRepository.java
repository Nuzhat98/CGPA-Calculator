package com.example.CGPA_Calculator.Repositories;

import com.example.CGPA_Calculator.Entities.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity,String> {
}
