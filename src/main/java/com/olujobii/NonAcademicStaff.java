package com.olujobii;

public class NonAcademicStaff extends Staff{

    public NonAcademicStaff(String name, int age, String id, int salary) {
        super(name, age, id, salary);
    }

    @Override
    public String toString(){
        return "Name: "+getName()+", Staff ID: "+getId()+", Staff Role: Non-Academic Staff, Age: "+getAge()+
                ", Salary: "+getSalary();
    }
}
