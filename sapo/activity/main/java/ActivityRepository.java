import java.util.ArrayList;
import java.util.List;

public class ActivityRepository {
    List<Activity> activities = new ArrayList<>();

    public void adiciona(Activity a){
       this.activities.add(a);
    }
}
