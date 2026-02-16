package com.olujobii;

public class Teacher extends Staff{
    private Course courseTeaching;

    public Teacher(String name, int age, String id, double salary, Course courseTeaching) {
        super(name, age, id, salary);
        this.courseTeaching = courseTeaching;
    }


}
