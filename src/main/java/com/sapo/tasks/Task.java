package com.sapo.tasks;

import com.sapo.activity.Activity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Task{
    private String name;
    private int hour;
    private String[] skills;
    private String status;
    private Map<String, String> team; //cpf, name

    private String id;

    public Task(String name, String[] skills){
        this.name = name;
        this.skills = skills;
        this.hour = 0;
        this.status = "STARDED";
        this.team = new HashMap<>();
    }

    public void setName(String newName){
        this.name = newName;
    }

    public void setSkills(String[] newSkills){
        this.skills = newSkills;
    }

    public void addHour(int hours){
        this.hour += hours;
    }

    public void removeHour(int hours){
        //TODO validacao caso hora seja negativa.
        this.hour -= hours;
    }

    public void concludeTask(){
        if(this.status.equals("STARDED")){
            this.status = "FINISHED";
        }
        else{
            throw new IllegalStateException("Invalid Operation, the task status isn't STARDED");
        }
    }

    public void removeTask(){
        this.status = "REMOVED";
    }

    public String toString(Activity activity){
        String skills = "";
        String team = "";
        for(String cpf : this.team.keySet()){
            team += cpf + " " + "-" + " " + this.team.get(cpf) + "\n";
        }
        for(int i = 0; i < this.skills.length; i++){
            if(i == this.skills.length - 1){
                skills += this.skills[i];
            }
            skills += this.skills[i] + ", ";
        }
        String exibir = this.name + " " + "-" + " "+ this.id + "\n"
                + "-" + " " + activity.getName() + "\n"
                + skills + "\n"
                + "(" + this.hour + "horas(s) executada(s))" + "\n"
                + "===" + "\n"
                + activity.getDescription() + "\n"
                + "===" + "\n"
                + "Equipe:\n"
                + team;
        return exibir;
    }

    public void addPersonTask(String cpf, String name){
        this.team.put(cpf,name);
    }

    public void removePersonTask(String cpf){
        this.team.remove(cpf);
    }

    public String getStatus(){
        return this.status;
    }

    public String generateId(String idActivity, int taskSize){
        String id = idActivity + "-" + taskSize;
        this.id = id;
        return id;
    }

    public String getName(){
        return this.name;
    }
    public String[] getSkills(){
        return this.skills;
    }

}
