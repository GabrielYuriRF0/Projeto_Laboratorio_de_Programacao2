package com.sapo.person;

import com.sapo.activity.Activity;
import com.sapo.activity.ActivityRepository;
import com.sapo.activity.ActivityService;
import com.sapo.tasks.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PersonService {
    private PersonRepository personRepository;
    private ActivityService activityService;

    public PersonService(ActivityService activityService){
        this.personRepository = new PersonRepository();
        this.activityService = activityService;
    }

    public void registerPerson(Person person){
        this.personRepository.registerPerson(person);
    }

    public void removePerson(String cpf){
        this.personRepository.removePerson(cpf);
    }

    public String showPerson(String cpf){
        return this.personRepository.showPerson(cpf);
    }

    public void setPersonName(String cpf, String newName){
        this.personRepository.setPersonName(cpf, newName);
    }

    public void setPersonSkills(String cpf, String[] newSkills){
        this.personRepository.setPersonSkills(cpf, newSkills);
    }

    public void registerComments(String cpf, String commentary, String authorCpf){
        this.personRepository.registerComments(cpf, commentary, authorCpf);
    }

    public String showComments(String cpf){
        return this.personRepository.showComments(cpf);
    }

    public String getPersonName(String cpf){
        return this.personRepository.getPersonName(cpf);
    }

    public Person getPerson(String cpf){
        return this.personRepository.getPerson(cpf);
    }

    public void defineTeacherFunction(String cpf, String siape, String[] disciplines){
        this.personRepository.defineTeacherFunction(cpf, siape, disciplines);
    }
    public void defineStudentFunction(String cpf, String registration, int period){
        this.personRepository.defineStudentFunction(cpf, registration, period);
    }
    public void removeFunction(String CPF){
        this.personRepository.removeFunction(CPF);
    }
    public float getLevel(String CPF){
        Map<String, Activity> ac = this.activityService.getActivities();
        String[] personSkills = this.personRepository.getPerson(CPF).getSkills();
        float level = 0;
        List<Task> tasks = new ArrayList<>();
        for(Activity a: ac.values()){
            if(a.getCpf().equals(CPF)){
                tasks.addAll(a.getTasks().getTasks().values());
            }
        }

        if(this.personRepository.getPerson(CPF).getFunction().equals("NO FUNCTION")){
            int countStarted = 0;
            int countFinished = 0;
            for(Task status: tasks){
                if(status.getStatus().equals("STARTED")){
                    countStarted++;
                } else if (status.getStatus().equals("FINISHED")) {
                    countFinished++;
                }
            }
            level = (float) (Math.floor(countStarted/2) + countFinished);
        }else if(this.personRepository.getPerson(CPF).getFunction().equals("TEACHER")){
            int countStarted = 0;
            int countFinished = 0;
            for(Task status: tasks){
                if()
            }
        }
        return level;
    }
    public String[] listPeople(){
        return this.personRepository.listPeople();
    }

    public Map<String, Person> getPeople(){
        return this.personRepository.getPeople();
    }
}
