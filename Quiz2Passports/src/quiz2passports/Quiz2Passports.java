/*
class Passport {
String number; // passport number AB123456 format
String firstName, lastName, address, city; // at least 2 letters each
double heightCm, weightKg; // height from 0-300, weight 0-300
int yob; // year of birth - between 1900-2050
}

Encapsulate fields. Create getters, setters that verify field values that throw IllegalArgumentException with message explaining
Add constructor that initializes all the fields, with verification.

Data will be stored in "passports.txt" file in format:

AB112233;Jerry;Toes;1234 Some St;Montreal;175.5;89.1;1972

You should create the file using Notepad and add at least 3 more lines to it.

In main class you will add

static ArrayList<Passport> passList = new ArrayList<>();

When the program starts you will load the contents of "passports.txt" file, instantiate one Passport object for every line, and add to passList.

If there is a problem with contents of a line - display an error message and continue program execution reading the next available line. In other words - ignore problem lines and continue the program.

Menu of options to implement:

1. Display all passports data (one per line)
2. Display all passports for people in the same city (ask for city name)
3. Find the tallest person and display their info
4. Find the lightest person and display their info
5. Display all people younger than certain age (ask for max age, not year)
6. Add person to list (in memory only)
0. Save data back to file and exit.


NOTES:
* Make sure you handle IOException, IllegalArgumentException, InputMismatchException as needed.
* Only use System.out, do NOT use System.err, not even for errors.

WHAT TO SUBMIT:
* All your code must be in a single Quiz2Passports.java file.
That is the only file you will submit.


 */
package quiz2passports;

import static com.sun.javafx.util.Utils.contains;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Passport {

    private String number; // passport number AB123456 format
    private String firstName; // year of birth - between 1900-2050
    private String lastName;
    private String address;
    private String city;
    private double heightCm;
    private double weightKg;
    private int yob;

    public Passport(String number, String firstName, String lastName, String address, String city, double heightCm, double weightKg, int yob) {
        setNumber(number);
        setFirstName(firstName);
        setLastName(lastName);
        setAddress(address);
        setCity(city);
        setHeightCm(heightCm);
        setWeightKg(weightKg);
        setYob(yob);

    }

    private Passport(String number, String name, String lastName, String address, String city, String heightCm, String weightKg, String yob) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNumber() {
        return number;
    }

    // passport number AB123456 format   !!!!
    public void setNumber(String number) {
        if (!number.matches("[A-Z]{2}[1-9]{6}")) {
            throw new IllegalArgumentException("two uppercase letter and 6 numbers please");
        }
        this.number = number;
    }

    public String getFirstName() {
        return firstName;
    }
    //at least 2 letters each

    public void setFirstName(String firstName) {
        if (firstName.length() != 2) {
            throw new IllegalArgumentException("at lease enter 2 letter.");
        }
        this.firstName = firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.length() != 2) {
            throw new IllegalArgumentException("at lease enter 2 letter.");
        }
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address.length() != 2) {
            throw new IllegalArgumentException("at lease enter 2 letter.");
        }
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        if (city.length() < 2) {
            throw new IllegalArgumentException("at lease enter 2 letter.");
        }
        this.city = city;
    }

    public double getHeightCm() {
        return heightCm;
    }

    // height from 0-300, weight 0-300
    public void setHeightCm(double heightCm) {
        if (heightCm < 0 || heightCm > 300) {
            throw new IllegalArgumentException("height must be between 0 - 300" + heightCm);
        }
        this.heightCm = heightCm;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(double weightKg) {
        if (weightKg < 0 || weightKg > 300) {
            throw new IllegalArgumentException("Weight must be between 0 - 300" + weightKg);
        }
        this.weightKg = weightKg;
    }

    public int getYob() {
        return yob;
    }

    // year of birth - between 1900-2050
    public void setYob(int yob) {
        if (yob < 1900 || yob > 2050) {
            throw new IllegalArgumentException(" year of birth must be between 0 - 300" + yob);
        }

        this.yob = yob;
    }
    //AB112233;Jerry;Toes;1234 Some St;Montreal;175.5;89.1;1972
}

public class Quiz2Passports {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Passport> passportList = new ArrayList<>();
    static final String FILE_NAME = "passports.txt";

    static void addPassportList() {

        try {
            System.out.print("Enter passport Number code: ");
            String number = input.nextLine();
            System.out.print("Enter fisrt Name: ");
            String firstName = input.nextLine();
            System.out.print("Enter Lastname: ");
            String lastName = input.nextLine();

            System.out.print("Enter address: ");
            String address = input.nextLine();
            System.out.print("Enter city: ");
            String city = input.nextLine();
            System.out.print("Enter hieght: ");

            double hieght = input.nextDouble();
            System.out.print("Enter weight: ");
            double weight = input.nextDouble();
            System.out.print("Enter yob: ");
            int yob = input.nextInt();

            Passport a = new Passport(number, firstName, lastName, address, city, hieght, weight, yob);
            passportList.add(a);
        } catch (InputMismatchException | IllegalArgumentException e) {
            System.err.println("Error creating list: " + e.getMessage());
        }

    }

    static void showAllAirportsToFile() {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME));
            for (Passport a : passportList) {
                pw.printf("%s;%s;%s;%s;%s;%d;%d;%d\n", a.getNumber(), a.getFirstName(),
                        a.getLastName(), a.getAddress(), a.getCity(), a.getAddress(), a.getHeightCm(), a.getWeightKg(), a.getYob());
            }
            pw.close();
        } catch (IOException e) {
            System.err.println("Error saving to file");

        }
    }

    static void readPassports() throws FileNotFoundException {
        Scanner fileInput = new Scanner(new File(FILE_NAME));
        while (fileInput.hasNextLine()) {
            String fileLine = null;
            try {
                fileLine = fileInput.nextLine();

                String data[] = fileLine.split(";");
                if (data.length != 8) {
                    throw new IllegalArgumentException("Line malformed: " + fileLine);
                }
                String number = data[0];
                String firstName = data[1];
                String lastName = data[2];
                String address = data[3];
                String city = data[4];
                double hieght = Double.parseDouble(data[5]);
                double weight = Double.parseDouble(data[6]);
               int yob = Integer.parseInt(data[07]);

                passportList.add(new Passport(number, firstName, lastName, address, city, hieght, weight, (int) yob));
            } catch (IllegalArgumentException e) {
                System.err.println("Skipping invalid input line: " + fileLine);
            }
        }
        fileInput.close();
    }

    static int getMenuChoice() {
        while (true) {
            System.out.println("1. Display all passports data (one per line)\n"
                    + "2. Display all passports for people in the same city (ask for city name)\n"
                    + "3. Find the tallest person and display their info\n"
                    + "4. Find the lightest person and display their info\n"
                    + "5. Display all people younger than certain age (ask for max age, not year)\n"
                    + "6. Add person to list (in memory only)\n"
                    + "0. Save data back to file and exit.");
            System.out.print("Enter choice [0-6]: ");
            try {
                int choice = input.nextInt();
                input.nextLine();
                if (choice < 0 || choice > 6) {
                    System.out.println("Invalid choice, try again");
                } else {
                    return choice;
                }
            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.println("Invalid choice, try again");
            }
        }

    }

    public static void main(String[] args) {
        try {
            addPassportList();
            showAllAirportsToFile();
            while (true) {
                int choice = getMenuChoice();
                switch (choice) {
                    case 0:
                        System.out.println("Bye bye");
                        return;
                    case 1:
                        readPassports();
                        break;
                    case 2:
                        allPeopleInSameCity();
                        break;
                    case 3:
                        findTheTallestPerson();
                        break;
                    case 4:
                        findTheLightestPerson();
                        break;
                    case 5:
                        allPeopleYoungerThanAge();
                        break;
                    case 6:
                        addPersonToList();
                        break;

                    default:
                        System.out.println("Internal fatal error. Terminating.");
                        System.exit(1);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.err.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void allPeopleInSameCity() {
        try {
            File file = new File(FILE_NAME);
            if (file.exists()) {
                Scanner fileInput = new Scanner(file);
                System.out.println("Please enter the city name: ");
                String s = input.nextLine();
                while (fileInput.hasNextLine()) {
                    String cityName = fileInput.nextLine();

                    fileInput.nextLine();
                    String city = fileInput.nextLine();
                    if (contains(cityName, s)) {
                        System.out.printf("%s is %d from %s\n", cityName, s);
                    }
                }
                fileInput.close();
            } else {
                System.out.println("File does not exist");
            }
        } catch (IOException ex) {
            System.out.println("Error reading file");
        }
    }

    private static void findTheTallestPerson() {
        try {
            File file = new File(FILE_NAME);
            if (file.exists()) {
                Scanner fileInput = new Scanner(file);
                System.out.println("Please enter height: ");
                int a = input.nextInt();
                while (fileInput.hasNextLine()) {
                    /* String number = data[0];
                String firstName = data[1];
                String lastName = data[2];
                String address = data[3];
                String city = data[4];
                double hieght = Double.parseDouble(data[5]);
                double weight = Double.parseDouble(data[6]);
               int yob = int.parseInt(data[7]);

                passportList.add(new Passport(number,firstName,lastName,address, city,hieght,weight,yob));*/

                    double height = fileInput.nextDouble();
                    fileInput.nextLine();
                    String city = fileInput.nextLine();
                    if (height > a) {
                        System.out.printf("%s is %d from %s\n", height, a);
                    }
                }
                fileInput.close();
            } else {
                System.out.println("File does not exist");
            }
        } catch (IOException ex) {
            System.out.println("Error reading file");
        }
    }

    private static void findTheLightestPerson() {

    }

    private static void allPeopleYoungerThanAge() {
        try {
            File file = new File(FILE_NAME);
            if (file.exists()) {
                Scanner fileInput = new Scanner(file);
                while (fileInput.hasNextLine()) {

                    /* String number = data[0];
                String firstName = data[1];
                String lastName = data[2];
                String address = data[3];
                String city = data[4];
                double hieght = Double.parseDouble(data[5]);
                double weight = Double.parseDouble(data[6]);
                //  int yob = int.parseInt(data[7]);

                passportList.add(new Passport(number,firstName,lastName,address, city,hieght,weight,yob));*/
                    String name = fileInput.nextLine();
                    int age = fileInput.nextInt();
                    fileInput.nextLine();
                    String city = fileInput.nextLine();
                    System.out.printf("%s is %d from %s\n", name, age, city);
                }
                fileInput.close();
            } else {
                System.out.println("File does not exist");
            }
        } catch (IOException ex) {
            System.out.println("Error reading file");
        }
    }

    private static void addPersonToList() {
             addPassportList();
    }

}
