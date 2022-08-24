package com.sapo.function;

import com.sapo.person.PersonService;
import com.sapo.validator.PersonValidator;

public class FunctionController {
    private FunctionService functionService;
    private PersonValidator personValidator;

    public FunctionController(FunctionService functionService){
        this.functionService = functionService;
        this.personValidator = new PersonValidator();
    }

    public void registerTeacher(String CPF, String name, String siape, String[] disciplines, String[] skills){
        personValidator.validateGeneralString(name);
        personValidator.generalValidate(skills);
        personValidator.cpfValidator(CPF);
        personValidator.validateGeneralString(siape);
        personValidator.generalValidate(disciplines);
        this.functionService.registerTeacher(new Teacher(CPF, name, siape, disciplines, skills));
    }
    public void registerStudent(String CPF, String name, String registration, int period, String[] skills){
        personValidator.validateGeneralString(name);
        personValidator.generalValidate(skills);
        personValidator.cpfValidator(CPF);
        personValidator.validateGeneralString(registration);
        personValidator.periodValidator(period);
        this.functionService.registerStudent(new Student(CPF, name, registration, period, skills));
    }
    public void removeFunction(String CPF){
        personValidator.cpfValidator(CPF);
        this.functionService.removeFunction(CPF);
    }
//    public void defineTeacherFunction(String CPF, String siape, String[] disciplines){
//        personValidator.cpfValidator(CPF);
//        personValidator.validateGeneralString(siape);
//        personValidator.generalValidate(disciplines);
//        this.functionService.defineTeacherFunction(CPF, siape, disciplines);
//    }
//
//    public void defineStudentFunction(String CPF, String registration, int period){
//        personValidator.cpfValidator(CPF);
//        personValidator.validateGeneralString(registration);
//        personValidator.periodValidator(period);
//        this.functionService.defineStudentFunction(CPF, registration, period);
//    }
//
//    public float getLevel(String CPF){
//        personValidator.cpfValidator(CPF);
//        return this.functionService.getLevel(CPF);
//    }
//    public String[] listPeople(){
//        return this.functionService.listPeople();
//    }


}

