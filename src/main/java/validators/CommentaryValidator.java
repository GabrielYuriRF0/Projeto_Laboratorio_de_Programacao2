package validators;

public class CommentaryValidator extends Validator {

    public boolean descriptionValidator(String description){
        super.validateAttribute(description);
        return true;
    }
}
