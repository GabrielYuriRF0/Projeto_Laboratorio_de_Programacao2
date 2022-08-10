import java.util.Date;

public class Commentary {
    private String author;
    private String description;
    private final Date CURRENTDATE = new Date();

    public Commentary(String author, String description){
        this.author = author;
        this.description = description;
    }

}
