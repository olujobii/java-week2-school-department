package com.olujobii.model.baseClass;

import com.olujobii.enums.Gender;

public abstract class Staff extends Person{

    public Staff(String name, int age, Gender gender, String id){
        super(name, age, gender, id);
    }
}
