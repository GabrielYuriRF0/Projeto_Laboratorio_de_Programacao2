package com.sapo.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class SearchRepository {
    private List<Search> searchHistoric;

    public SearchRepository(){
        this.searchHistoric = new ArrayList<>();
    }

    public void registerSearch(Search search){
        this.searchHistoric.add(search);
    }

    public List<String> recentSearch(int searchNumbers){
        List<String> concatena = new ArrayList<>();
        List<Search> recentHistoric = this.searchHistoric;
        Collections.reverse(recentHistoric);
        if(searchNumbers > recentHistoric.size()){
            throw new NoSuchElementException("Element not found!");
        }
        else{
            for(int i = 0; i < searchNumbers; i++){
                concatena.addAll(recentHistoric.get(i).getTypeAndContent());
                }
            }
            return concatena;
    }

    public List<String> showSearchHistoric(int searchId){
        if(searchId > this.searchHistoric.size()){
            throw new NoSuchElementException("Element not found!");
        }
        else{
            if(this.searchHistoric.get(searchId) == null){
                throw new NoSuchElementException("Element not found!");
            }
            else{
                return this.searchHistoric.get(searchId).getTypeAndContent();
            }
        }
    }
}
