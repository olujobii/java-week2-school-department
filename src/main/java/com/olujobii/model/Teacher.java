package com.olujobii.model;

import com.olujobii.enums.Courses;
import com.olujobii.enums.Gender;
import com.olujobii.model.baseClass.Staff;

public class Teacher extends Staff{
    private final Courses courseTeaching;

    public Teacher(String name, int age, Gender gender, String id, Courses courseTeaching) {
        super(name, age, gender, id);
        this.courseTeaching = courseTeaching;
    }

    public Courses getCourseTeaching() {
        return courseTeaching;
    }

    @Override
    public String toString(){
        return "Name: "+getName()+", ID: "+getId()+", Age: "+getAge()+
                ", Gender: "+getGender()+", Course Teaching: "+getCourseTeaching();
    }
}
