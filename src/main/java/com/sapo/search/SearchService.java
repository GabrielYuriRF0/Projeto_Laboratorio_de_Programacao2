package com.sapo.search;

import com.sapo.activity.ActivityService;
import com.sapo.person.PersonService;
import com.sapo.tasks.TaskService;

import java.util.List;

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
    }

    public List<String> searchActivity(List<String> terms){

    }

    public List<String> searchTask(String name){ // Retornar toString de cada tarefa com esse nome

    }

    public List<String> searchTask(String idActivity, String name){

    }

    public List<String> sugestTasks(String cpf){

    }

    public List<String> recentSearch(int searchNumbers){
        return this.searchRepository.recentSearch(searchNumbers);
    }

    public List<String> showSearchHistoric(int searchId){
        return this.searchRepository.recentSearch(searchId);
    }
}
