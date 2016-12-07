package soccorranking;

//* @author Elmira
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Team implements Comparable<Team> {

    String title;
    int matchesWon;
    int matchesLost;

    public Team(String title, int matchesWon, int matchesLost) {
        this.title = title;
        this.matchesWon = matchesWon;
        this.matchesLost = matchesLost;
    }

    @Override
    public String toString() {

        double perce = (double) matchesWon / (matchesWon + matchesLost) * 100;
        return "The " + title + " team ; won: " + matchesWon + "; lost: " + matchesLost + ";Percentage Won is: " + "%"+perce;
    }

    @Override
    public int compareTo(Team o) {
        //return this.matchesWon - o.matchesWon;  when they are integer this is the simple way!!!
        //we can have some aditional factors!!
        if (this.matchesWon == o.matchesWon) {
            return 0;  //same

        }
        if (this.matchesWon > o.matchesWon) {
            return 1;
        } else {
            return -1;
        }
    }

}

class SortTeamsByName implements Comparator<Team> {

    @Override
    public int compare(Team o1, Team o2) {
        return o1.title.compareTo(o2.title);

    }

}

class SortByPercentageGameWon implements Comparator<Team> {

    @Override
    public int compare(Team o1, Team o2) {
        double perc1 =(double) o1.matchesWon / (o1.matchesWon + o1.matchesLost);
        double perc2 = (double)o2.matchesWon / (o2.matchesWon + o2.matchesLost);
        if (perc1 == perc2) {
            return 0;
        }
        if (perc1 > perc2) {
            //if -1 come at first they are gonna sort in from hight to low
            return -1; 
        } else {
            return 1;
        }

    }

}

public class SoccorRanking {

    static ArrayList<Team> teamList = new ArrayList<>();
    static final String FILE_NAME = "input.txt";

    public static void main(String[] args) {
        readFile();

    }

    public static void readFile() {

        try {
            Scanner fileInput = new Scanner(new File(FILE_NAME));
            while (fileInput.hasNextLine()) {
                String fileLine = null;
                try {
                    fileLine = fileInput.nextLine();

                    String data[] = fileLine.split(";");
                    if (data.length != 3) {
                        throw new IllegalArgumentException("Line malformed: " + fileLine);
                    }

                    String city = data[0];
                    int matchesWon = Integer.parseInt(data[1]);
                    int matchesLost = Integer.parseInt(data[2]);

                    teamList.add(new Team(city, matchesWon, matchesLost));
                } catch (IllegalArgumentException e) {
                    System.err.println("Skipping invalid input line: " + fileLine + e.getMessage());
                }
            }
            fileInput.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found exception " + ex);
        }
        System.out.println("=========== Original order ==================");
        for (Team t : teamList) {
            System.out.println(t);
        }
        Collections.sort(teamList);
        System.out.println("============= by Games Won order =================");
        for (Team o : teamList) {

            System.out.println(o);
        }
        Collections.sort(teamList, new SortTeamsByName());
        System.out.println("============= by Names order ====================");
        for (Team o : teamList) {

            System.out.println(o);
        }
         Collections.sort(teamList, new SortByPercentageGameWon());
        System.out.println("============= by Percentage Game Won ====================");
        for (Team o : teamList) {

            System.out.println(o);
        }
    }
}
