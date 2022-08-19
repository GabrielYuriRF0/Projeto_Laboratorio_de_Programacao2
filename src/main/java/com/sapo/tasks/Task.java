package com.sapo.tasks;

import java.util.List;
import java.util.Map;

import com.sapo.person.Person;

public class Task {
    private String name;
    private int hour;
    private String[] skills;
    private String status;
    private Map<String, String> team; //cpf, name

    public Task(String name, String[] skills){
        this.name = name;
        this.skills = skills;
        this.hour = 0;
        this.status = "STARDED";
    }

    public void setName(String newName){
        this.name = newName;
    }

    public void setSkills(String[] newSkills){
        this.skills = newSkills;
    }

    public void addTime(int hours){
        this.hour += hours;
    }

    public void removeTime(int hours){
        //TODO validacao caso hora seja negativa.
        this.hour -= hours;
    }

    public void concludeTask(){
        if(this.status.equals("STARDED")){
            this.status = "FINISHED";
        }
        else{
            throw new IllegalStateException("Invalid Operation, the task status isn't starded");
        }
    }



}
