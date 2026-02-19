package com.olujobii;

public class Course {
    private final String courseName;
    private final String courseId;

    public Course(String courseName, String courseId) {
        this.courseName = courseName;
        this.courseId = courseId;
    }

    @Override
    public String toString(){
        return "Course Name: "+courseName+", Course ID: "+courseId;
    }
}
