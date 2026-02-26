package com.olujobii.model;

import com.olujobii.enums.Courses;
import com.olujobii.enums.Gender;
import com.olujobii.model.baseClass.Person;

public class Applicant extends Person {
    private final Courses interestedCourse;

    public Applicant(String name, int age, Gender gender, String id, Courses interestedCourse) {
        super(name, age, gender, id);
        this.interestedCourse = interestedCourse;
    }

    public Courses getInterestedCourse() {
        return interestedCourse;
    }

    @Override
    public String toString(){
        return "Name: "+getName()+", ID: "+getId()+", Age: "+getAge()+
                ", Gender: "+getGender()+", Interested Course: "+getInterestedCourse();
    }
}
