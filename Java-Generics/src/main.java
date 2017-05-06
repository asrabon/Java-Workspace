import java.util.ArrayList;

/**
 * Created by asrab on 5/3/2017.
 */
public class main {

    public static void main(String[] args) {
//        ArrayList<Integer> items = new ArrayList<>();
//        items.add(1);
//        items.add(2);
//        items.add(3);
//        items.add(4);
//        items.add(5);
//
//        printDoubled(items);
        FootballPlayer joe = new FootballPlayer("Joe");
        BaseballPlayer pat = new BaseballPlayer("Pat");
        SoccerPlayer beckham = new SoccerPlayer("Beckham");

        Team<FootballPlayer> ravens = new Team<>("Ravens");
        ravens.addPlayer(joe);
//        ravens.addPlayer(pat);
//        ravens.addPlayer(beckham);

        System.out.println(ravens.numPlayers());

        Team<BaseballPlayer> baseballTeam = new Team<>("Chicago Cubs");
        baseballTeam.addPlayer(pat);

        Team<FootballPlayer> melbourne = new Team<>("Melbourne");
        FootballPlayer banks = new FootballPlayer("Gordon");
        melbourne.addPlayer(banks);

        Team<FootballPlayer> hawthorne = new Team<>("Hawthorne");
        Team<FootballPlayer> freemantle = new Team<>("Freemantle");

        League<Team<FootballPlayer>> footballLeague = new League<>("United Kingdom Football League");
        footballLeague.addTeam(ravens);
        footballLeague.addTeam(melbourne);
        footballLeague.addTeam(hawthorne);
        footballLeague.addTeam(freemantle);

        hawthorne.matchResult(freemantle, 1, 0);
        hawthorne.matchResult(ravens, 3, 8);
        ravens.matchResult(freemantle, 2, 1);
//        ravens.matchResult(baseballTeam, 1, 1);

//        System.out.println("Rankings:");
//        System.out.println(ravens.getName() + ": " + ravens.ranking());
//        System.out.println(freemantle.getName() + ": " + freemantle.ranking());
//
//        System.out.println(ravens.compareTo(freemantle));
        footballLeague.sortTeams();
        System.out.println(footballLeague);
    }

    private static void printDoubled(ArrayList<Integer> a) {
        for(int x : a) {
            System.out.println(x * 2);
        }
    }

}
