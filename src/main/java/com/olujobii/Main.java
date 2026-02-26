package com.olujobii;

import com.olujobii.presentation.SchoolMgtSystem;
import com.olujobii.repository.DepartmentRepository;
import com.olujobii.service.*;
import com.olujobii.service.impl.*;


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
        PrincipalService principalService = new PrincipalServiceImpl(departmentRepository);
        ApplicantService applicantService = new ApplicantServiceImpl(departmentRepository);

        //Presentation
        SchoolMgtSystem schoolMgtSystem = new SchoolMgtSystem(studentService
                ,staffService,courseService,principalService,applicantService);

        schoolMgtSystem.runApplication();

    }
}
