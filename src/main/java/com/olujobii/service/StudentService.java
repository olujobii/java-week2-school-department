package com.olujobii.service;

import com.olujobii.model.Applicant;
import com.olujobii.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> listAllStudents();

    Student createStudent(Applicant applicant);

    void saveStudentToList(Student student);
}
