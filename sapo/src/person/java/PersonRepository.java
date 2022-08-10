import java.util.HashMap;
import java.util.Map;

public class PersonRepository {
    private Map<String,Person> people = new HashMap<String, Person>();

    public void registerPerson(Person person){
        people.put(person.getCpf(),person);
    }

    public Person searchPerson(String cpf){
        return this.people.get(cpf);

    }

    public void deletePerson(String cpf){
        this.people.remove(cpf);
    }

    public void addPersonCommentary(String cpf, Commentary commentary){
        this.people.get(cpf).addCommentary(commentary);

    }
    public boolean checkRegistration(String cpf){
        return people.containsKey(cpf);
    }

}
