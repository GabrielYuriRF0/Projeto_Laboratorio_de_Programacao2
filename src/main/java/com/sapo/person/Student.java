package com.sapo.person;

public class Student extends Person{
    private String registration;
    private int period;

    public Student(String cpf, String name, String registration, int period, String[] skills) {
        super(cpf, name, skills);
        this.registration = registration;
        this.period = period;
    }

    @Override
    public String toString(){
        return "";
    }
}
