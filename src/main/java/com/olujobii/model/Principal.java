package com.olujobii.model;

import com.olujobii.enums.Gender;
import com.olujobii.model.baseClass.Staff;

public class Principal extends Staff {

    public Principal(String name, int age, Gender gender, String id) {
        super(name, age, gender, id);
    }

    @Override
    public String toString(){
        return "Name: "+getName()+", ID: "+getId()+", Age: "+getAge()+
                ", Gender: "+getGender();
    }
}
