package com.olujobii.presentation;

import com.olujobii.enums.Courses;
import com.olujobii.enums.Gender;
import com.olujobii.model.Applicant;
import com.olujobii.model.Principal;
import com.olujobii.model.Student;
import com.olujobii.model.baseClass.Staff;
import com.olujobii.service.*;
import com.olujobii.util.AuthenticatorUtil;
import com.olujobii.util.IdGeneratorUtil;
import com.olujobii.util.InputValidatorUtil;

import java.util.List;
import java.util.Scanner;

public class SchoolMgtSystem {
    private final Scanner scanner;
    private final StudentService studentService;
    private final StaffService staffService;
    private final CourseService courseService;
    private final PrincipalService principalService;
    private final ApplicantService applicantService;

    public SchoolMgtSystem(StudentService studentService, StaffService staffService
            ,CourseService courseService, PrincipalService principalService,ApplicantService applicantService) {
        this.scanner = new Scanner(System.in);
        this.studentService = studentService;
        this.staffService = staffService;
        this.courseService = courseService;
        this.principalService = principalService;
        this.applicantService = applicantService;
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

    private void listCourses(){
        List<Courses> courses = courseService.listAllCourses();

        if(courses.isEmpty()){
            System.out.println("We offer no courses yet");
            return;
        }

        System.out.println("We have "+courses.size()+" courses\n");
        for(int i = 0 ; i < courses.size(); i++){
            int order = i + 1;
            System.out.println(order+". "+courses.get(i));
        }
    }

    private void listStudents(){
        List<Student> students = studentService.listAllStudents();

        if(students.isEmpty()){
            System.out.println("No student has been enrolled");
            return;
        }

        System.out.println("We have "+students.size()+" students enrolled in the department\n");
        for(int i = 0 ; i < students.size(); i++){
            int order = i + 1;
            System.out.println(order+". "+students.get(i));
        }
    }

    private void listStaffs(){
        List<Staff> staffs = staffService.listAllStaffs();

        if(staffs.isEmpty()){
            System.out.println("No staff has been employed");
            return;
        }

        System.out.println("We have "+staffs.size()+" staffs employed in the department\n");

        for(int i = 0 ; i < staffs.size(); i++){
            int order = i + 1;
            System.out.println(order+". "+staffs.get(i));
        }
    }

    private void registerApplicant(){
        String applicantName;
        int applicantAge = 0;
        Gender applicantGender = null;
        String applicantId;
        Courses applicantChoiceOfCourse = null;

        //VALIDATING NAME
        boolean isValid = false;
        do{
            System.out.print("Enter your name: ");
            applicantName = scanner.nextLine().trim();

            if(applicantName.isBlank()){
                System.out.println("You did not enter a valid name, try again");
                continue;
            }

            isValid = true;
        }while(!isValid);

        //VALIDATING AGE
        isValid = false;
        do{
            System.out.print("Enter your age: ");
            String userInput = scanner.nextLine();

            if(!InputValidatorUtil.isAValidInteger(userInput)){
                System.out.println("Not a valid age");
                continue;
            }
            applicantAge = Integer.parseInt(userInput);
            isValid = true;

        }while(!isValid);

        //VALIDATING IF APPLICANT IS BETWEEN ADMISSION AGE REQUIREMENTS (16-20)
        if(InputValidatorUtil.validateUserAge(applicantAge)){
            System.out.println("Applicants does not meet the department's age requirements(16-20)." +
                    " Admission cannot be processed further");
            return;
        }

        //VALIDATING GENDER
        isValid = false;
        do {
            genderMenuOptions();
            String userGenderChoice = scanner.nextLine();
            switch(userGenderChoice){
                case "1":
                    applicantGender = Gender.MALE;
                    isValid = true;
                    break;
                case "2":
                    applicantGender = Gender.FEMALE;
                    isValid = true;
                    break;
                case "3":
                    applicantGender = Gender.OTHERS;
                    isValid = true;
                    break;
                default:
                    System.out.println("You did not pick a valid gender.");
                    break;
            }
        }while(!isValid);

        //VALIDATING COURSE
        isValid = false;
        do {
            courseOptions();
            String userCourseChoice = scanner.nextLine();
            switch(userCourseChoice){
                case "1":
                    applicantChoiceOfCourse = Courses.JAVA;
                    isValid = true;
                    break;
                case "2":
                    applicantChoiceOfCourse = Courses.GOLANG;
                    isValid = true;
                    break;
                case "3":
                    applicantChoiceOfCourse = Courses.PYTHON;
                    isValid = true;
                    break;
                case "4":
                    applicantChoiceOfCourse = Courses.JAVASCRIPT;
                    isValid = true;
                    break;
                default:
                    System.out.println("You did not pick a valid course.");
                    break;
            }
        }while(!isValid);

        //CREATE RANDOM ID
        applicantId = IdGeneratorUtil.idGeneration("AP");
        System.out.println(applicantId);

        //CREATE APPLICANT AND SAVE TO DB
        Applicant applicant = applicantService.createApplicant(applicantName,applicantAge,applicantGender,applicantId,applicantChoiceOfCourse);
        applicantService.saveApplicantToList(applicant);
        System.out.println("Applicant created successfully");
    }

    private void approveApplicant(){
        Principal principal = principalService.getPrincipal();
        int noOfChances = 3;

        //CHECKING IF THERE IS A PRINCIPAL TO GRANT ADMIN PRIVILEDGES
        if(principal == null){
            System.out.println("Only the principal can authorize approval of applicants");
            return;
        }

        //AUTHENTICATOR - PRINCIPAL MUST ENTER CORRECT PASSWORD TO GAIN ACCESS
        int chances = runAuthentication(principal,noOfChances);
        
        if(chances == 0){
            System.out.println("System has been locked, try again later");
            return;
        }

        //CHECKING IF THERE IS ANY APPLICANT AWAITING APPROVAL
        List<Applicant> applicants = applicantService.getAllApplicants();
        if(applicants.isEmpty()){
            System.out.println("We have no applicants awaiting approval into the department");
            return;
        }

        System.out.println("We have "+applicants.size()+" awaiting approval");
        for(int i = 0; i < applicants.size(); i++){
            int index = i + 1;
            System.out.println(index+". "+applicants.get(i));
        }

        //CHOOSING APPLICANT TO APPROVE FOR ADMISSION
        int adminOption = 0;
        boolean isApplicantChosen = false;
        do {
            System.out.print("\nPick an applicant: ");

            String userOption = scanner.nextLine();

            if(!InputValidatorUtil.isAValidInteger(userOption)){
                System.out.println("Not a valid integer");
                continue;
            }

            adminOption = Integer.parseInt(userOption);

            if(adminOption < 1 || adminOption > applicants.size()){
                System.out.println("Not a valid option");
                continue;
            }

            isApplicantChosen = true;
        }while(!isApplicantChosen);

        //APPROVING APPLICANT FOR ADMISSION
        int index = adminOption - 1;
        Applicant applicant = applicants.get(index);

        applicant.setId(IdGeneratorUtil.idGeneration("ST"));

        //CREATE STUDENT, SAVE TO DB AND REMOVE FROM APPLICANT DB
        Student student = studentService.createStudent(applicant);
        applicantService.deleteApplicantFromList(applicant);
        studentService.saveStudentToList(student);
        System.out.println(student.getName()+" is now enrolled as a student in the department");
    }

    private void expelStudent(){
        Principal principal = principalService.getPrincipal();
        int noOfChances = 3;

        //CHECKING IF THERE IS A PRINCIPAL TO GRANT ADMIN PRIVILEDGES
        if(principal == null){
            System.out.println("Only the principal can authorize approval of applicants");
            return;
        }

        //AUTHENTICATOR - PRINCIPAL MUST ENTER CORRECT PASSWORD TO GAIN ACCESS
        int chances = runAuthentication(principal,noOfChances);

        if(chances == 0){
            System.out.println("System has been locked, try again later");
            return;
        }

        List<Student> students = studentService.listAllStudents();
        if(students.isEmpty()){
            System.out.println("No student has been enrolled");
            return;
        }

        for(int i = 0 ; i < students.size(); i++){
            int order = i + 1;
            System.out.println(order+". "+students.get(i));
        }

        int adminOption = 0;
        boolean isApplicantChosen = false;
        do {
            System.out.print("\nPick a student: ");

            String userOption = scanner.nextLine();

            if(!InputValidatorUtil.isAValidInteger(userOption)){
                System.out.println("Not a valid integer");
                continue;
            }

            adminOption = Integer.parseInt(userOption);

            if(adminOption < 1 || adminOption > students.size()){
                System.out.println("Not a valid option");
                continue;
            }

            isApplicantChosen = true;
        }while(!isApplicantChosen);

        int index = adminOption - 1;
        Student student = students.get(index);

        //EXPELLING STUDENT
        studentService.removeStudentFromList(student);
        System.out.println("Student has been expelled");
    }

    private void exitApplication(){
        System.out.println("Thanks for using our app");
        scanner.close();
    }

    private void genderMenuOptions(){
        System.out.println("Pick your gender");
        System.out.println("1. "+Gender.MALE);
        System.out.println("2. "+Gender.FEMALE);
        System.out.println("3. "+Gender.OTHERS);
    }

    private void courseOptions(){
        System.out.println("Choose your interested course");
        System.out.println("1. "+Courses.JAVA);
        System.out.println("2. "+Courses.GOLANG);
        System.out.println("3. "+Courses.PYTHON);
        System.out.println("3. "+Courses.JAVASCRIPT);

    }

    private int runAuthentication(Principal principal, int noOfChances){
        System.out.print("Welcome "+principal.getName()+", enter password to continue ("+noOfChances+") attempts left: ");
        do {
            String adminPassword = scanner.nextLine();

            if (!AuthenticatorUtil.authenticator(adminPassword)){
                noOfChances--;
                System.out.print("Wrong password, please try again ("+noOfChances+") attempts left: ");
            }
            else
                break;

        } while (noOfChances > 0);

        return noOfChances;
    }
}
