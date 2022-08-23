import com.sapo.person.Person;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class PersonTest extends BaseTest{
    @Test
    void testeCadastroPessoaValido(){
        var person = facade.getPerson(cpf1);
        assertEquals(cpf1, person.getCpf());
    }
    @Test
    void testeCadastraPessoaVálidaName(){
        facade.registerPerson(cpf1, "jubileu", skills1);
        var pessoa = facade.getPerson(cpf1);
        assertEquals("jubileu", pessoa.getName());
    }
    @Test
    void testeCadastraPessoaCpfInválidoVazio(){
        try{
            facade.registerPerson("", "Lucas", skills1);
        }catch (Exception e){
            assertEquals("Validation errors: [CPFError : INVALID DIGITS]", e.getMessage());
        }
    }

    @Test
    void testeCadastraPessoaCpfInválidoEspaco(){
        try{
            facade.registerPerson(" ", "Lucas", skills1);
        }catch (Exception e){
            assertEquals("Validation errors: [CPFError : INVALID DIGITS]", e.getMessage());
        }
    }

    @Test
    void testeCadastraPessoaCpfInválidoNull(){
        try{
            facade.registerPerson(null, "Lucas", skills1);
        }catch (Exception e){
            assertEquals("Validation errors: [CPFError : INVALID DIGITS]", e.getMessage());
        }
    }

    @Test
    void testeCadastraPessoaNomeInválidoVazio(){
        try{
            facade.registerPerson(cpf1, "", skills1);
        }catch (IllegalArgumentException e) {
            assertEquals("Empty or null attribute!", e.getMessage());
        }
    }

    @Test
    void testeCadastraPessoaNomeInválidoEspaco(){
        try{
            facade.registerPerson(cpf1, " ", skills1);
        }catch (IllegalArgumentException e) {
            assertEquals("Empty or null attribute!", e.getMessage());
        }
    }
    @Test
    void testeCadastraPessoaNomeInválidoNull(){
        try{
            facade.registerPerson(cpf1, null, skills1);
        }catch (Exception e) {
            assertEquals("Null", e.getMessage());
        }
    }
    @Test
    void testeCadastraPessoaSkillsInválidas(){
        String[] skill = null;
        try{
            facade.registerPerson(cpf1, "jubileu", skills1);
        }catch (IllegalArgumentException e){
            assertEquals("Empty or null attribute!", e.getMessage());
        }

    }

    @Test
    void removePerson(){

    }

}