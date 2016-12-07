// author Elmira Amanollahi

/*
 DAY 04 TASK 3

Create a project AirportTravel.

In the main directory of the project, using Notepad create file "airports.txt" which will contain lines such as:

YUL;Montreal;45.4697842;-73.7554174
YYZ;Toronto;43.6777215;-79.6270084
JFK;New York JFK;40.6413151;-73.7803278

(Add at least 3 more lines)

Create a class Airport initially like this:

class Airport {
	String code, city;
	double latitude, longitude;
}

Add a suitable constructor, getters and setters that ensure that:
-code is always 3 upper-case letters,
- city is non-null, not empty string,
- latitude and longitude are within the correct ranges.

When your program starts you will read file "airports.txt" instantiate object type Airport for each of them and add them to

static ArrayList<Airport> airportList = new ArrayList<>();

Suggestion: read each line with nextLine(), then split(";") the result, parse doubles and pass to Airport() constructor.

Display the following menu to the user:

1. Show all airports (codes and city names)
2. Find distance between two airports by codes.
3. Find the 2 airports nearest to an airport given and display the distance.
4. Add a new airport to the list.
0. Exit.

On Exit your program must write back an updated list of airports to "airports.txt" file.

Suggestion: make a copy of "airports.txt" file just in case you lost data when overriding.

Implement the functionality listed in the menu.

Regarding item #3 - if you can't find the 2 nearest airports then find the 1 nearest airport and display the distance.


 */

package airporttravel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Airport {

    public Airport(String code, String city, double latitude, double longitude) {
        setCode(code);
        setCity(city);
        setLatitude(latitude);
        setLongitude(longitude);
    }

    private String code;
    private String city;
    private double latitude;
    private double longitude;

    public String getCode() {
        return code;
    }

    // isUppercaseLetter?
    private boolean isUpLet(char c) {
        return (c >= 65 && c <= 90);
    }

    public void setCode(String code) {
        // VERSION 1
        if (code.length() != 3 || !isUpLet(code.charAt(0))
                || !isUpLet(code.charAt(1)) || !isUpLet(code.charAt(2))) {
            throw new IllegalArgumentException("Airport code must be 3 uppercase letters: " + code);
        }
        /* // VERSION 2: using regular expression
        if (!code.matches("[A-Z]{3}")) {
            throw new IllegalArgumentException("Airport code must be 3 uppercase letters");
        } */
        this.code = code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        if (city == null || city.length() < 1) {
            throw new IllegalArgumentException("City name must not be empty");
        }
        this.city = city;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        if (latitude < -90 || latitude > 90) {
            throw new IllegalArgumentException("Latitude must be from -90 to 90: " + latitude);
        }
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        if (longitude < -180 || longitude > 180) {
            throw new IllegalArgumentException("Longitude must be from -180 to 180: " + longitude);
        }
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return String.format("%s (%s) at (%.7f,%.7f)", code, city, latitude, longitude);
    }

}

public class AirportTravel {

    static ArrayList<Airport> airportList = new ArrayList<>();

    static final String FILE_NAME = "airports.txt";

    static void readAirports() throws FileNotFoundException {
        Scanner fileInput = new Scanner(new File(FILE_NAME));
        while (fileInput.hasNextLine()) {
            String fileLine = null;
            try {
                fileLine = fileInput.nextLine();
                /* VERSION 1
            Scanner lineInput = new Scanner(fileLine).useDelimiter(";");
            String code = lineInput.next();
            String city = lineInput.next();
            double lat = lineInput.nextDouble();
            double lgt = lineInput.nextDouble();
                 */
                String data[] = fileLine.split(";");
                if (data.length != 4) {
                    throw new IllegalArgumentException("Line malformed: " + fileLine);
                }
                String code = data[0];
                String city = data[1];
                double lat = Double.parseDouble(data[2]);
                double lgt = Double.parseDouble(data[3]);
                airportList.add(new Airport(code, city, lat, lgt));
            } catch (IllegalArgumentException e) {
                System.err.println("Skipping invalid input line: " + fileLine);
            }
        }
        fileInput.close();
    }

    private static int getMenuChoice() {
        while (true) {
            System.out.println("1. Show all airports (codes and city names)\n"
                    + "2. Find distance between two airports by codes.\n"
                    + "3. Find the 2 airports nearest to an airport given and display the distance.\n"
                    + "4. Add a new airport to the list.\n"
                    + "0. Exit.");
            System.out.print("Enter choice [0-4]: ");
            try {
                int choice = input.nextInt();
                input.nextLine();
                if (choice < 0 || choice > 4) {
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

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            readAirports();
            while (true) {
                int choice = getMenuChoice();
                switch (choice) {
                    case 0:
                        // save all airports back to file
                        saveAllAirportsToFile();
                        System.out.println("Bye bye");
                        return;
                    case 1:
                        showAllAirports();
                        break;
                    case 2:
                        findDistanceBetweenTwoAirports();
                        break;
                    case 3:
                        findTwoNearestAirports();
                        break;
                    case 4:
                        addAirport();
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

    private static void showAllAirports() {
        // VERSION 1
       // for (int i = 0; i < airportList.size(); i++) {
          //  Airport a = airportList.get(i);
          //  System.out.printf("%s-%s\n", a.getCode(), a.getCity());
       // }
        // VERSION 2
        for (Airport a : airportList) {
            System.out.println(a);
        }
         
    }

    private static Airport findAirportByCode(String code) {
        for (Airport a : airportList) {
            if (a.getCode().equals(code)) {
                return a;
            }
        }
        return null;
    }

    // returns distance in meters - copied from
    // http://stackoverflow.com/questions/3694380/calculating-distance-between-two-points-using-latitude-longitude-what-am-i-doi
    public static double distance(double lat1, double lng1,
            double lat2, double lng2) {
        double a = (lat1 - lat2) * distPerLat(lat1);
        double b = (lng1 - lng2) * distPerLng(lat1);
        return Math.sqrt(a * a + b * b);
    }

    private static double distPerLng(double lat) {
        return 0.0003121092 * Math.pow(lat, 4)
                + 0.0101182384 * Math.pow(lat, 3)
                - 17.2385140059 * lat * lat
                + 5.5485277537 * lat + 111301.967182595;
    }

    private static double distPerLat(double lat) {
        return -0.000000487305676 * Math.pow(lat, 4)
                - 0.0033668574 * Math.pow(lat, 3)
                + 0.4601181791 * lat * lat
                - 1.4558127346 * lat + 110579.25662316;
    }

    private static double getDistanceInKm(Airport a1, Airport a2) {
        return distance(a1.getLatitude(), a1.getLongitude(),
                a2.getLatitude(), a2.getLongitude()) / 1000;
    }

    private static void findDistanceBetweenTwoAirports() {
        System.out.print("Enter airport 1 code: ");
        //
        String code1 = input.nextLine();
        Airport a1 = findAirportByCode(code1);
        if (a1 == null) {
            System.out.println("Airport not found, try again.");
            return;
        }
        //
        System.out.print("Enter airport 2 code: ");
        String code2 = input.nextLine();
        Airport a2 = findAirportByCode(code2);
        if (a2 == null) {
            System.out.println("Airport not found, try again.");
            return;
        }
        //
        System.out.printf("Distance between %s-%s and %s-%s is %.3f\n",
                a1.getCode(), a1.getCity(), a2.getCode(), a2.getCity(),
                getDistanceInKm(a1, a2));
    }

    private static void findTwoNearestAirports() {
        System.out.print("Enter airport code: ");
        //
        String code = input.nextLine();
        Airport homeAirport = findAirportByCode(code);
        if (homeAirport == null) {
            System.out.println("Airport not found, try again.");
            return;
        }
        // what if first airport is home airport?
        Airport minAirport = airportList.get(0);
        if (minAirport == homeAirport) {
            minAirport = airportList.get(1);
        }
        double minDistance = getDistanceInKm(homeAirport, minAirport);
        for (Airport a : airportList) {
            // skip the home airport since distance to itself is always 0
            if (a == homeAirport) {
                continue;
            }
            double dist = getDistanceInKm(homeAirport, a);
            if (dist < minDistance) {
                minDistance = dist;
                minAirport = a;
            }
        }
        System.out.printf("Airport closest to %s is %s at %.2fkm\n",
                homeAirport.getCode(), minAirport.getCode(), minDistance);

        /* //
        int intArray [] = { 3, -3, 0, 7, -2 };
        int min = intArray[0];
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] < min) {
                min = intArray[i];
            }
        } */
    }

    private static void addAirport() {
        try {
            System.out.print("Enter airport code: ");
            String code = input.nextLine();
            System.out.print("Enter city: ");
            String city = input.nextLine();
            System.out.print("Enter latitude: ");
            double lat = input.nextDouble();
            input.nextLine();
            System.out.print("Enter longitude: ");
            double lgt = input.nextDouble();
            input.nextLine();
            //
            Airport a = new Airport(code, city, lat, lgt);
            airportList.add(a);
        } catch (InputMismatchException | IllegalArgumentException e) {
            System.err.println("Error creating airport: " + e.getMessage());
        }

    }

    private static void saveAllAirportsToFile() {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME));
            for (Airport a : airportList) {
                pw.printf("%s;%s;%f;%f\n", a.getCode(), a.getCity(),
                        a.getLatitude(), a.getLongitude());
            }
            pw.close();
        } catch (IOException e) {
            System.err.println("Error saving to file");
            // FIXME close the file anyway
        }
    }

}