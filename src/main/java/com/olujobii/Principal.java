package com.olujobii;

import java.util.ArrayList;
import java.util.List;

public class Principal extends Staff implements AdminPriviledges{

    public Principal(String name, int age, String id, int salary) {
        super(name, age, id, salary);
    }

    @Override
    public boolean enrollStudent(Applicant applicant){
        if(applicant.getAge() < 11)
            return false;

        Student student = new Student(applicant.getName(),
                                        applicant.getAge(),
                                        applicant.getId(), new ArrayList<>());
        //We still have to add new Student to the database(arrayList) of enrolled student
        return true;
    }

    @Override
    public boolean expelStudent(List<Student> students){
        return true;
    }
}
