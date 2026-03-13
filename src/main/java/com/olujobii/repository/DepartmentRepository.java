package com.olujobii.repository;

import com.olujobii.enums.Courses;
import com.olujobii.model.*;
import com.olujobii.model.baseClass.Staff;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class DepartmentRepository {
    private static final String URL = "jdbc:h2:file:./schooldb;INIT=RUNSCRIPT FROM 'classpath:schema.sql'";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "";
    private final List<Courses> totalCourses;
    private final List<Student> totalStudents;
    private final List<Staff> totalStaffs;
    private final List<Applicant> totalApplicants;

    public DepartmentRepository(List<Courses> totalCourses,List<Student> totalStudents,List<Staff> totalStaffs,
                                List<Applicant> totalApplicants) {
        this.totalCourses = totalCourses;
        this.totalStudents = totalStudents;
        this.totalStaffs = totalStaffs;
        this.totalApplicants = totalApplicants;
    }

    public void createMockData(){
        ResultSet resultSetStaff = null;
        ResultSet resultSetStudent = null;
        try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            Statement statement = connection.createStatement()){
            connection.setAutoCommit(false);

            //INSERTS INITIAL VALUES IF DB FILE DOES NOT EXIST IN DIRECTORY
            resultSetStaff = statement.executeQuery("SELECT * FROM staffs");
            if(!resultSetStaff.next()){
                String execute1 = "INSERT INTO staffs VALUES('PR-394','Segun Osiki',33,'MALE','PRINCIPAL',NULL)";
                statement.addBatch(execute1);
                String execute2 = "INSERT INTO staffs VALUES('TCH-493','John Olajide',27,'MALE','TEACHER','GOLANG')";
                statement.addBatch(execute2);
                String execute3 = "INSERT INTO staffs VALUES('TCH-532','Samuel Joseph',25,'MALE','TEACHER','JAVA')";
                statement.addBatch(execute3);
                String execute4 = "INSERT INTO staffs VALUES('TCH-053','Oluwasetemi Precious',28,'FEMALE','TEACHER','JAVASCRIPT')";
                statement.addBatch(execute4);
                String execute5 = "INSERT INTO staffs VALUES('TCH-981','Gloria',25,'FEMALE','TEACHER','PYTHON')";
                statement.addBatch(execute5);
                String execute6 = "INSERT INTO staffs VALUES('NST-238','David',27,'MALE','SECURITY',NULL)";
                statement.addBatch(execute6);
                String execute7 = "INSERT INTO staffs VALUES('NST-008','Chisom',29,'FEMALE','CLEANER',NULL)";
                statement.addBatch(execute7);
                String execute8 = "INSERT INTO staffs VALUES('NST-764','Daniel',27,'MALE','CHEF',NULL)";
                statement.addBatch(execute8);

                statement.executeBatch();
                connection.commit();
            }

            resultSetStudent = statement.executeQuery("SELECT * FROM students");
            if(!resultSetStudent.next())
            {
                String execute1 = "INSERT INTO students VALUES('ST-482','Ife Olujobi',23,'MALE','JAVA')";
                statement.addBatch(execute1);
                String execute2 = "INSERT INTO students VALUES('ST-810','Frank Joseph',39,'MALE','PYTHON')";
                statement.addBatch(execute2);
                String execute3 = "INSERT INTO students VALUES('ST-002','Chisom Nwachukwu',23,'FEAMLE','GOLANG')";
                statement.addBatch(execute3);
                String execute4 = "INSERT INTO students VALUES('ST-003','Timilehin Awoniyi',26,'MALE','JAVASCRIPT')";
                statement.addBatch(execute4);

                statement.executeBatch();
                connection.commit();
            }
        }catch(SQLException ex){
            System.out.println("An error occurred");
            ex.printStackTrace();
        }finally {
            try{
                if(resultSetStaff != null)
                    resultSetStaff.close();

                if(resultSetStudent != null)
                    resultSetStudent.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
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

    public void deleteApplicant(Applicant applicant) {
        totalApplicants.remove(applicant);
    }

    public void saveStudent(Student student) {
        totalStudents.add(student);
    }

    public void removeStudent(Student student) {
        totalStudents.remove(student);
    }
}
