package com.olujobii;

public class Student extends Person{
    private Course enrolledCourse;

    public Student(String name, int age, String id, Course enrolledCourse) {
        super(name, age, id);
        this.enrolledCourse = enrolledCourse;
    }


    public Course getEnrolledCourse() {
        return enrolledCourse;
    }

    public void setEnrolledCourse(Course enrolledCourse) {
        this.enrolledCourse = enrolledCourse;
    }


}
