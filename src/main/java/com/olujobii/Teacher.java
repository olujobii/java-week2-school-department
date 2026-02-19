package com.olujobii;

public class Teacher extends Staff{
    private final Course courseTeaching;

    public Teacher(String name, int age, String id, int salary, Course courseTeaching) {
        super(name, age, id, salary);
        this.courseTeaching = courseTeaching;
    }

    @Override
    public String toString(){
        return "Name: "+getName()+", Staff ID: "+getId()+", Staff Role: Teacher, Age: "+getAge()+
                ", Salary: "+getSalary()+", Course Teaching: "+courseTeaching;
    }
}
