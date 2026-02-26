package com.olujobii.service;

import com.olujobii.enums.Courses;
import com.olujobii.enums.Gender;
import com.olujobii.model.Applicant;

import java.util.List;

public interface ApplicantService {

    void createApplicant(String name, int age, Gender gender, String id, Courses interestedCourse);

    List<Applicant> getAllApplicants();
}
