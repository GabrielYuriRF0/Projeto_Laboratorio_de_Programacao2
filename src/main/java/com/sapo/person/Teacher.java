package com.sapo.person;

import java.util.SortedSet;
import java.util.TreeSet;

public class Teacher extends Person{
    private String siape;
    private String[] disciplines;
    public Teacher(String cpf, String name, String siape, String[] disciplines, String[] skills) {
        super(cpf, name, skills);
        this.siape = siape;
        this.disciplines = disciplines;
    }

    @Override
    public String toString(){
        SortedSet<String> skills = new TreeSet<String>();
        String formatedSkills = new String();
        String disciplinesString = "";
        formatedSkills += "\n";

        for (String skill : super.skills) {
            skills.add(skill);
        }

        for(String skill: skills){
            formatedSkills += "-" + skill + "\n";
        }
        for(int i = 0; i < this.disciplines.length; i++){
            if(i == this.disciplines.length - 1){
                disciplinesString += disciplines[i];
            }else{
                disciplinesString += disciplines[i] + ", ";
            }
        }

        return super.name + "-" + super.cpf + "\n" +
                "Professor - " + this.siape + " - " + disciplinesString + "\n" +
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
