package com.sapo.function;

import com.sapo.activity.Activity;
import com.sapo.person.Person;
import com.sapo.person.PersonService;
import com.sapo.tasks.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FunctionService {
    private FunctionRepository functionRepository;
    private PersonService personService;

    public FunctionService(PersonService personService){
        this.personService = personService;
        this.functionRepository = new FunctionRepository();
    }

    public void registerTeacher(Teacher teacher){
        this.functionRepository.registerTeacher(teacher);

    }
    public void registerStudent(Student student){
        this.functionRepository.registerStudent(student);
    }
    public void removeFunction(String CPF){
        this.functionRepository.removeFunction(CPF);
    }
//    public String[] listPeople(){
//        Map<String, Person> people = this.personService.getPeople();
//        Map<String, Student> students = this.functionRepository.getStudents();
//        Map<String, Teacher> teacher = this.functionRepository.getTeachers();
//    }

//    public void defineTeacherFunction(String cpf, String siape, String[] disciplines){
//        this.personRepository.defineTeacherFunction(cpf, siape, disciplines);
//    }
//    public void defineStudentFunction(String cpf, String registration, int period){
//        this.personRepository.defineStudentFunction(cpf, registration, period);
//    }
//    public void removeFunction(String CPF){
//        this.personRepository.removeFunction(CPF);
//    }
//    public float getLevel(String CPF){
//        Map<String, Activity> ac = this.activityService.getActivities();
//
//        float level = 0;
//        List<Task> tasks = new ArrayList<>();
//        for(Activity a: ac.values()){
//            if(a.getCpf().equals(CPF)){
//                tasks.addAll(a.getTasks().getTasks().values());
//            }
//        }
//
//        if(this.personRepository.getPerson(CPF).getFunction().equals("NO FUNCTION")){
//            String[] personSkills = this.personRepository.getPerson(CPF).getSkills();
//            int countStarted = 0;
//            int countFinished = 0;
//            for(Task status: tasks){
//                if(status.getStatus().equals("STARTED")){
//                    countStarted++;
//                } else if (status.getStatus().equals("FINISHED")) {
//                    countFinished++;
//                }
//            }
//            level = (float) (Math.floor(countStarted/2) + countFinished);
//        }else if(this.personRepository.getPerson(CPF).getFunction().equals("TEACHER")){
//            String[] teacherSkills = this.personRepository.getPerson(CPF).getSkills();
//            String[] teacherDisciplines = this.personRepository.getPerson(CPF);
//            int countStarted = 0;
//            int countFinished = 0;
//            for(Task task: tasks){
//                if(task.getStatus().equals("STARTED")){
//                    countStarted++;
//                }else if(task.getStatus().equals("FINISHED")){
//                    for(String statusTask: task.getSkills()){
//                        for(String skillsTeacher: teacherSkills){
//                            if(statusTask.equals(skillsTeacher)){
//                                countFinished++;
//                            }
//                        }
//                        for(String disciplineTeacher: this.personRepository.getPerson(CPF).getSkills()){
//                            if(statusTask.equals(disciplineTeacher)){
//                                countFinished++;
//                            }
//                        }
//                    }
//                }
//            }
//            level = (float) (Math.floor(countStarted/4) + countFinished);
//        }else if(this.personRepository.getPerson(CPF).getFunction().equals("STUDENT")){
//            String[] studentsSkills = this.personRepository.getPerson(CPF).getSkills();
//            int countStarted = 0;
//            int countFinished = 0;
//            for(Task task: tasks){
//                if(task.getStatus().equals("STARTED")){
//                    countStarted++;
//                } else if (task.getStatus().equals("FINISHED")) {
//                    for(String statusTask: task.getSkills()){
//                        for(String skillsStudents: studentsSkills){
//                            if(statusTask.equals(skillsStudents)){
//                                countFinished++;
//                            }
//                        }
//                    }
//
//                }
//            }
//            level = (float) (Math.floor(countStarted/2) + countFinished);
//        }
//        return level;
//    }
//
}
