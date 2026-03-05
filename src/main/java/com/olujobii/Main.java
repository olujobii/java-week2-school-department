package com.olujobii;

import com.olujobii.config.ConfigClass;
import com.olujobii.presentation.SchoolMgtSystem;
import com.olujobii.repository.DepartmentRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigClass.class);

        DepartmentRepository departmentRepository = context.getBean(DepartmentRepository.class);
        SchoolMgtSystem schoolMgtSystem = context.getBean("SchoolManagementSystem"
                ,SchoolMgtSystem.class);

        departmentRepository.createMockData();
        schoolMgtSystem.runApplication();
    }
}
