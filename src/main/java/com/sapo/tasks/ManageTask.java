package com.sapo.tasks;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ManageTask {
    private String id;
    private String name;
    private String status;
    private int hours;
    private HashSet<String> skills;
    private String[] team;
    private Map<String, Task> tasks;

    //FIXME Implementar a geração do team.
    public ManageTask(String name, HashSet<String> skills, int hours, String[] team){
        this.name = name;
        this.skills = skills;
        this.hours = hours;
        this.status = "STARTED";
        this.team = team;
        this.tasks = new HashMap<>();
    }

    public void registerTask(Task task){
        this.tasks.put(task.getId(), task);
    }

    public void removeTask(String idTask){
        this.tasks.remove(idTask);
    }
    public void registerHours(int newHours){
        if((this.status.equals("DISABLED") || this.status.equals("FINISHED"))){
            throw new IllegalStateException("Invalid operation!");
        }
        else{
            this.hours += newHours;
        }
    }

    public void removeHours(int newHours){
        if((this.status.equals("DISABLED") || this.status.equals("FINISHED")) || this.hours - newHours < 0){
            throw new IllegalStateException("Invalid operation!");
        }
        else{
            this.hours -= newHours;
        }

    }

    //FIXME Implementar toString
    @Override
    public String toString(){
        return "";
    }

    public void setStatus(String newStatus){
        this.status = newStatus;
    }

    //FIXME Implementar setTeam
    public void setTeam(){

    }
    public int countTasksInManage(){
        return this.tasks.size();
    }

    public String getId(){
        return this.id;
    }
}
