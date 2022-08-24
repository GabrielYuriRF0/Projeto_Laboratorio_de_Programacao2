package com.sapo.search;

import java.util.List;

public class SearchController {
    private SearchService searchService;

    public SearchController(SearchService searchService){
        this.searchService = searchService;
    }

    public List<String> searchPerson(String terms){
        //TODO validacao termos.
        String[] termos = terms.split(" ");
        return this.searchService.searchPerson(termos);
    }

    public List<String> searchActivity(String terms){
        String[] termos = terms.split(" ");
        return this.searchService.searchActivity(termos);
    }

    /*public List<String> searchTask(String name){
        return this.searchService.searchTask(name);
    }

    public List<String> searchTask(String idActivity, String name){

    }

    public List<String> sugestTasks(String cpf){

    }
    */
    public List<String> recentSearch(int searchNumbers){
        return this.searchService.recentSearch(searchNumbers);
    }

    public List<String> showSearchHistoric(int searchId){
        return this.searchService.showSearchHistoric(searchId);
    }
}
