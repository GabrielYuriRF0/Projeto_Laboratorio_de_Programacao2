import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ActivityRepository {
    List<Activity> activities;

    public ActivityRepository(){
         this.activities = new ArrayList<>();
    }
    public void add(Activity a){
       this.activities.add(a);
        a.setID(generateID(a));
    }

    public String generateID(Activity a){
        StringBuilder consonants = new StringBuilder();
        StringBuilder id = new StringBuilder();
        List<Character> vogaisENumeros = new ArrayList<>(Arrays.asList('a','A','e','E','i','I','o','O','u','U',' ',
                '0','1','2','3','4','5','6','7','8','9'));

        //transformar String em um array de Char
        char[] letters = a.getName().toCharArray();

        //tirando vogais e espaços vazios e transformando para maiusculo
        for (int i = 0; i < letters.length;i++) {
            if (!vogaisENumeros.contains(letters[i]) ) {
                consonants.append(Character.toString(i).toUpperCase());
            };
        }

        if(consonants.length() < 3){
            for(int i = 0; i < consonants.length();i++){
                id.append(consonants.charAt(i));
            }
            while(id.length() < 4){
                id.append("X");
            }
        }else{
            for(int i = 0; i < 3; i++){
                id.append(consonants.charAt(i));
            }
        }

        id.append("-");
        id.append(Integer.toString(activities.indexOf(a)));

        return id.toString();
    }
}
