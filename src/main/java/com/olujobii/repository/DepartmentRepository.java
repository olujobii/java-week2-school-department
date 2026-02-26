package com.olujobii.repository;

import com.olujobii.enums.Courses;
import com.olujobii.enums.Gender;
import com.olujobii.enums.WorkType;
import com.olujobii.model.*;
import com.olujobii.model.baseClass.Staff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DepartmentRepository {
    private final List<Courses> totalCourses;
    private final List<Student> totalStudents;
    private final List<Staff> totalStaffs;
    private final List<Applicant> totalApplicants;

    public DepartmentRepository() {

        this.totalCourses = new ArrayList<>();
        this.totalStudents = new ArrayList<>();
        this.totalStaffs = new ArrayList<>();
        this.totalApplicants = new ArrayList<>();
    }

    //CREATE MOCK DATA FOR IN-MEMORY DATABASE
    public void createMockData(){
        //PRINCIPAL
        Staff principal = new Principal("Segun Osiki",33, Gender.MALE,"PR-394");

        //TEACHERS
        Staff teacher1 = new Teacher("John Olajide",27,Gender.MALE,"TCH-493",Courses.GOLANG);
        Staff teacher2 = new Teacher("Samuel Joseph",25,Gender.MALE,"TCH-532",Courses.JAVA);
        Staff teacher3 = new Teacher("Oluwasetemi Precious",28,Gender.FEMALE,"TCH-053",Courses.JAVASCRIPT);
        Staff teacher4 = new Teacher("Gloria",25,Gender.FEMALE,"TCH-981",Courses.PYTHON);

        //NON-ACADEMIC STAFF
        Staff nonAcademicStaff1 = new NonAcademicStaff("David",27,Gender.MALE,"NST-238", WorkType.SECURITY);
        Staff nonAcademicStaff2 = new NonAcademicStaff("Chisom",29,Gender.FEMALE,"NST-008", WorkType.CLEANER);
        Staff nonAcademicStaff3 = new NonAcademicStaff("Daniel",27,Gender.MALE,"NST-764", WorkType.CHEF);

        //STUDENTS
        Student student1 = new Student("Ife Olujobi",23,Gender.MALE,"ST-482",Courses.JAVA);
        Student student2 = new Student("Frank Joseph",39,Gender.MALE,"ST-810",Courses.PYTHON);
        Student student3 = new Student("Chisom Nwachukwu",23,Gender.FEMALE,"ST-002",Courses.GOLANG);
        Student student4 = new Student("Mark Omeje",30,Gender.MALE,"ST-003",Courses.JAVASCRIPT);


        //Add to List
        Collections.addAll(totalStaffs,principal,teacher1,teacher2,teacher3,teacher4,nonAcademicStaff1
        ,nonAcademicStaff2,nonAcademicStaff3);

        Collections.addAll(totalStudents,student1,student2,student3,student4);

        Collections.addAll(totalCourses,Courses.JAVA,Courses.GOLANG,Courses.PYTHON,Courses.JAVASCRIPT);
    }

    public List<Courses> getTotalCourses() {
        return totalCourses;
    }

    public List<Student> getTotalStudents() {
        return totalStudents;
    }

    public List<Staff> getTotalStaffs() {
        return totalStaffs;
    }

    public List<Applicant> getTotalApplicants() {
        return totalApplicants;
    }

    public void saveApplicant(Applicant applicant){
        totalApplicants.add(applicant);
    }
}
