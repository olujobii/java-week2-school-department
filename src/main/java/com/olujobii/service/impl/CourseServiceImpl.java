package com.olujobii.service.impl;

import com.olujobii.enums.Courses;
import com.olujobii.repository.DepartmentRepository;
import com.olujobii.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private final DepartmentRepository departmentRepository;

    public CourseServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<Courses> listAllCourses(){
        return departmentRepository.getTotalCourses();
    }
}
