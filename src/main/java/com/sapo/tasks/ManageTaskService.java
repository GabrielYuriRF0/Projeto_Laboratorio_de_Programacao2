package com.sapo.tasks;

import com.sapo.activity.Activity;
import com.sapo.activity.ActivityService;
import org.apache.commons.lang3.ArrayUtils;

import java.util.HashSet;
import java.util.Map;

public class ManageTaskService {
    private ActivityService activityService;


    public ManageTaskService(ActivityService activityService){
        this.activityService = activityService;
    }

    public String registerManageTask(String idActivity, String name, String[] skills, String[] idsTasks){
        int parcialId = activityService.recoverActivity(idActivity).getTasks().quantityTasks();
        String idManageTask = idActivity + "-" + parcialId;
        Activity activity = activityService.recoverActivity(idActivity);

        // Gerar a união referente a todas as habilidades de todas as tarefas contidas na atividade e o tempo total das atividades:
        Map<String, Task> mapOfTasks = activity.getTasks().getTasks();
        var listOfTasks = mapOfTasks.values();
        String[] unionOfSkills = new String[0];
        int totalHours = 0;
        String[] team = new String[0];

        for(Task task: listOfTasks){
            unionOfSkills = ArrayUtils.addAll(unionOfSkills, task.getSkills());
            totalHours += task.getHour();
            team += task.getName()
        }

        // Remover duplicatas das habilidades
        HashSet<String> setUnionOfSkills = new HashSet<>();
        for(String skill: unionOfSkills){
            setUnionOfSkills.add(skill);
        }

        activity.getmanageTaskRepository().getManageTaskRepository().put(idManageTask, new ManageTask(name, setUnionOfSkills, totalHours));
        return idManageTask;
    }

    public void addInManageTask(String idManageTask, String idTask){
        Activity activity =


    }


}
