package com.sapo.tasks;

import com.sapo.activity.Activity;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class TaskRepository {
    private Map<String, Task> tasks; //idTask, task.

    public TaskRepository(){
        this.tasks = new HashMap<>();
    }
    public String registerTask(Task task, String idActivity, int taskSize){
        String idTask = task.generateId(idActivity,taskSize);
        tasks.put(idTask,task);
        return idTask;
    }

    public void setName(String idTask, String newName){
        checkIfWasRegistered(idTask);
        tasks.get(idTask).setName(newName);
    }

    public void setSkills(String idTask, String[] newSkills){
        checkIfWasRegistered(idTask);
        tasks.get(idTask).setSkills(newSkills);
    }

    public void addHour(String idTask, int hours){
        checkIfWasRegistered(idTask);
        tasks.get(idTask).addHour(hours);
    }

    public void removeHour(String idTask, int hours){
        checkIfWasRegistered(idTask);
        tasks.get(idTask).removeHour(hours);
    }

    public void concludeTask(String idTask){
        checkIfWasRegistered(idTask);
        tasks.get(idTask).concludeTask();
    }

    public void removeTask(String idTask){
        checkIfWasRegistered(idTask);
        tasks.get(idTask).removeTask();
        tasks.remove(idTask);
    }
    public String showTask(String idTask, Activity activity){
        checkIfWasRegistered(idTask);
        return tasks.get(idTask).toString(activity);
    }

    public void addPersonTask(String idTask, String cpf, String name){
        checkIfWasRegistered(idTask);
        tasks.get(idTask).addPersonTask(cpf,name);
    }

    public void removePersonTask(String idTask, String cpf){
        checkIfWasRegistered(idTask);
        tasks.get(idTask).removePersonTask(cpf);
    }

    public int quantityTasks(){
        return this.tasks.size();
    }

    public Task getTask(String idTask){
        checkIfWasRegistered(idTask);
        return this.tasks.get(idTask);
    }

    public int countActiveTasks(){
        int count = 0;
        for(Task task: this.tasks.values()){
            if(task.getStatus().equals("STARDED")){
                count++;
            }
        }
        return count;
    }
    public Map<String, Task> getTasks() {
        return tasks;
    }
    public void checkIfWasRegistered(String idTask){
        if(!this.tasks.containsKey(idTask)){
            throw new NoSuchElementException("Task do not registered in the repository");
        }
    }
}
