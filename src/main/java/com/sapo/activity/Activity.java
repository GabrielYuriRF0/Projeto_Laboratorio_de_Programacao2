package com.sapo.activity;

import com.sapo.person.Person;
import com.sapo.person.PersonRepository;

public class Activity {
    private String name;
    private String description;
    private String CPF;
    private String id;
    private int status;
    private String responsable;



    public Activity(String name, String description, String CPF){
        this.name = name;
        this.description = description;
        this.CPF = CPF;
        this.responsable = this.setResponsable(CPF);
        this.status = 0;
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return id;
    }
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public String setResponsable(String CPF){
        PersonRepository pr = new PersonRepository();
        Person responsable = pr.searchPerson(CPF);
        return responsable.getName();
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public void setID(String ID) {
        this.id = ID;
    }

    //TODO Deve ser possível alterar a descrição ou responsável da atividade. Uma atividade pode não ter responsável (pessoa removida), Neste caso a linha do responsável não aparece em sua exibição.
    @Override
    public String toString() {
        return  id + ": " + name + "\n" +
                "Résponsável: " + responsable + " - " + CPF + "\n" +
                "===\n" +
                description + "\n" +
                "===\n";
    }
}
