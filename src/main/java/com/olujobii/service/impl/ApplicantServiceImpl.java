package com.olujobii.service.impl;

import com.olujobii.enums.Courses;
import com.olujobii.enums.Gender;
import com.olujobii.model.Applicant;
import com.olujobii.repository.DepartmentRepository;
import com.olujobii.service.ApplicantService;

import java.util.List;

public class ApplicantServiceImpl implements ApplicantService {
    private final DepartmentRepository departmentRepository;

    public ApplicantServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public void createApplicant(String name, int age, Gender gender, String id, Courses interestedCourse){

        Applicant applicant = new Applicant(name,age,gender,id,interestedCourse);
        departmentRepository.saveApplicant(applicant);
    }

    @Override
    public List<Applicant> getAllApplicants() {
        return departmentRepository.getTotalApplicants();
    }
}
