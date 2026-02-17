package com.olujobii;

import java.util.List;

public class Student extends Person{
    private final List<Course> enrolledCourses;

    public Student(String name, int age, String id, List<Course> enrolledCourses) {
        super(name, age, id);
        this.enrolledCourses = enrolledCourses;
    }

    // We can do a check in Department class to check if student has enrolled in course already
    // If course list is 5, do not add

    public boolean addNewCourse(Course course){
        if(enrolledCourses.size() ==  5)
            return false;

        enrolledCourses.add(course);
        return true;
    }

    public List<Course> getEnrolledCourses(){
        return enrolledCourses;
    }
}
