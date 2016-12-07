/*
Create project TempWorkers

class Worker {	
	String name;
	Date startDate;
	Date endDate;
	int getId(); // returns unique consecutive Id
}

You will modify Worker class:
- add constructor with 3 parameters
- using static implement getId() method
- encapsulate fields and verify in setters that:
a) name is not empty
b) start date is not after end date
In case of violation of requirements throw
a checked exception InvalidDataProvidedException()

input.txt file contents

Jerry;2016/02/15;2016/04/15
Macy;2016/03/22;2016/05/28
Timmy;2016/06/08;2016/07/10
Manny;2016/08/01;2016/12/10

You will read in data line by line, instantiate objects type Worker() and add them to

static ArrayList<Worker> personel = new ArrayList<>();

You will implement the following menu interactions:

1. List all personel
2. Find out who works on a specific date
3. Ask for a year number and print out all dates
in that year that nobody is scheduled to work on
4. Add worker
5. Delete worker by Id
0. Exit

Output of option 1. List all personel

1: Jerry works from 15 Feb 2016 to 15 April 2016
2: Macy works from March 22, 2016 to 28 May 2016
... and so on...

On exit you save data back to the file.

BONUS***:
In 3. instead of showing all dates when nobody works
display RANGES from-to date when nobody works.

 */
//@author Elmira
package tempworkers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

class Worker {

    String name;
    Date startDate;
    Date endDate;

    public Worker(String name, Date startDate, Date endDate) throws InvalidDataProvidedException {
        setName(name);
        setStartDate(startDate);
        setEndDate(endDate);
    }

    public static int getId() // returns unique consecutive Id
    {
        int count = 0;
        int uniqeId;
        count++;

        return uniqeId = count;

    }

    public String getName() {
        return name;
    }
//name is not empty

    public void setName(String name) {
        if (name.equals("") || name.length() < 1) {
            throw new IllegalArgumentException("name can not be empty");
        }
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }
//start date is not after end date

    public void setStartDate(Date startDate) throws InvalidDataProvidedException {
        // if (startDate.after(endDate)) {
        //   throw new InvalidDataProvidedException("star date can't be after end date!");

        // }
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    static class InvalidDataProvidedException extends Exception {

        public InvalidDataProvidedException(String message) {
            super(message);
        }
    }

    //Manny;2016/08/01;2016/12/10
}

public class TempWorkers {

    static DateFormat df = new SimpleDateFormat("yyyy/mm/dd");
    static ArrayList<Worker> personel = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws ParseException {
        System.out.println("List all personel\n"
                + "2. Find out who works on a specific date\n"
                + "3. Ask for a year number and print out all dates\n"
                + "in that year that nobody is scheduled to work on\n"
                + "4. Add worker\n"
                + "5. Delete worker by Id\n"
                + "0. Exit");
        System.out.println("Enter choice:");
        int choice = input.nextInt();
        switch (choice) {
            case 1: {
                try {
                    System.out.println("The Employee name,Start Date and Finish date are:\n ");
                    readFile();
                } catch (Worker.InvalidDataProvidedException ex) {
                    System.out.println("error" + ex);
                }
            }
            break;

            case 2:
                whoWorks();
                break;
            case 3:
                yearNum();
                break;
            case 4:
                addWorkers();
                break;
            case 5:
                deleteWorker();
                break;
            case 0:
                System.out.println("Exit");
                break;
            default:
                System.out.println("error");
                System.exit(0);
        }

    }
//1: Jerry works from 15 Feb 2016 to 15 April 2016

    public static void readFile() throws ParseException, Worker.InvalidDataProvidedException {
        try {

            Scanner fileInput = new Scanner(new File("input.txt"));
            while (fileInput.hasNextLine()) {
                String line = fileInput.nextLine();
                String[] data = line.split(";");
                if (data.length != 3) {
                    throw new IllegalArgumentException("Line malformed: " + line);
                }
                String name = data[0];
                Date startDate = df.parse(data[1]);
                Date endDate = df.parse(data[2]);

                //  Worker w = new Worker (data[0],df.parse(data[1]),df.parse(data[2]));
                personel.add(new Worker(name, startDate, endDate));

                // personel.add(w);
                //  System.out.printf("%s;%s;%s\n", name, df.format(startDate), df.format(endDate));
                //  System.out.printf("%s;%s;%s\n", name, df.format(startDate), df.format(endDate));
            }
            fileInput.close();
        } catch (FileNotFoundException fn) {

            System.out.println("file not fount" + fn);
        }
        for (Worker a : personel) {
            System.out.println(a.getName() + " works from " + a.getStartDate() + " to " + a.getEndDate());

        }

    }

    private static void whoWorks() throws ParseException {
        try {
            Scanner fileInput = new Scanner(new File("input.txt"));
            System.out.println("Enter the Date: ");

            String workDate = input.next();
            while (fileInput.hasNextLine()) {

                String line = fileInput.nextLine();
                String[] data = line.split(";");
                if (data.length != 3) {
                    throw new IllegalArgumentException("Line malformed: " + line);
                }
                String name = data[0];
                Date startDate = df.parse(data[1]);
                Date endDate = df.parse(data[2]);

                System.out.println("==========================================================");
              //  if (contain(workDate, df.parse(data[1]), df.parse(data[2]))) {
                 //   for (Worker a : personel) {
                    //    System.out.println(a.getName() + " works from " + a.getStartDate() + " to " + a.getEndDate());

                   // }
                //}
            }
        } catch (FileNotFoundException fn) {

            System.out.println("file not fount" + fn);
        }

    }

    private static void yearNum() throws ParseException {
        /*    try {

            Scanner fileInput = new Scanner(new File("input.txt"));
            while (fileInput.hasNextLine()) {
                String line = fileInput.nextLine();
                String[] data = line.split(";");
                if (data.length != 3) {
                    throw new IllegalArgumentException("Line malformed: " + line);
                }
                String name = data[0];
                Date startDate = df.parse(data[1]);
                Date endDate = df.parse(data[2]);

                System.out.printf("%s;%s;%s\n", name, df.format(startDate), df.format(endDate));

            }
        } catch (FileNotFoundException fn) {

            System.out.println("file not fount" + fn);
        }*/
    }

    private static void addWorkers() throws ParseException {

        System.out.println("Adding a Worker.\n");

        System.out.print("Enter name: ");
        String name = input.nextLine();
        input.nextLine();
        System.out.print("Enter startDate: ");
        String startDate = input.next();
        System.out.print("Enter endDate: ");
        String endDate = input.next();

        //
        try {
            PrintWriter pw = new PrintWriter(new FileWriter("input.txt", true));
            Date date = new Date();
            pw.printf("%s;%s;%s\n", name, date.toString(), date.toString());

            pw.close();
            //
            System.out.println("Worker added.");
        } catch (IOException ioe) {

            System.out.println("Error writing to file. Person not added.");
        }
    }

    private static void deleteWorker() throws ParseException {
        try {

            Scanner fileInput = new Scanner(new File("input.txt"));
            while (fileInput.hasNextLine()) {
                String line = fileInput.nextLine();
                String[] data = line.split(";");
                if (data.length != 3) {
                    throw new IllegalArgumentException("Line malformed: " + line);
                }
                String name = data[0];
                Date startDate = df.parse(data[1]);
                Date endDate = df.parse(data[2]);

                System.out.printf("%s;%s;%s\n", name, df.format(startDate), df.format(endDate));

            }
        } catch (FileNotFoundException fn) {

            System.out.println("file not fount" + fn);
        }
    }

   

}
