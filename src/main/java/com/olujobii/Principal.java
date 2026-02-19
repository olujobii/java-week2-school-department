package com.olujobii;

import java.util.ArrayList;
import java.util.List;

public class Principal extends Staff implements AdminPriviledges{

    public Principal(String name, int age, String id, int salary) {
        super(name, age, id, salary);
    }

    @Override
    public boolean enrollStudent(Applicant applicant){
        return true;
    }

    @Override
    public boolean expelStudent(List<Student> students){
        return true;
    }

    @Override
    public String toString(){
        return "Name: "+getName()+", Staff ID: "+getId()+", Staff Role: Principal, Age: "+getAge()+
                ", Salary: "+getSalary();
    }
}
