package com.olujobii;

import com.olujobii.repository.DepartmentDatabase;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        Department department = createMockData();
        department.runApplication();
    }

    private static Department createMockData(){
        //-----CREATING MOCK DATA-----
        //Courses
        Course english = new Course("English", "ENG-201");
        Course maths = new Course("Mathematics","MATH-202");
        Course java = new Course("Introduction to Java","INJ-101");
        Course physics = new Course("Physics","PHY-102");

        //Principal
        AdminPriviledges principal = new Principal("Mr. Olujobi",55,"PR-3412",500_000);

        //Staffs
        Staff teacher1 = new Teacher("Mr. Benson",39,"TCH-892",150_000,physics);
        Staff teacher2 = new Teacher("Mr. Deji",45,"TCH-491",200_000,java);
        Staff teacher3 = new Teacher("Mrs. Glory",42,"TCH-081",200_000,english);
        Staff teacher4 = new Teacher("Miss. Praise",39,"TCH-801",180_000,maths);
        Staff nonAcademicStaff = new NonAcademicStaff("Mr.Benjamin",35,"NASTF-742",100_000);

        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Staff> staffs = new ArrayList<>();
        ArrayList<Applicant> applicants = new ArrayList<>();
        ArrayList<Course> courses = new ArrayList<>();

        Collections.addAll(staffs,teacher1,teacher2,teacher3,teacher4,nonAcademicStaff,(Staff) principal);
        Collections.addAll(courses,english,maths,java,physics);

        DepartmentDatabase departmentDatabase = new DepartmentDatabase(students,staffs,applicants,courses);

        return new Department(departmentDatabase,principal);
    }
}