package com.olujobii;

public abstract class Staff extends Person{
    private final int salary;

    public Staff(String name, int age, String id, int salary) {
        super(name, age, id);
        this.salary = salary;
    }


    public int getSalary() {
        return salary;
    }

    @Override
    public abstract String toString();
}
