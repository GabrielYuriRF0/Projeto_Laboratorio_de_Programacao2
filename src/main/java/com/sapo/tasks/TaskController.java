package com.sapo.tasks;

public class TaskController {
    private TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    public String registerTask(String idActivity, String name, String[] skills){
        return this.taskService.registerTask(new Task(name, skills),idActivity);
    }

    public void setName(String idTask, String newName){
        this.taskService.setName(idTask, newName);
    }

    public void setSkills(String idTask, String[] skills){
        this.taskService.setSkills(idTask, skills);
    }

    public void addHour(String idTask, int hour){
        this.taskService.addHour(idTask, hour);
    }

    public void removeHour(String idTask, int hour){
        this.taskService.removeHour(idTask, hour);
    }

    public void concludeTask(String idTask){
        this.taskService.concludeTask(idTask);
    }

    public void removeTask(String idTask){
        this.taskService.removeTask(idTask);
    }

    public String showTask(String idTask){
        return this.taskService.showTask(idTask);
    }

    public void addPersonTask(String cpf, String idTask){
        this.taskService.addPersonTask(cpf,idTask);
    }

    public void removePersonTask(String cpf, String idTask){
        this.removePersonTask(cpf,idTask);
    }



}
