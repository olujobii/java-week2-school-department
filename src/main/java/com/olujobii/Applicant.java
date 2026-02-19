package com.olujobii;

public class Applicant extends Person{

    public Applicant(String name, int age, String id) {
        super(name, age, id);
    }

    @Override
    public String toString(){
        return "Name: "+getName()+", Applicant ID: "+getId()+", Age: "+getAge();
    }
}
