package com.sapo.function;

import java.util.HashMap;
import java.util.Map;

public class FunctionRepository {
        private Map<String, Student> students;
        private Map<String, Teacher> teachers;

        public FunctionRepository(){
            this.students = new HashMap<>();
            this.teachers = new HashMap<>();
        }

        public void registerStudent(Student student){
            this.students.put(student.getCpf(), student);
        }

        public void registerTeacher(Teacher teacher){
            this.teachers.put(teacher.getCpf(), teacher);
        }

        public void removeFunction(String CPF){
            if(this.teachers.containsKey(CPF)){
                this.teachers.remove(CPF);
            }else if(this.students.containsKey(CPF)){
                this.teachers.remove(CPF);
            }
        }

    public Map<String, Student> getStudents() {
        return students;
    }

    public Map<String, Teacher> getTeachers() {
        return teachers;
    }
}

