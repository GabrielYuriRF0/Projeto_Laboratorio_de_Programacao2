package com.sapo.person;

import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

public class Person{
    private String cpf;
    private String name;
    private String[] skills;
    private ArrayList<Commentary> comments;


    public Person(String cpf, String name, String[] skills){
        this.cpf = cpf;
        this.name = name;
        this.skills = skills;
    }

    @Override
    public String toString(){
        SortedSet<String> skills = new TreeSet<String>();
        String formatedSkills = new String();

        for (String skill : this.skills) {
            skills.add(skill);
        }

        for(String skill: skills){
            formatedSkills += "-" + skill + "\n";
        }

        return this.name + "-" + this.cpf + formatedSkills;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public void setSkills(String[] newSkills){
        this.skills = newSkills;
    }

    public void registerCommentary(Commentary commentary){
        this.comments.add(commentary);
    }


    public String showComments(){
        String totalComments = new String();

        for(Commentary commentary: this.comments){
            totalComments += commentary.toString() + "\n";
        }
        return totalComments;
    }

    public String getCpf(){
        return this.cpf;
    }

    public String getName(){
        return this.name;
    }

}