package com.sapo.search;

import java.util.ArrayList;
import java.util.List;

public class Search {
    private String type;
    private List<String> content;

    public Search(String type, List<String> content){
        this.type = type;
        this.content = content;
    }
    public List<String> getTypeAndContent(){
        List<String> concatena = new ArrayList<>();
        concatena.add(this.type);
        for(String a : this.content){
            concatena.add(a);
        }
        return concatena;
    }
    public List<String> getContent(){
        return this.content;
    }
}
