package com.sapo.activity;

import java.util.*;

public class ActivityRepository {
    private Map<String,Activity> activities;

    public ActivityRepository(){
         this.activities = new HashMap<>();
    }
    public void addActivity(Activity a){
        String key = generateID(a);
        a.setStatus(0);
        a.setID(key);
        this.activities.put(key, a);
    }

    public String generateID(Activity a){
        StringBuilder consonants = new StringBuilder();
        StringBuilder id = new StringBuilder();
        List<Character> vowelsAndNumbers = new ArrayList<>(Arrays.asList('a','A','e','E','i','I','o','O','u','U',' ',
                '0','1','2','3','4','5','6','7','8','9'));

        //transformar String em um array de Char
        char[] letters = a.getName().toCharArray();

        //tirando vogais e espaços vazios e transformando para maiusculo
        for (int i = 0; i < letters.length;i++) {
            if (!vowelsAndNumbers.contains(letters[i]) ) {
                consonants.append(Character.toString(i).toUpperCase());
            };
        }

        if(consonants.length() < 3){
            for(int i = 0; i < consonants.length();i++){
                id.append(consonants.charAt(i));
            }
            while(id.length() <= 3){
                id.append("X");
            }
        }else{
            for(int i = 0; i < 3; i++){
                id.append(consonants.charAt(i));
            }
        }

        id.append("-");
        id.append(Integer.toString(activities.size()));

        return id.toString();
    }

    public Activity recoverActivity(String ID){
        return activities.get(ID);
    }

    public void searchIdInRepository(String id){
        for (String s : activities.keySet()) {
            if (s.equals(id)) {
                return ;
            }
        }
        throw new NoSuchElementException("ID não existente no repositório");
    }

    //Método para retornar uma atividade para ser usada nos testes:
    public Activity getActivity(String id){
        return activities.get(id);
    }
}
