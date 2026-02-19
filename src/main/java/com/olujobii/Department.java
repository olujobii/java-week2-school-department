package com.olujobii;

import com.olujobii.repository.DepartmentDatabase;

import java.util.List;
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
            System.out.println("==== SCHOOL DEPARTMENT APP ====");
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
                    System.out.println("TOTAL NUMBER OF COURSES");
                    break;
                case "2":
                    System.out.println("TOTAL NUMBER OF STUDENTS");
                    break;
                case "3":
                    listTotalNumberOfStaffs();
                    break;
                case "4":
                    System.out.println("REGISTER AS AN APPLICANT");
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

    private void listTotalNumberOfStaffs(){
        List<Staff> staffs = departmentDatabase.getAvailableStaffs();
        System.out.println("We have "+staffs.size()+" available staffs");

        for(Staff staff : staffs){
            System.out.println(staff);
        }
    }
}
