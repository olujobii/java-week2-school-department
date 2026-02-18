package com.olujobii.repository;

import com.olujobii.Applicant;
import com.olujobii.Course;
import com.olujobii.Staff;
import com.olujobii.Student;

import java.util.List;

public class DepartmentDatabase {
    private final List<Student> enrolledStudents;
    private final List<Staff> availableStaffs;
    private final List<Applicant> applicantList;
    private final List<Course> availableCourses;

    public DepartmentDatabase(List<Student> enrolledStudents, List<Staff> availableStaffs
                              ,List<Applicant> applicantList
                             ,List<Course> availableCourses){
        this.enrolledStudents = enrolledStudents;
        this.availableStaffs = availableStaffs;
        this.applicantList = applicantList;
        this.availableCourses = availableCourses;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public List<Staff> getAvailableStaffs() {
        return availableStaffs;
    }

    public List<Applicant> getApplicantList() {
        return applicantList;
    }

    public List<Course> getAvailableCourses() {
        return availableCourses;
    }
}
