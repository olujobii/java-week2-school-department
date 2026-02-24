package com.olujobii.service.impl;

import com.olujobii.model.Student;
import com.olujobii.repository.DepartmentRepository;
import com.olujobii.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private final DepartmentRepository departmentRepository;

    public StudentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<Student> listAllStudents(){
        return departmentRepository.getTotalStudents();
    }
}
