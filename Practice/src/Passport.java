
import static com.sun.javafx.util.Utils.contains;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
class Passport1 {

    private String number; // passport number AB123456 format
    private String firstName; // year of birth - between 1900-2050
    private String lastName;
    private String address;
    private String city;
    private double heightCm;
    private double weightKg;
    private int yob;

    public Passport1(String number, String firstName, String lastName, String address, String city, double heightCm, double weightKg, int yob) {
        this.number = number;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.heightCm = heightCm;
        this.weightKg = weightKg;
        this.yob = yob;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        if (!number.matches("{A-Z}[2]{1-9}[6]")) {
            throw new IllegalArgumentException("two letter and 6 number");
        }
        this.number = number;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.length() != 2) {
            throw new IllegalArgumentException("it has to be 2");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.length() != 2) {
            throw new IllegalArgumentException("it has to be 2");
        }
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address.length() != 2) {
            throw new IllegalArgumentException("it has to be 2");
        }
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        if (city.length() != 2) {
            throw new IllegalArgumentException("it has to be 2");
        }
        this.city = city;
    }

    public double getHeightCm() {
        return heightCm;
    }

    public void setHeightCm(double heightCm) {
        if (heightCm < 0 || heightCm > 300) {

            throw new IllegalArgumentException("it has to be between 0-300");

        }
        this.heightCm = heightCm;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(double weightKg) {
        if (weightKg < 0 || weightKg > 300) {

            throw new IllegalArgumentException("it has to be between 0-300");

        }
        this.weightKg = weightKg;
    }

    public int getYob() {
        return yob;
    }

    public void setYob(int yob) //year of birth - between 1900-2050
    {
        if (yob < 1900 || yob > 2050) {

            throw new IllegalArgumentException("year of birth - between 1900-2050");

        }

        this.yob = yob;
    }

}

public class Passport {

    static ArrayList<Passport1> passList = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    public static final String MYFILE = "passports.txt";

    public static void main(String[] args) {
        System.out.println("1. Display all passports data (one per line)\n"
                + "2. Display all passports for people in the same city (ask for city name)\n"
                + "3. Find the tallest person and display their info\n"
                + "4. Find the lightest person and display their info\n"
                + "5. Display all people younger than certain age (ask for max age, not year)\n"
                + "6. Add person to list (in memory only)\n"
                + "0. Save data back to file and exit.");

        System.out.println("enter your choice:");

        int choice = input.nextInt();

        switch (choice) {
            case 1:
                displayData();
                break;
            case 2:
                sameCity();
                break;
            case 3:
                tallestPerson();
                break;
            case 4:
                lightestPerson();
                break;
            case 5:
                youngerPeople();
                break;
            case 6:
                addPerson();
                break;
            case 0:
                saveDate();
                break;

            default:
                System.err.println("error");

        }

    }

    private static void displayData() {

        try {
            Scanner fileInput = new Scanner(new File(MYFILE));

            while (fileInput.hasNextLine()) {
                String fileLine;
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

                double heightCm = Double.parseDouble(data[5]);

                double weightKg = Double.parseDouble(data[6]);
                int yob = Integer.parseInt(data[7]);
                //    Passport p = new Passport();

                passList.add(new Passport1(number, firstName, lastName, address, city, heightCm, weightKg, yob));

            }
            fileInput.close();

            for (Passport1 e : passList) {
                System.out.println(e.getNumber() + ";" + e.getFirstName() + ";" + e.getLastName() + ";" + e.getAddress() + ";" + e.getCity() + ";" + e.getHeightCm() + ";" + e.getWeightKg() + ";" + e.getYob());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("FileNOtDFoundException" + ex);
        }

    }

    private static void sameCity() {
        try {
            Scanner fileInput = new Scanner(new File(MYFILE));

            while (fileInput.hasNextLine()) {
                String fileLine;
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

                double heightCm = Double.parseDouble(data[5]);

                double weightKg = Double.parseDouble(data[6]);
                int yob = Integer.parseInt(data[7]);

                passList.add(new Passport1(number, firstName, lastName, address, city, heightCm, weightKg, yob));
                System.out.println("Please enter the city:");
                input.nextLine();
                String cityName = input.nextLine();
                if (contains(cityName, city)) {
                    for (Passport1 e : passList) {
                        System.out.println(e.getNumber() + ";" + e.getFirstName() + ";" + e.getLastName() + ";" + e.getAddress() + ";" + e.getCity() + ";" + e.getHeightCm() + ";" + e.getWeightKg() + ";" + e.getYob());
                    }

                }

            }
            fileInput.close();

        } catch (FileNotFoundException ex) {
            System.out.println("FileNOtDFoundException" + ex);
        }

    }

    private static void tallestPerson() {
        try {
            Scanner fileInput = new Scanner(new File(MYFILE));

            while (fileInput.hasNextLine()) {
                String fileLine;
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

                double heightCm = Double.parseDouble(data[5]);

                double weightKg = Double.parseDouble(data[6]);
                int yob = Integer.parseInt(data[7]);

                passList.add(new Passport1(number, firstName, lastName, address, city, heightCm, weightKg, yob));
                System.out.println("Please enter the height:");
                input.nextLine();
                double heightInput = input.nextDouble();

                if (heightInput > heightCm) {
                    for (Passport1 e : passList) {
                        System.out.println(e.getNumber() + ";" + e.getFirstName() + ";" + e.getLastName() + ";" + e.getAddress() + ";" + e.getCity() + ";" + e.getHeightCm() + ";" + e.getWeightKg() + ";" + e.getYob());
                    }

                }

            }
            fileInput.close();

        } catch (FileNotFoundException ex) {
            System.out.println("FileNOtDFoundException" + ex);
        }

    }

    private static void lightestPerson() {

    }

    private static void youngerPeople() {

    }

    private static void addPerson() {
        try {
            System.out.print("Enter passPort NUmber: ");
            String number = input.nextLine();
            input.nextLine();
            System.out.print("Enter first name: ");
            String firstName = input.nextLine();
            System.out.print("Enter last name: ");
            String lastName = input.nextLine();
            System.out.print("Enter address: ");
            String address = input.nextLine();
            System.out.print("Enter city: ");
            String city = input.nextLine();

            System.out.print("Enter heightCm: ");
            double heightCm = input.nextDouble();
            System.out.print("Enter weightKg: ");
            double weightKg = input.nextDouble();
            System.out.print("Enter yob: ");
            int yob = input.nextInt();

            input.nextLine();

            passList.add(new Passport1(number, firstName, lastName, address, city, heightCm, weightKg, yob));

            PrintWriter pw = new PrintWriter(new FileWriter(MYFILE,true));
            for (Passport1 e : passList) {
                pw.printf(e.getNumber() + ";" + e.getFirstName() + ";" + e.getLastName() + ";" + e.getAddress() + ";" + e.getCity() + ";" + e.getHeightCm() + ";" + e.getWeightKg() + ";" + e.getYob());
            }

            pw.close();
        } catch (InputMismatchException | IllegalArgumentException | IOException e) {
            System.err.println("Error creating passlist: " + e.getMessage());
        }

    }

    private static void saveDate() {

    }

}
