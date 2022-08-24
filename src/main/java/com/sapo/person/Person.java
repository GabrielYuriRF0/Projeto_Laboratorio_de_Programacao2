package com.sapo.person;

import com.sapo.activity.Activity;

import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

public class Person{
    protected String cpf;
    protected String name;
    protected String[] skills;
    protected ArrayList<Commentary> comments;
    protected float level;
    protected String function;
    protected ArrayList<Activity> activities;



    public Person(String cpf, String name, String[] skills){
        this.cpf = cpf;
        this.name = name;
        this.skills = skills;
        this.comments = new ArrayList<>();
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

    public String[] getSkills(){
        return this.skills;
    }
    public float calculateLevel(){
        return 0;
    }

    public float getLevel() {
        return level;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public void setActivities(Activity activities) {
        this.activities.add(activities);
    }
}