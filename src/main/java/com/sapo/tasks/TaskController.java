package com.sapo.tasks;

public class TaskController {
    private TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    public String registerTask(String idActivity, String name, String[] skills){
        //TODO implementar e ver a ligação com atividade pra pegar o ip.
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
        //TODO dps.
    }

    public void addPersonTask(String cpf, String idTask){
        //TODO dps.
    }

    public void removePersonTask(String cpf, String idTask){
        //TODO dps.
    }



}
