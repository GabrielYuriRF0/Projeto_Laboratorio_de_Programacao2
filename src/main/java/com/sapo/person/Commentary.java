package com.sapo.person;

import java.util.Date;

public class Commentary {
    private final Date CURRENTDATE = new Date();
    private  String description;
    private String author;

    public Commentary(String description, String author){
        this.description = description;
        this.author = author;
    }

    @Override
    public String toString(){
        return "-" + this.description + "(" + this.author + ")";
    }


}
