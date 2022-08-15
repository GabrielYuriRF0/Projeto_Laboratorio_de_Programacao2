package com.sapo.person;

import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

public class Person{
    private String cpf;

    private String name;
    private String[] skills;
    private ArrayList<Commentary> comments = new ArrayList<Commentary>() ;


    public Person(String cpf, String name, String[] skills){
        this.cpf = cpf;
        this.name = name;
        this.skills = skills;
    }
    public Person(String cpf, String name){
        this.cpf = cpf;
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public String getCpf(){
        return this.cpf;
    }

    public void setSkills(String[] newSkills){
        this.skills = newSkills;

    }

    public void addCommentary(Commentary commentary){
        this.comments.add(commentary);
    }

    private String showSkills() {
        SortedSet<String> skills = new TreeSet<String>();
        String formatedSkills = new String();

        for (String skill : this.skills) {
            skills.add(skill);
        }

        for(String skill: skills){
            formatedSkills += "-" + skill + "\n";
        }
        return formatedSkills;

    }


    @Override
    public String toString(){
        return this.name + " - " + this.cpf + "\n" + showSkills();
    }

    public String showComments(){
        String comments = new String();

        for(Commentary commentary: this.comments){
            comments += commentary.toString() + "\n";
        }

        return comments;

    }

}