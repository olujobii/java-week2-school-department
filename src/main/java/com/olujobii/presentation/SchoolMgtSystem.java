package com.olujobii.presentation;

import com.olujobii.enums.Courses;
import com.olujobii.model.Student;
import com.olujobii.model.baseClass.Staff;
import com.olujobii.repository.DepartmentRepository;
import com.olujobii.service.*;

import java.util.List;
import java.util.Scanner;

public class SchoolMgtSystem {
    private final Scanner scanner;
    private final DepartmentRepository departmentRepository;
    private final StudentService studentService;
    private final StaffService staffService;
    private final CourseService courseService;

    public SchoolMgtSystem(Scanner scanner, DepartmentRepository departmentRepository
            , StudentService studentService, StaffService staffService,CourseService courseService) {
        this.scanner = scanner;
        this.studentService = studentService;
        this.staffService = staffService;
        this.courseService = courseService;
        //Creating mock data for in-memory database
        this.departmentRepository = departmentRepository;
        departmentRepository.createMockData();
    }

    public void runApplication(){
        boolean isProgramRunning = true;
        while (isProgramRunning){
            System.out.println("\n==== SCHOOL DEPARTMENT APP ====");
            System.out.println("1. List total number of courses");
            System.out.println("2. List total number of students");
            System.out.println("3. List total number of staffs");
            System.out.println("4. Register as an applicant");
            System.out.println("5. Approve an applicant");
            System.out.println("6. Expel a student");
            System.out.println("7. Exit");
            System.out.print("Enter an option: ");

            String userOption = scanner.nextLine();
            switch (userOption){
                case "1":
                    listCourses();
                    break;
                case "2":
                    listStudents();
                    break;
                case "3":
                    listStaffs();
                    break;
                case "4":
                    System.out.println("Registered applicants");
                    break;
                case "5":
                    System.out.println("Approved applicants");
                    break;
                case "6":
                    System.out.println("Expelled Student");
                    break;
                case "7":
                    exitApplication();
                    isProgramRunning = false;
                    break;
                default:
                    System.out.println("Not a valid option");
                    break;
            }
        }
    }

    private void listCourses(){
        List<Courses> courses = courseService.listAllCourses();

        if(courses.isEmpty()){
            System.out.println("We offer no courses yet");
            return;
        }

        System.out.println("We have "+courses.size()+" courses\n");
        for(Courses course : courses)
            System.out.println(course);
    }

    private void listStudents(){
        List<Student> students = studentService.listAllStudents();

        if(students.isEmpty()){
            System.out.println("No student has been enrolled");
            return;
        }

        System.out.println("We have "+students.size()+" students enrolled in the department\n");
        for(Student student : students)
            System.out.println(student);
    }

    private void listStaffs(){
        List<Staff> staffs = staffService.listAllStaffs();

        if(staffs.isEmpty()){
            System.out.println("No staff has been employed");
            return;
        }

        System.out.println("We have "+staffs.size()+" staffs employed in the department\n");

        for(Staff staff : staffs)
            System.out.println(staff);
    }

    private void exitApplication(){
        System.out.println("Thanks for using our app");
        scanner.close();
    }
}
