package Activities;

public class Activity {
    private String name;
    private String description;
    private String CPF;
    private String ID;
    private int status;


    public Activity(String nome, String descricao, String CPF){
        this.name = nome;
        this.description = descricao;
        this.CPF = CPF;
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
        this.ID = ID;
    }


}
