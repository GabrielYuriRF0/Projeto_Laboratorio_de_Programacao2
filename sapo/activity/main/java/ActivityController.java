public class ActivityController {
    private ActivityService as;
    private ActivityValidator validator;

    public String addActivity(String name, String description, String CPF){
        this.validator.validator(name, description, CPF);
        return this.as.addActivity(new Activity(name, description, CPF));
    }

    public void endActivity(String ID){
        this.as.endActivity(ID);
    }

    public void disableActivity(String ID){
        this.as.disableActivity(ID);
    }

    public void reopenActivity(String ID){
        this.as.reopenActivity(ID);
    }

    public String displayActivity(String ID){
        return this.as.displayActivity(ID);
    }

    public void changeActivityDescription(String ID, String descricao){
        this.as.changeActivityDescription(ID, descricao);
    }

    public void changeActivityResponsable(String ID, String CPF){
        this.as.changeActivityResponsable(ID, CPF);
    }
}
