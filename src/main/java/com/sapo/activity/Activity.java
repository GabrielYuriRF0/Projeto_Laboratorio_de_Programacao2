package com.sapo.activity;

import com.sapo.person.Person;
import com.sapo.person.PersonRepository;
import com.sapo.tasks.Task;
import com.sapo.tasks.TaskRepository;
import com.sapo.tasks.TaskService;

import java.util.*;

public class Activity {
    private String name;
    private String description;
    private String cpf;
    private String responsableName;
    private String status;
    private String id;
    private TaskRepository tasks;

    public Activity(String name, String description, String cpf){
        this.name = name;
        this.description = description;
        this.cpf = cpf;
        this.status = "STARTED";
        this.tasks = new TaskRepository();
    }

    public void generateId(int size){
        StringBuilder consonants = new StringBuilder();
        StringBuilder result = new StringBuilder();
        List<Character> vowelsAndNumbers = new ArrayList<>(Arrays.asList('a','A','e','E','i','I','o','O','u','U',' ',
                '0','1','2','3','4','5','6','7','8','9'));

        //transformar String em um array de Char
        char[] letters = this.name.toCharArray();

        //tirando vogais e espaços vazios e transformando para maiusculo
        for (int i = 0; i < letters.length; i++) {
            if (!vowelsAndNumbers.contains(letters[i]) ) {
                consonants.append(Character.toString(i).toUpperCase());
            };
        }

        if(consonants.length() < 3){
            for(int i = 0; i < consonants.length();i++){
                result.append(consonants.charAt(i));
            }
            for(int i = consonants.length(); i <= 3; i++){
                result.append("X");
            }
        }else{
            for(int i = 0; i < 3; i++){
                result.append(consonants.charAt(i));
            }
        }

        result.append("-");
        result.append(Integer.toString(size));

        this.id = result.toString();
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
    public String getStatus() {
        return status;
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

    public void changeResponsable(String Cpf, String responsableName){
        this.responsableName = responsableName;
        this.cpf = Cpf;
    }

    public void setResponsableName(String responsableName) {
        this.responsableName = responsableName;
    }

    public String getResponsableName(){
        return this.responsableName;
    }

    public String getCpf() {
        return cpf;
    }

    public TaskRepository getTasks(){
        return this.tasks;
    }
    public String getName(){
        return this.name;
    }
    public String getDescription(){
        return this.description;
    }
}
