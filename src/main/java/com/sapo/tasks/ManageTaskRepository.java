package com.sapo.tasks;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class ManageTaskRepository {
    private Map<String, ManageTask> manageTasks;

    public ManageTaskRepository(){
        this.manageTasks = new HashMap<>();
    }

    public void registerManageTask(ManageTask ManageTask){
        this.manageTasks.put(ManageTask.getId(),ManageTask);

    }

    public void addInManageTask(String idManageTask, Task task){
        checkRegistrationForManageTask(idManageTask);
        this.manageTasks.get(idManageTask).registerTask(task);
    }

    public void removeTask(String idManageTask, Task task){
        checkRegistrationForManageTask(idManageTask);
        this.manageTasks.get(idManageTask).removeTask(task.getId());
    }

    public int countTasksInManage(String idManageTask){
        checkRegistrationForManageTask(idManageTask);
        return this.manageTasks.get(idManageTask).countTasksInManage();
    }

    public void checkRegistrationForManageTask(String idManageTask){
        if(this.manageTasks.containsKey(idManageTask) == false){
            throw new NoSuchElementException("This Manage Task is not registered in the system!");
        }
    }


}
