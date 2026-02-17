package com.olujobii;

import java.util.ArrayList;

public class Principal extends Staff implements AdminPriviledges{

    public Principal(String name, int age, String id, double salary) {
        super(name, age, id, salary);
    }

    /*
     * We can use an interface because not only principal should be able to approve for removal
     * or addition of course to curriculum, to expel student upon wrong-doing or to enroll a
     * student
     * */
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
}
