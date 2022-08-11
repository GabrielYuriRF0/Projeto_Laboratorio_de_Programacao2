package activity;

public class Activity {
    private String name;
    private String description;
    private String CPF;
    private String id;
    private int status;
    private String responsable;


    public Activity(String name, String description, String CPF){
        this.name = name;
        this.description = description;
        this.CPF = CPF;
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return id;
    }
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public void setID(String ID) {
        this.id = ID;
    }

    @Override
    public String toString() {
        return  id + ": " + name + "\n" +
                "Résponsável: " + responsable + " - " + CPF + "\n" +
                "===\n" +
                description + "\n" +
                "===\n";
    }
}
