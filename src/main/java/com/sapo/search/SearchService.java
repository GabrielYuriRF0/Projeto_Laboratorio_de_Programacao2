package com.sapo.search;

import com.sapo.activity.ActivityService;
import com.sapo.person.Person;
import com.sapo.person.PersonService;
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
                if(p.getName().equals(term)){
                    isHere = true;
                }
                if(Arrays.asList(p.getSkills()).contains(term)){
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
