import br.com.caelum.stella.validation.CPFValidator;

public class PersonValidator extends Validator {

    public boolean nameValidator(String name){
        super.validateAttribute(name);
        return true;
    }

    public boolean skillsValidator(String[] skills){
        return skills != null;
    }

    public boolean cpfValidator(String cpf){
        CPFValidator cpfValidator = new CPFValidator();

        try{ cpfValidator.assertValid(cpf);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
