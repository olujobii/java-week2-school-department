package com.olujobii;

import java.util.List;

public class Student extends Person{
    private final Course enrolledCourses;

    public Student(String name, int age, String id, Course enrolledCourses) {
        super(name, age, id);
        this.enrolledCourses = enrolledCourses;
    }


    @Override
    public String toString(){
        return "Name: "+getName()+", Student ID: "+getId()+", Age: "+getAge()+
                ", Enrolled Course: "+enrolledCourses.getCourseName();
    }
}
