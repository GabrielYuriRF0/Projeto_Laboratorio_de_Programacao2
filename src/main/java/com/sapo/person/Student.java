package com.sapo.person;

import java.util.SortedSet;
import java.util.TreeSet;

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
        SortedSet<String> skills = new TreeSet<String>();
        String formatedSkills = new String();
        formatedSkills += "\n";

        for (String skill : this.skills) {
            skills.add(skill);
        }

        for(String skill: skills){
            formatedSkills += "-" + skill + "\n";
        }

        return super.name + "-" + super.cpf + "\n" +
                "Professor - " + this.registration + " - " + this.period + "\n" +
                "Comentários:\n" +
                formatedSkills;
    }

    @Override
    public float calculateLevel(){
        if(this.function.equals("NO FUNCTION")){

        }
        return 0;
    }
}
