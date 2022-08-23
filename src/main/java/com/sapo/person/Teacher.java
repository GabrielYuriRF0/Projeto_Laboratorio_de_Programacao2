package com.sapo.person;

public class Teacher extends Person{
    private String siape;
    private String[] disciplines;
    public Teacher(String cpf, String name, String siape, String[] disciplines, String[] skills) {
        super(cpf, name, skills);
        this.siape = siape;
        this.disciplines = disciplines;
    }

    @Override
    public String toString(){
        return "";
    }
}
