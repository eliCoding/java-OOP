
import java.*;

public class PrimeNum {

    public static void main(String[] args) {

        int i, candidate;
        int[] Array;            //declare an integer array
        Array = new int[100];      //size it up
        Array[0] = 1;
        candidate = 1;
        i = 1;
        boolean prime;
        do {

            for (i = 1; i < 100; i++) {
                candidate= candidate + 2;
                prime = true;
                if (candidate % Array[i] == 0) {
                    prime = false;
                }
                if (prime == true) {
                    //System.out.println("Candidate: " + candidate);
                    //System.out.println("Boolean: " + prime);
                    Array[i] = candidate; //at table position i store the value i                
                }

            }

            for (i = 1; i < 100; i++) {
                System.out.println(Array[i]);  //now print what is at table position i
            }
        } while (i <= 99);
    }
}
