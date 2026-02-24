package com.olujobii;

import com.olujobii.presentation.SchoolMgtSystem;
import com.olujobii.repository.DepartmentRepository;
import com.olujobii.service.CourseService;
import com.olujobii.service.StaffService;
import com.olujobii.service.StudentService;
import com.olujobii.service.impl.CourseServiceImpl;
import com.olujobii.service.impl.StaffServiceImpl;
import com.olujobii.service.impl.StudentServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Repository
        DepartmentRepository departmentRepository = new DepartmentRepository();

        //Create mock data for in-memory database
        departmentRepository.createMockData();

        //Service
        StudentService studentService = new StudentServiceImpl(departmentRepository);
        StaffService staffService = new StaffServiceImpl(departmentRepository);
        CourseService courseService = new CourseServiceImpl(departmentRepository);

        //Presentation
        SchoolMgtSystem schoolMgtSystem = new SchoolMgtSystem(new Scanner(System.in),studentService
                ,staffService,courseService);

        schoolMgtSystem.runApplication();

    }
}
