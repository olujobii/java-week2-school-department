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
            System.out.println("5. Approve an applicant");
            System.out.println("6. Expel a student");
            System.out.println("7. Exit");
            System.out.print("Enter an option: ");

            String userOption = scanner.nextLine();
            switch (userOption){
                case "1":
                    listAvailableCourses(departmentDatabase.getAvailableCourses());
                    break;
                case "2":
                    listAllStudents(departmentDatabase.getEnrolledStudents());
                    break;
                case "3":
                    listAllStaffs();
                    break;
                case "4":
                    registerApplicant();
                    break;
                case "5":
                    approveApplicant();
                    break;
                case "6":
                    expelStudent();
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

    private void listAvailableCourses(List<Course> courses){
        if(courses.isEmpty()){
            System.out.println("We offer no courses at the moment");
            return;
        }

        System.out.println("We have "+courses.size()+" available courses");

        for(int i = 0 ; i < courses.size() ; i++){
            int order = i + 1;

            System.out.println(order+". "+courses.get(i));
        }
    }

    private void listAllStudents(List<Student> students){
        System.out.println("We have "+students.size()+" enrolled students");

        for(int i = 0 ; i < students.size() ; i++){
            int order = i + 1;

            System.out.println(order+". "+students.get(i));
        }
    }

    private void listAllStaffs(){
        List<Staff> staffs = departmentDatabase.getAvailableStaffs();

        if(staffs.isEmpty()){
            System.out.println("We have no staffs at the moment");
            return;
        }

        System.out.println("We have "+staffs.size()+" available staffs");

        for(Staff staff : staffs){
            System.out.println(staff);
        }
    }

    private void registerApplicant(){
        String applicantName;
        List<Course> courses = departmentDatabase.getAvailableCourses();
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

        int applicantCourseChoice = 0;
        boolean isCourseSelected = false;
        Course selectedCourse;
        do{
            System.out.println("Select course you are interested in");
            listAvailableCourses(courses);

            System.out.print("Enter option: ");
            if(scanner.hasNextInt()){
                applicantCourseChoice = scanner.nextInt();
                scanner.nextLine();
            }else{
                System.out.println("Not a valid option");
                scanner.nextLine();
                continue;
            }

            if(applicantCourseChoice > 0 && applicantCourseChoice <= courses.size())
                isCourseSelected = true;
            else
                System.out.println("You did not select a valid course");
        }while(!isCourseSelected);

        String applicantId = "AP-"+createRandomID();

        int index = applicantCourseChoice - 1;
        selectedCourse = courses.get(index);

        Applicant applicant = new Applicant(applicantName,applicantAge,applicantId,selectedCourse);
        departmentDatabase.addApplicant(applicant);
        System.out.println("Your profile has been created.");
    }

    private void approveApplicant(){
        if(!adminAuthentication()){
            System.out.println("Cannot sign in at the moment. Try again later");
            return;
        }

        System.out.println("Welcome back admin");
        List<Applicant> applicants = departmentDatabase.getApplicantList();

        if(applicants.isEmpty()){
            System.out.println("We have no applicants at the moment");
            return;
        }

        int adminSelection = 0;
        boolean isApplicantSelected = false;
        do {
            System.out.println("Which applicants will you like to approve: ");
            listAllApplicants(applicants);

            System.out.print("Enter option: ");
            if(scanner.hasNextInt()){
                adminSelection = scanner.nextInt();
                scanner.nextLine();
            }else{
                System.out.println("Not a valid option");
                scanner.nextLine();
                continue;
            }

            if(adminSelection > 0 && adminSelection <= applicants.size())
                isApplicantSelected = true;
            else
                System.out.println("You did not select a valid applicant");
        }while(!isApplicantSelected);

        int index = adminSelection - 1;

        Applicant selectedApplicant = applicants.get(index);

        //APPROVING APPLICANT TO STUDENT
        approveApplicantToStudent(selectedApplicant,index);
    }

    private void expelStudent(){
        if(!adminAuthentication()){
            System.out.println("Cannot sign in at the moment. Try again later");
            return;
        }

        System.out.println("Welcome back admin");
        List<Student> students = departmentDatabase.getEnrolledStudents();

        if(students.isEmpty()){
            System.out.println("We have no student at the moment");
            return;
        }

        boolean isStudentSelected = false;
        int adminSelection = 0;
        do {
            System.out.println("Select the student you will like to expel");
            listAllStudents(students);
            System.out.print("Enter option: ");
            if(scanner.hasNextInt()){
                adminSelection = scanner.nextInt();
                scanner.nextLine();
            }else{
                System.out.println("Not a valid option");
                scanner.nextLine();
                continue;
            }

            if(adminSelection > 0 && adminSelection <= students.size())
                isStudentSelected = true;
            else
                System.out.println("You did not select a valid student");
        }while(!isStudentSelected);

        int index = adminSelection - 1;
        departmentDatabase.removeStudent(index);
        System.out.println("Student has been expelled");
    }

    private void exitApplication(){
        System.out.println("Thanks for using the app");
        scanner.close();
    }

    //Creating 3 digits random ID for applicant
    private int createRandomID(){
        Random random = new Random();
        return random.nextInt(1,1000);
    }

    private boolean adminAuthentication(){
        int noOfChances = 3; //No of Chances to input correct password
        String userPasswordInput;
        AdminPriviledges adminPriviledges = departmentDatabase.getAdminPriviledgesType();

        if(adminPriviledges == null)
            return false;


        //ADMIN PASSWORD IS 12345
        do{
            System.out.println(noOfChances+"/3 attempts");
            System.out.print("Enter admin password to gain access: ");
            userPasswordInput = scanner.nextLine();

            if(!userPasswordInput.equals("12345")){
                System.out.println("Password incorrect");
                noOfChances--;
            }

            if(userPasswordInput.equals("12345")){
                break;
            }
        }while(noOfChances > 0);

        return noOfChances != 0;
    }

    private void listAllApplicants(List<Applicant> applicants){
        for(int i = 0 ; i < applicants.size() ; i++){
            int order = i + 1;

            System.out.println(order+". "+applicants.get(i));
        }
    }

    //APPROVE APPLICANT TO STUDENT
    private void approveApplicantToStudent(Applicant selectedApplicant, int index){
        //UPDATING APPLICANT ID TO STUDENT ID
        String selectedApplicantId = selectedApplicant.getId();
        String updateApplicantId = selectedApplicantId.replace("AP","ST");
        selectedApplicant.setId(updateApplicantId);

        Student student = new Student(selectedApplicant.getName(),selectedApplicant.getAge(),selectedApplicant.getId()
                ,selectedApplicant.getEnrolledCourse());

        departmentDatabase.addStudent(student);
        departmentDatabase.removeApplicant(index);

        System.out.println(student.getName()+" is now approved as a student");
    }
}
