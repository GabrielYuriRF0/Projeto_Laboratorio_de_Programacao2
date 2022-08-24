package com.sapo.search;

import com.sapo.activity.Activity;
import com.sapo.activity.ActivityService;
import com.sapo.person.Person;
import com.sapo.person.PersonService;
import com.sapo.tasks.Task;
import com.sapo.tasks.TaskRepository;
import com.sapo.tasks.TaskService;

import java.util.*;

public class SearchService {
    private SearchRepository searchRepository;
    private PersonService personService;
    private ActivityService activityService;
    private TaskService taskService;

    public SearchService(PersonService personService, ActivityService activityService, TaskService taskService){
        this.searchRepository = new SearchRepository();
        this.personService = personService;
        this.activityService = activityService;
        this.taskService = taskService;
    }

    public List<String> searchPerson(String[] terms){
        //TODO implementar.
        List<String> personList = new ArrayList<>();
        Map<String, Person> people = this.personService.getPeople();
        for(Person p : people.values()){
            int count = 0;
            for(String term : terms){
                boolean isHere = false;
                if(p.getCpf().equals(term)){
                    isHere = true;
                }
                if(p.getName().toUpperCase().equals(term.toUpperCase())){
                    isHere = true;
                }
                if(Arrays.asList(p.getSkills()).contains(term.toLowerCase()) || Arrays.asList(p.getSkills()).contains(term.toUpperCase())){
                    isHere = true;
                }
                if(isHere == true){
                    count++;
                }
            }
            if(count == terms.length){
                personList.add(p.getName());
            }
        }
        if(personList.size() == 0){
            this.searchRepository.registerSearch(new Search("PERSON", personList));
            return personList;
        }
        else{
            Collections.sort(personList);
            this.searchRepository.registerSearch(new Search("PERSON", personList));
            return personList;
        }
    }

    public List<String> searchActivity(String[] terms){
        List<String> activityStringList = new ArrayList<>();
        Map<String, Activity> activityMap = this.activityService.getActivities();
        for(Activity a : activityMap.values()){
            String[] idActivitySplit = a.getId().split("-");
            for(String term : terms){
                boolean isHere = false;
                if(a.getName().equalsIgnoreCase(term)){
                    isHere = true;
                }
                if(a.getDescription().toUpperCase().contains(term.toUpperCase())){
                    isHere = true;
                }
                if(idActivitySplit[0].equalsIgnoreCase(term)){
                    isHere = true;
                }
                if(idActivitySplit[1].equalsIgnoreCase(term)){
                    isHere = true;
                }
                if(a.toString().equalsIgnoreCase(term)){
                    isHere = true;
                }
                if(isHere == true){
                    activityStringList.add(a.toString());
                    break;
                }
            }
        }
        this.searchRepository.registerSearch(new Search("ACTIVITY", activityStringList));
        return activityStringList;
    }

    public List<String> searchTask(String name){ // Retornar toString de cada tarefa com esse nome
        List<String> taskStringList = new ArrayList<>();
        Map<String, Activity> activityMap = this.activityService.getActivities();
        for(Activity a : activityMap.values()){
            TaskRepository tasks = a.getTasks();
            Map<String, Task> tasksActivity = tasks.getTasks();
            for(Task t : tasksActivity.values()){
                if(t.getName().equalsIgnoreCase(name)){
                    taskStringList.add(t.toString());
                }
            }
        }
        this.searchRepository.registerSearch(new Search("TASK", taskStringList));
        return taskStringList;

    }

    public List<String> searchTask(String idActivity, String name){
        List<String> taskStringList = new ArrayList<>();
        Activity ac = this.activityService.recoverActivity(idActivity);
        TaskRepository tasks = ac.getTasks();
        Map<String, Task> tasksActivity = tasks.getTasks();

        for(Task t : tasksActivity.values()){
            if(t.getName().equalsIgnoreCase(name)){
                taskStringList.add(t.toString());
            }
        }

        this.searchRepository.registerSearch(new Search("TASK", taskStringList));
        return taskStringList;

    }

    //public List<String> sugestTasks(String cpf){

    //}

    public List<String> recentSearch(int searchNumbers){
        return this.searchRepository.recentSearch(searchNumbers);
    }

    public List<String> showSearchHistoric(int searchId){
        return this.searchRepository.recentSearch(searchId);
    }
}
