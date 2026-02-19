package com.olujobii;

public class Applicant extends Person{
    private final Course enrolledCourse;

    public Applicant(String name, int age, String id,Course enrolledCourse) {
        super(name, age, id);
        this.enrolledCourse = enrolledCourse;
    }

    public Course getEnrolledCourse() {
        return enrolledCourse;
    }

    @Override
    public String toString(){
        return "Name: "+getName()+", Applicant ID: "+getId()+", Age: "+getAge()+", Course: "+enrolledCourse.getCourseName();
    }
}
