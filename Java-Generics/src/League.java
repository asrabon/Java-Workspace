import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by asrab on 5/4/2017.
 */
public class League<T extends Team>{
    private String name;
    private ArrayList<T> teams = new ArrayList<>();

    public League(String name) {
        this.name = name;
    }

    public boolean addTeam(T team) {
        if(teams.contains(team)) {
            System.out.println(team.getName() + " is already in the " + this.getName() + " league.");
            return false;
        } else {
            teams.add(team);
            System.out.println(team.getName() + " has been added to the " + this.getName() + " league.");
            return true;
        }
    }

    public String getName() {
        return name;
    }

    public void sortTeams() {
        Collections.sort(teams);
        System.out.println("The teams have been sorted.");
    }

    public String toString() {
        String result = this.getName() + "\n";
        for(int i=0; i<teams.size(); i++) {
            result += i + ":\t" + teams.get(i).getName() + "\n";
        }
        return result;
    }
}
