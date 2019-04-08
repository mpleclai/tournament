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
    public Participant(int bowlerID, String firstname, String lastname, int bowlAvg) {
       this.bowlerID = bowlerID;
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

    /**
     * This method fills an ArrayList of Participants with information input by a csv file.
     *
     *         //For each bowler imported from spreadsheet
     *         //Create a Participant Object with listed characteristics
     *         //Load Participant Object into list
     *
     **/
    public ArrayList<Participant> createParticipantList(ArrayList<Participant> bowlers, String csvFile, String line, String cvsSplitBy) {

        try(BufferedReader br = new BufferedReader(new FileReader(csvFile))){

            String [] input = null;
            String fn = null;
            String ln = null;
            int ba = 0;

            int i = 0;
            while ((line = br.readLine()) != null){
                // use comma as seperator

                //get input
                input = line.split(cvsSplitBy);
                System.out.println(Arrays.toString(input));

                //get first name
                fn = input[0];

                //get last name
                ln = input[1];

                //get avg
                ba = Integer.parseInt(input[2]);

                System.out.println("id: " + i + ", FN: " +  fn + ", LN: " + ln + ", Avg: " + ba);
                Participant p = new Participant(i, fn, ln, ba);
                bowlers.add(p);

                i++;

            }

        } catch(IOException e){
            e.printStackTrace();
        }

        return bowlers;
    }

    public static void main(String [] args){
        //List to store all Participants
        ArrayList<Participant> bowlers = new ArrayList<Participant>();

        Participant s = new Participant(999,"instance", "instance", 999);

        String csvFile="bowlers-list.csv";
        String line = "";
        String cvsSplitBy = ",";

        s.createParticipantList(bowlers, csvFile, line, cvsSplitBy);

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