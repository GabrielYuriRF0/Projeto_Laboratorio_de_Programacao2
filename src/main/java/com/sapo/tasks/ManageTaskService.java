package com.sapo.tasks;

import com.sapo.activity.ActivityService;

public class ManageTaskService {
    private ActivityService activityService;

    public ManageTaskService(ActivityService activityService){
        this.activityService = activityService;
    }

    public String registerManageTask(String idActivity, String name, String[] skills, String[] idsTasks){
        int parcialId = activityService.recoverActivity(idActivity).getTasks().quantityTasks();
        String idManageTask = idActivity + "-" + parcialId;
        return idManageTask;
    }


}
