package com.olujobii.repository;

import com.olujobii.*;

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

    public void addStudent(Student student){
        enrolledStudents.add(student);
    }

    public void removeStudent(int index){
        enrolledStudents.remove(index);
    }

    public List<Staff> getAvailableStaffs() {
        return availableStaffs;
    }

    public List<Applicant> getApplicantList() {
        return applicantList;
    }

    public void removeApplicant(int num){
        applicantList.remove(num);
    }

    public void addApplicant(Applicant applicant){applicantList.add(applicant);}

    public List<Course> getAvailableCourses() {
        return availableCourses;
    }

    public AdminPriviledges getAdminPriviledgesType(){
        for(Staff staff : availableStaffs){
            if(staff instanceof AdminPriviledges admin)
                return admin;
        }
        return null;
    }
}
