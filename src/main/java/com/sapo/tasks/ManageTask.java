package com.sapo.tasks;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ManageTask {
    private String id;
    private String name;
    private String status;
    private int hours;
    private HashSet<String>  skills;
    private Map<String, String> team;
    private Map<String, Task> tasks;

    //FIXME Implementar a geração do team, horas e ID.
    public ManageTask(String name,HashSet<String> skills){
        this.name = name;
        this.skills = skills;
        this.status = "STARTED";
        this.tasks = new HashMap<>();
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
