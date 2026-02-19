package com.olujobii;

public class Student extends Person{
    private final Course enrolledCourse;

    public Student(String name, int age, String id, Course enrolledCourse) {
        super(name, age, id);
        this.enrolledCourse = enrolledCourse;
    }


    @Override
    public String toString(){
        return "Name: "+getName()+", Student ID: "+getId()+", Age: "+getAge()+
                ", Enrolled Course: "+enrolledCourse.getCourseName();
    }
}
