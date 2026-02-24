package com.olujobii.model;

import com.olujobii.enums.Courses;
import com.olujobii.enums.Gender;
import com.olujobii.model.baseClass.Person;

public class Student extends Person {
    private final Courses enrolledCourse;


    public Student(String name, int age, Gender gender, String id
                    ,Courses enrolledCourse) {
        super(name, age, gender, id);
        this.enrolledCourse = enrolledCourse;
    }

    public Courses getEnrolledCourse() {
        return enrolledCourse;
    }

    @Override
    public String toString(){
        return "Name: "+getName()+", ID: "+getId()+", Age: "+getAge()+
                ", Gender: "+getGender()+", Enrolled Course: "+getEnrolledCourse();
    }
}
