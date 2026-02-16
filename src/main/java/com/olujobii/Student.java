package com.olujobii;

import java.util.List;

public class Student extends Person{
    private final List<Course> enrolledCourses;

    public Student(String name, int age, String id, List<Course> enrolledCourses) {
        super(name, age, id);
        this.enrolledCourses = enrolledCourses;
    }


    public void addNewCourse(Course course){
        enrolledCourses.add(course);
    }

    public List<Course> getEnrolledCourses(){
        return enrolledCourses;
    }
}
