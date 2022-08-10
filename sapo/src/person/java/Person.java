import java.util.ArrayList;

public class Person{
    private String cpf;
    private String name;
    private String[] skills;
    private ArrayList<Commentary> comments = new ArrayList<Commentary>() ;

    public Person(String cpf, String name, String[] skills){
        this.cpf = cpf;
        this.name = name;
        this.skills = skills;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public void setSkills(String[] newSkills){
        this.skills = newSkills;
    }

    public void addCommentary(Commentary commentary){
        this.comments.add(commentary);
    }

    //FIXME implements toString after
    @Override
    public String toString(){
        return "";
    }

}