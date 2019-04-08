import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//https://www.mkyong.com/java/how-to-read-and-parse-csv-file-in-java/

/**
 * Author: Madeline LeClair
 * Last Updated: 4-7-19
 *
 * This program is intended to generate a list of team pairings
 * given a persons bowling average and list of friends.
 *
 */

public class Participant {

    //Input attributes
    int bowlerID;
    String firstName;
    String lastName;
    int bowlAvg;
    ArrayList<Participant> friends;

    //Information to be decided
    Participant partner;
    //int laneNum; //stretch goal

    //getter methods
    public int getBowlAvg() {
        return bowlAvg;
    }

    //setter methods
    public void setFirstName(String firstname) {
        this.firstName = firstname;
    }

    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    public void setBowlAvg(int bowlAvg) {
        this.bowlAvg = bowlAvg;
    }

    //constructor
    public Participant(String firstname, String lastname, int bowlAvg) {
        this.firstName = firstname;
        this.lastName = lastname;
        this.bowlAvg = bowlAvg;
    }

    /*Comparator for sorting the list by bowlAvg*/
    public static Comparator<Participant> partBowlAvg = new Comparator<Participant>() {

        public int compare(Participant s1, Participant s2) {

            int ba1 = s1.getBowlAvg();
            int ba2 = s2.getBowlAvg();

            /*For ascending order*/
            return ba1 - ba2;

            /*For descending order*/
            //rollno2-rollno1;
        }
    };

    @Override
    public String toString() {
        return "[ Name: " + firstName + " " + lastName + ", Average: " + bowlAvg + ", Partner: " + partner + "]";
    }

//}
    public static void main(String [] args){
        //List to store all Participants
        ArrayList<Participant> bowlers = new ArrayList<Participant>();

        Participant c = new Participant("jjj", "jjjj", 5);
        Participant n = new Participant("nnnn", "nnn", 6);
        Participant l = new Participant("mmmm", "jjjj", 200);
        Participant m = new Participant("nnmskdfmnn", "sd", 0);

        bowlers.add(c);
        bowlers.add(n);
        bowlers.add(l);
        bowlers.add(m);

        //For each bowler imported from spreadsheet
        //Create a Participant Object with listed characteristics
        //Load Participant Object into list

        //Logic for generating teams(pairs)

        //Sort by bowling average
        Collections.sort(bowlers, Participant.partBowlAvg);
            //add 5 points to pair in 2D table of poissible matchings?

        //Associate Participants with friends
            //2D table of friendships -- maybe remove from attributes
            //if [][] = 2, add 2 points to pair in 2D table of poissible matchings?

        for(Participant p: bowlers){
            System.out.println(p.toString());
        }

        //Print results in form of
            //Team No. , Participant 1 , Participant 2

    }
}