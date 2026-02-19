package com.olujobii;

public class Teacher extends Staff{
    private final Course courseTeaching;

    public Teacher(String name, int age, String id, int salary, Course courseTeaching) {
        super(name, age, id, salary);
        this.courseTeaching = courseTeaching;
    }


}
