package com.olujobii;

import com.olujobii.repository.DepartmentDatabase;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Department {
    private final DepartmentDatabase departmentDatabase;
    private final Scanner scanner;

    public Department(DepartmentDatabase departmentDatabase) {
        this.departmentDatabase = departmentDatabase;
        this.scanner = new Scanner(System.in);
    }

    public void runApplication() {
        boolean isProgramRunning = true;
        while (isProgramRunning){
            System.out.println("\n==== SCHOOL DEPARTMENT APP ====");
            System.out.println("1. List total number of courses");
            System.out.println("2. List total number of students");
            System.out.println("3. List total number of staffs");
            System.out.println("4. Register as an applicant");
            System.out.println("5. Approve or deny an applicant");
            System.out.println("6. Expel a student");
            System.out.println("7. Exit");
            System.out.print("Enter an option: ");

            String userOption = scanner.nextLine();
            switch (userOption){
                case "1":
                    listTotalNumberOfCourses();
                    break;
                case "2":
                    listTotalNumberOfStudents();
                    break;
                case "3":
                    listTotalNumberOfStaffs();
                    break;
                case "4":
                    registerApplicant();
                    break;
                case "5":
                    System.out.println("APPROVE OR DENY AN APPLICANT");
                    break;
                case "6":
                    System.out.println("Expel a student");
                    break;
                case "7":
                    System.out.println("EXIT");
                    isProgramRunning = false;
                    break;
                default:
                    System.out.println("Not a valid option");
                    break;
            }
        }
    }

    private void listTotalNumberOfCourses(){
        List<Course> courses = departmentDatabase.getAvailableCourses();
        System.out.println("We have "+courses.size()+" available courses");

        for(Course course : courses){
            System.out.println(course);
        }
    }

    private void listTotalNumberOfStudents(){
        List<Student> students = departmentDatabase.getEnrolledStudents();
        System.out.println("We have "+students.size()+" enrolled students");

        for(Student student : students){
            System.out.println(student);
        }
    }

    private void listTotalNumberOfStaffs(){
        List<Staff> staffs = departmentDatabase.getAvailableStaffs();
        System.out.println("We have "+staffs.size()+" available staffs");

        for(Staff staff : staffs){
            System.out.println(staff);
        }
    }

    private void registerApplicant(){
        String applicantName = "";
        do {
            System.out.print("Enter your name: ");
            applicantName = scanner.nextLine();

            if(applicantName.isBlank())
                System.out.println("You entered no name, please try again");
        }while(applicantName.isBlank());

        int applicantAge = 0;
        do{
            System.out.print("Enter your age: ");
            if(scanner.hasNextInt()){
                applicantAge = scanner.nextInt();
                scanner.nextLine();
            }
            else{
                scanner.nextLine();
                System.out.println("Not a valid age");
                continue;
            }

            if(applicantAge < 16){
                System.out.println("Apologies, "+applicantName+" is below the minimum age (16 years old) for application. Admission will not be granted");
                return;
            }
        }while(applicantAge < 16);

        String applicantId = "AP-"+createRandomID();

        Applicant applicant = new Applicant(applicantName,applicantAge,applicantId);
        departmentDatabase.addApplicant(applicant);
        System.out.println("Your profile has been created.");
    }

    //Creating 3 digits random ID for applicant
    private int createRandomID(){
        Random random = new Random();
        return random.nextInt(1,1000);
    }
}
