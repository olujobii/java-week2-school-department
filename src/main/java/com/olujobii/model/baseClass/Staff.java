package com.olujobii.model.baseClass;

import com.olujobii.enums.Gender;
import com.olujobii.enums.WorkType;

public abstract class Staff extends Person{
    private final WorkType workType;

    public Staff(String name, int age, Gender gender, String id, WorkType workType){
        super(name, age, gender, id);
        this.workType = workType;
    }

    public WorkType getWorkType() {
        return workType;
    }
}
