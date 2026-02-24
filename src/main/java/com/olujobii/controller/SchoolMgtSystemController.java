package com.olujobii.controller;

import java.util.Scanner;

public class SchoolMgtSystemController {
    private final Scanner scanner;

    public SchoolMgtSystemController(Scanner scanner) {
        this.scanner = scanner;
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
                    System.out.println("Listed courses");
                    break;
                case "2":
                    System.out.println("Listed students");
                    break;
                case "3":
                    System.out.println("Listed staffs");
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

    private void exitApplication(){
        System.out.println("Thanks for using our app");
        scanner.close();
    }
}
