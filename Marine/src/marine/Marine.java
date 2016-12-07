/*
Create project Marine in it define

class Boat {
	String name;
	double grossWeight;
	double length;
	int masts;
}

Define:
- constructor
- toString appropriate to the rest of the task
- NO getters or setters, or input verification

Read data from file, assume data is all valid:

Ocean Breeze III;2373.5;11.3;2
Magic Beyond;4532.1;27.2;3
Adventurer 2;789.5;7.3;1


(add at least 4 more, so you have 7 lines at least)

Read all data into 

static ArrayList<Boat> boatList = new ArrayList<>();

In your main program:

1. Read in data from file
2. Print all data in natural order by name
3. Print all data in order by length
4. Print all data in order by masts
5. Print all data in order by masts and grossWeight

Use Comparable interface for natural order,
and for other sorts use one Comparator class for each.

 */
package marine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Boat implements Comparable<Boat> {

    String name;
    double grossWeight;
    double length;
    int masts;

    public Boat(String name, double grossWeight, double length, int masts) {
        this.name = name;
        this.grossWeight = grossWeight;
        this.length = length;
        this.masts = masts;
    }

    @Override
    public String toString() {
        return "the " + name + ",Gsross weight is " + grossWeight + ",length is " + length + " the masts : " + masts;

    }

    @Override
    public int compareTo(Boat o) {
        if (this.length == o.length) {
            return 0;

        }
        if (this.length > o.length) {
            return -1;

        } else {
            return 1;
        }
    }
}

class SortBoatsByMasts implements Comparator<Boat> {

    @Override
    public int compare(Boat o1, Boat o2) {
        if (o1.masts == o2.masts) {
            return 0;
        }
        if (o1.masts > o2.masts) {

            return 1;
        } else {
            return -1;
        }
    }

}

class SortBoatsByMastsAndGrossWeight implements Comparator<Boat> {

    @Override
    public int compare(Boat o1, Boat o2) {
        if (o1.masts == o2.masts || o1.grossWeight == o1.grossWeight) {
            return 0;
        }
        if (o1.masts > o2.masts || o1.grossWeight > o1.grossWeight) {

            return -1;
        } else {
            return 1;
        }

    }

}

public class Marine {

    static final String FILE_NAME = "input.txt";
    static ArrayList<Boat> boatList = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        readFile();
        // addList();

    }

    public static void readFile() {

        try {
            Scanner fileInput = new Scanner(new File(FILE_NAME));
            while (fileInput.hasNextLine()) {
                String fileLine = null;
                try {
                    fileLine = fileInput.nextLine();

                    String data[] = fileLine.split(";");
                    if (data.length != 4) {
                        throw new IllegalArgumentException("Line malformed: " + fileLine);
                    }

                    String name = data[0];
                    double grossWeight = Double.parseDouble(data[1]);
                    double length = Double.parseDouble(data[2]);
                    int masts = Integer.parseInt(data[3]);

                    boatList.add(new Boat(name, grossWeight, length, masts));
                } catch (IllegalArgumentException e) {
                    System.err.println("Skipping invalid input line: " + fileLine + e.getMessage());
                }
            }
            fileInput.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found exception " + ex);
        }
        System.out.println("==================== Original order ==================================\n");
        for (Boat b : boatList) {
            System.out.println(b);
        }
        Collections.sort(boatList);
        System.out.println("=========================lenght order ================================\n");
        for (Boat b : boatList) {
            System.out.println(b);
        }
        Collections.sort(boatList, new SortBoatsByMasts());
        System.out.println("================= Sort Boats By Masts ==================================\n");
        for (Boat b : boatList) {
            System.out.println(b);
        }
        Collections.sort(boatList, new SortBoatsByMastsAndGrossWeight());
        System.out.println("================ Sort Boats By Masts ==================================\n");
        for (Boat b : boatList) {
            System.out.println(b);
        }

    }

    public static void addList() {

        try {
            System.out.print("enter a name:");
            String name = input.nextLine();
            System.out.print("enter an Gross Weight:");
            double grossWeight = input.nextDouble();
            //input.nextLine();
            System.out.print("enter a length:");
            double length = input.nextDouble();
            System.out.println("enter the masts");
            int masts = input.nextInt();
            PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME, true));
            pw.println(name + ";" + grossWeight + ";" + length + ";" + masts);
            pw.close();
        } catch (IOException ex) {
            System.out.println("error " + ex.getMessage());

        }
    }

}
