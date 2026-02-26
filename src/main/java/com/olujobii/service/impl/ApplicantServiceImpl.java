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
    public Applicant createApplicant(String name, int age, Gender gender, String id, Courses interestedCourse){
        return new Applicant(name,age,gender,id,interestedCourse);
    }

    @Override
    public List<Applicant> getAllApplicants() {
        return departmentRepository.getTotalApplicants();
    }

    @Override
    public void saveApplicantToList(Applicant applicant){
        departmentRepository.saveApplicant(applicant);
    }

    @Override
    public void deleteApplicantFromList(Applicant applicant){
        departmentRepository.deleteApplicant(applicant);
    }
}
