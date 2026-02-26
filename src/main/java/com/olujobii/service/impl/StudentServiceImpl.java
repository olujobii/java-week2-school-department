package com.olujobii.service.impl;

import com.olujobii.model.Applicant;
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

    @Override
    public Student createStudent(Applicant applicant){
        return new Student(applicant.getName(),applicant.getAge(),applicant.getGender(),applicant.getId()
        ,applicant.getInterestedCourse());
    }

    @Override
    public void saveStudentToList(Student student) {
        departmentRepository.saveStudent(student);
    }

    @Override
    public void removeStudentFromList(Student student) {
        departmentRepository.removeStudent(student);
    }
}
