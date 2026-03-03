package com.olujobii.model;

import com.olujobii.enums.Gender;
import com.olujobii.enums.WorkType;
import com.olujobii.model.baseClass.Staff;

public class NonAcademicStaff extends Staff{

    public NonAcademicStaff(String name, int age, Gender gender, String id
            , WorkType workType) {
        super(name, age, gender, id, workType);
    }


    @Override
    public String toString(){
        return "Name: "+getName()+", ID: "+getId()+", Age: "+getAge()+
                ", Gender: "+getGender()+", Work Type: "+getWorkType();
    }
}
