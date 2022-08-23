import com.sapo.person.Person;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonTest extends BaseTest{
    @Test
    void testValidRegisterPerson(){
        var person = facade.getPerson(cpf1);
        assertEquals(cpf1, person.getCpf());
    }
    @Test
    void testRegisterPersonValidName(){
        facade.registerPerson(cpf1, "jubileu", skills1);
        var pessoa = facade.getPerson(cpf1);
        assertEquals("jubileu", pessoa.getName());
    }
    @Test
    void testRegisterPersonInvalidCpfVoid(){
        try{
            facade.registerPerson("", "Lucas", skills1);
        }catch (Exception e){
            assertEquals("Validation errors: [CPFError : INVALID DIGITS]", e.getMessage());
        }
    }

    @Test
    void testRegisterPersonInvalidCpfSpace(){
        try{
            facade.registerPerson(" ", "Lucas", skills1);
        }catch (Exception e){
            assertEquals("Validation errors: [CPFError : INVALID DIGITS]", e.getMessage());
        }
    }

    @Test
    void testRegisterPersonInvalidCpfNull(){
        try{
            facade.registerPerson(null, "Lucas", skills1);
        }catch (Exception e){
            assertEquals("Validation errors: [CPFError : INVALID DIGITS]", e.getMessage());
        }
    }

    @Test
    void testRegisterPersonInvalidNameVoid(){
        try{
            facade.registerPerson(cpf1, "", skills1);
        }catch (IllegalArgumentException e) {
            assertEquals("Empty or null attribute!", e.getMessage());
        }
    }

    @Test
    void testRegisterPersonInvalidNameSpace(){
        try{
            facade.registerPerson(cpf1, " ", skills1);
        }catch (IllegalArgumentException e) {
            assertEquals("Empty or null attribute!", e.getMessage());
        }
    }
    @Test
    void testRegisterPersonInvalidNameNull(){
        try{
            facade.registerPerson(cpf1, null, skills1);
        }catch (Exception e) {
            assertEquals("Null", e.getMessage());
        }
    }
    @Test
    void testRegisterPersonInvalidSkills(){
        String[] skill = null;
        try{
            facade.registerPerson(cpf1, "jubileu", skills1);
        }catch (IllegalArgumentException e){
            assertEquals("Empty or null attribute!", e.getMessage());
        }

    }

    @Test
    void testRemovePerson(){
        facade.removePerson(cpf1);
        try{
            facade.getPerson(cpf1);
        }catch(NoSuchElementException e){
            assertEquals("This cpf is not registered in the system!", e.getMessage());
        }
    }

    @Test
    void testRemovePersonInvalidCpf(){
        try{
            facade.removePerson("111.111.111-11");
        }catch(Exception e){
            assertEquals("Validation errors: [CPFError : REPEATED DIGITS]", e.getMessage());
        }
    }

    @Test
    void testRemovePersonValidCpfButNotRegistered(){
        try{
            facade.removePerson("876.178.004-95");
        }catch(NoSuchElementException e){
            assertEquals("This cpf is not registered in the system!", e.getMessage());
        }
    }

    @Test
    void testShowPerson(){
        String show = facade.showPerson(cpf1);
        var pessoa = facade.getPerson(cpf1);
        String show1 = pessoa.toString();
        System.out.println(show1);
        assertEquals(show1, show);
    }

    @Test
    void testValidSetPersonName(){
        facade.setPersonName(cpf1, "Luxuria");
        var person = facade.getPerson(cpf1);
        String name = person.getName();
        assertEquals("Luxuria", name);
    }

    @Test
    void testInvalidSetPersonName(){
        try{
            facade.setPersonName(cpf1, "");
        }catch (IllegalArgumentException e){
            assertEquals("Empty or null attribute!", e.getMessage());
        }
    }

    @Test
    void testSetPersonNameInvalidSpace(){
        try{
            facade.setPersonName(cpf1, " ");
        }catch (IllegalArgumentException e){
            assertEquals("Empty or null attribute!", e.getMessage());
        }
    }
    @Test
    void testInvalidSetPersonNameNull(){
        try{
            facade.setPersonName(cpf1, null);
        }catch (IllegalArgumentException e){
            assertEquals("Null", e.getMessage());
        }
    }

    @Test
    void testValidSetPersonSkills(){
        facade.setPersonSkills(cpf1,skills2);
        var pessoa = facade.getPerson(cpf1);
        assertEquals(skills2,pessoa.getSkills());
    }

    @Test
    void testInvalidSetPersonSkills(){
        try{
            facade.setPersonSkills(cpf1,null);
        }catch (IllegalArgumentException e){
            assertEquals("Empty or null attribute!", e.getMessage());
        }
    }

    @Test
    void testValidGetPersonName(){
        String name = facade.getPersonName(cpf1);
        assertEquals(name1, name);
    }

    @Test
    void testInvalidGetPersonName(){
        try{
            String name = facade.getPersonName("876.178.004-95");
        } catch(NoSuchElementException e){
            assertEquals("This cpf is not registered in the system!", e.getMessage());
        }
    }
}