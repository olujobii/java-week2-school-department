package com.olujobii.model.baseClass;

import com.olujobii.enums.Gender;

public abstract class Person {
    private final String name;
    private final int age;
    private final Gender gender;
    private String id;

    public Person(String name, int age, Gender gender, String id) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    @Override
    public abstract String toString();
}
