package com.olujobii;

import java.util.List;

public class Classes {
    private final List<Student> classStudentsList;
    private Teacher classTeacher;

    public Classes(List<Student> classStudentsList, Teacher classTeacher){
        this.classStudentsList = classStudentsList;
        this.classTeacher = classTeacher;
    }
}
