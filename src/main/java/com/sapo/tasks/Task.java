package com.sapo.tasks;

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

    public String toString(){
        return "  ";
        //TODO implementar tostring depois.
    }

    public void addPersonTask(String cpf){
        this.team.put(cpf,cpf);
        //TODO implementar depois que fizer repositorio,service e controller.
    }

    public void removePersonTask(String cpf){
        this.team.remove(cpf);
        //TODO implementar depois que fizer repositorio,service e controller ---- MAS ACHO QUE ESTÁ CERTO.
    }

    public String getStatus(){
        return this.status;
    }

    public String generateId(String idActivity, int taskSize){
        String id = idActivity + "-" + taskSize;
        return id;
    }


}
