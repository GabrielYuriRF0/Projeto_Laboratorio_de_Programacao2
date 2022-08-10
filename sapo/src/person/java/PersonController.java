public class PersonController {
    private PersonRepository pr = new PersonRepository();

    public void registerPerson(String cpf, String name, String[] skills){
        pr.registerPerson(new Person(cpf,name,skills));
    }

    public String showPerson(String cpf){
        return pr.searchPerson(cpf).toString();
    }

    public void setPersonName(String cpf, String newName){
        pr.searchPerson(cpf).setName(newName);
    }

    public void setPersonSkills(String cpf, String[] newSkills){
        pr.searchPerson(cpf).setSkills(newSkills);
    }

    public void deletePerson(String cpf){
        pr.deletePerson(cpf);
    }

    public void addPersonCommentary(String cpf, String description, String author){
        pr.searchPerson(cpf).addCommentary(new Commentary(description,author));
    }

    public String showPersonComments(String cpf){
        return pr.searchPerson(cpf).showComments();
    }


}
