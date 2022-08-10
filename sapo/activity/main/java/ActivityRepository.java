import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ActivityRepository {
    List<Activity> activities;

    public ActivityRepository(){
         this.activities = new ArrayList<>();
    }
    public void adiciona(Activity a){
       this.activities.add(a);
        a.setID(gerarID(a));
    }

    public String gerarID(Activity a){
        StringBuilder consoantes = new StringBuilder();
        StringBuilder id = new StringBuilder();
        List<Character> vogaisENumeros = new ArrayList<>(Arrays.asList('a','A','e','E','i','I','o','O','u','U',' ',
                '0','1','2','3','4','5','6','7','8','9'));

        //transformar String em um array de Char
        char[] letters = a.getName().toCharArray();

        //tirando vogais e espaços vazios e transformando para maiusculo
        for (int i = 0; i < letters.length;i++) {
            if (vogaisENumeros.contains(letters[i]) ) {
                    consoantes.append(Character.toString(i).toUpperCase());
            };
        }

        if(consoantes.length() < 3){
            for(int i = 0; i < consoantes.length();i++){
                id.append(consoantes.charAt(i));
            }
            while(id.length() <= 4){
                id.append("X");
            }
        }else{
            for(int i = 0; i < 3; i++){
                id.append(consoantes.charAt(i));
            }
        }

        id.append("-");
        id.append(Integer.toString(activities.indexOf(a)));

        return id.toString();
    }
}
