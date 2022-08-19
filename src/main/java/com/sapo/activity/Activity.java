package com.sapo.activity;

import com.sapo.person.Person;
import com.sapo.person.PersonRepository;

public class Activity {
    private String name;
    private String description;
    private String cpf;
    private String responsableName;
    private String status;
    private String id;
    //todo pegar o map de taks


    public Activity(String name, String description, String cpf){
        this.name = name;
        this.description = description;
        this.cpf = cpf;
        this.status = "STARTED";
    }

    public void generateId(int size){
        String consonants = "";
    }

    public void concludeActivity(){
        this.status = "FINISHED";
    }
    public void disableActivity(){
        this.status = "DISABLED";
    }
    public void reopenActivity(){
        this.status = "STARTED";
    }

    public String getId() {
        return id;
    }

    public String toString(){
        return this.id + ": " + this.name + "\n" +
                "Responsável: " + responsableName + " - " + cpf + "\n" +
                "===\n" +
                description + "\n" +
                "===\n" +
                "Tarefas: ";
                //todo terminar o toString()

    }

    public void changeDescription(String newDescription){
        this.description = newDescription;
    }

    public void changeResponsable(String Cpf){
        this.responsableName = cpf;
    }

    public String getResponsableName(){
        return this.responsableName;
    }
}
