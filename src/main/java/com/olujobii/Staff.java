package com.olujobii;

public abstract class Staff extends Person{
    private double salary;

    public Staff(String name, int age, String id, double salary) {
        super(name, age, id);
        this.salary = salary;
    }


    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}
