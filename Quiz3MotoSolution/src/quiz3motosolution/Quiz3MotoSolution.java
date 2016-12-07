package quiz3motosolution;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class InvalidInputDataException extends Exception {

    InvalidInputDataException(String message) {
        super(message);
    }
}

abstract class Transport {

    static Transport createFromLine(String line) throws InvalidInputDataException {
        String[] split;
        split = line.split(";");
        try {
            switch (split[0]) {
                case "Bicycle":
                    if ((split.length != 4)) {
                        throw new InvalidInputDataException("I get an Invalid data in line:");
                    }
                    return new Bicycle(split[1], Integer.parseInt(split[2]), Integer.parseInt(split[3]));
                case "Motorbike":
                    if ((split.length != 6)) {
                        throw new InvalidInputDataException("I get an Invalid data in line:");
                    }
                    return new Motorbike(split[1], Integer.parseInt(split[2]), Integer.parseInt(split[3]), Double.parseDouble(split[4]), split[5]);                    
                case "Car":
                    if ((split.length != 6)) {
                        throw new InvalidInputDataException("I get an Invalid data in line:");
                    }
                    return new Car(split[1], Integer.parseInt(split[2]), Integer.parseInt(split[3]), Double.parseDouble(split[4]), split[5]);
                case "Bus":
                    if (split.length != 3) {
                        throw new InvalidInputDataException("I get an Invalid data in line:");
                    } 
                    return new Bus(split[1], Integer.parseInt(split[2]), Integer.parseInt(split[3]), Double.parseDouble(split[4]), split[5]);
                default:
                    if ((split.length == 0)) {
                        throw new InvalidInputDataException("I get an Invalid data in line:");
                    } else {
                        throw new InvalidInputDataException("I get an Invalid data in line:");
                    }
            }
        } catch (IllegalArgumentException e) {
            throw new InvalidInputDataException("Error making Transport object, invalid data provided");
        }
    }
}

class Bicycle extends Transport {

    private String description; // at least 2 characters long
    private int wheelsCount; // 0-100
    private int maxPassengers; // 0-1000

    public Bicycle(String discription, int wheelNo, int passengerNo) {
        setDescription(discription);
        setWheelsCount(wheelNo);
        setMaxPassengers(passengerNo);
    }

    @Override
    public String toString() {
        return String.format("Bicycle is %s with %d wheels, can carry up to %d passengers.", this.getDescription(), this.getWheelsCount(), this.getMaxPassengers());
    }

    public String getDescription() {
        return description;
    }

    public final void setDescription(String description) {
        if (description.isEmpty() || description.length() < 2) {
            throw new IllegalArgumentException("description can not be empty or less than 2 characters.!");
        }
        this.description = description;
    }

    public int getWheelsCount() {
        return wheelsCount;
    }

    public final void setWheelsCount(int wheelsCount) {
        if (wheelsCount < 0 || wheelsCount > 100) {
            throw new IllegalArgumentException("Number of wheels must be between 0-100!");
        }
        this.wheelsCount = wheelsCount;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public final void setMaxPassengers(int maxPassengers) {
        if (maxPassengers < 0 || maxPassengers > 100) {
            throw new IllegalArgumentException("Number of Passengers must be between 0-100!");
        }
        this.maxPassengers = maxPassengers;
    }
}

class Motorbike extends Bicycle {

    private double maxSpeed; // 0-500
    private String plates; // 3-10 characters

    public Motorbike(String discription, int wheelNo, int passengerNo, double speed, String plate) {
        super(discription, wheelNo, passengerNo);
        setMaxSpeed(speed);
        setPlates(plate);
    }

    @Override
    public String toString() {
        return String.format("Motorbike is %s with %d wheels, can carry up to %d passengers with maximum speed of %.1f km/h, registration plates %s", this.getDescription(), this.getWheelsCount(), this.getMaxPassengers(), this.getMaxSpeed(), this.getPlates());
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public final void setMaxSpeed(double maxSpeed) {
        if (maxSpeed < 0 || maxSpeed > 500) {
            throw new IllegalArgumentException("Maximum of Speed must be between 0-500!");
        }
        this.maxSpeed = maxSpeed;
    }

    public String getPlates() {
        return plates;
    }

    public final void setPlates(String plates) {
        if (plates.isEmpty() || plates.length() < 3 || plates.length() > 10) {
            throw new IllegalArgumentException("Plate Number can not be empty or it must be between 3-10 characters.");
        }
        this.plates = plates;
    }
}

class Car extends Motorbike {

    public Car(String discription, int wheelNo, int passengerNo, double speed, String plate) {
        super(discription, wheelNo, passengerNo, speed, plate);
    }

    @Override
    public String toString() {
        return String.format("Car is %s with %d wheels, can carry up to %d passengers with maximum speed of %.1f km/h, registration plates %s", this.getDescription(), this.getWheelsCount(), this.getMaxPassengers(), this.getMaxSpeed(), this.getPlates());
    }
}

class Bus extends Motorbike {

    public Bus(String discription, int wheelNo, int passengerNo, double speed, String plate) {
        super(discription, wheelNo, passengerNo, speed, plate);
    }

    @Override
    public String toString() {
        return String.format("Bus is %s with %d wheels, can carry up to %d passengers with maximum speed of %.1f km/h, registration plates %s", this.getDescription(), this.getWheelsCount(), this.getMaxPassengers(), this.getMaxSpeed(), this.getPlates());
    }
}

public class Quiz3MotoSolution {

    static ArrayList<Transport> transportList = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    static File fileName = new File("input.txt");

    public static void main(String[] args) {
        menu();
    }

    private static int inputInt(String Message) {
        for (;;) {
            try {
                System.out.print(Message);
                int value = input.nextInt();
                input.nextLine(); // consume left-over new line character
                return value;
            } catch (InputMismatchException ime) {
                input.nextLine(); // consume the invalid input
                System.out.println("Invalid input, try again");
            }
        }
    }

    public static void readFile() {
        String line;
        int counter = 0;

        try {
            Scanner read = new Scanner(fileName);
            while (read.hasNextLine()) {
                line = read.nextLine();
                counter++;
                try {
                    Transport t = Transport.createFromLine(line);
                    transportList.add(t);
                } catch (InvalidInputDataException e) {
                    System.out.printf("Warning: ignoring invalid line %d '%s'\n",
                            counter, line);
                    System.out.println("Due to: " + e.getMessage());
                    continue;
                }
            }
            System.out.println(" In a input file There is " + counter + " line that have error!");
            read.close();
        } catch (IOException e) {
            System.err.println("Can not find the file.");

        }
    }

    public static void menu() {
        readFile();
        while (true) {
            System.out.println("******************************************");
            System.out.println("1. List all Transports\n"
                    + "2. find the fastest of all Transports \n"
                    + "3. find the transport that can carry the most passengers\n"
                    + "4. find the average speed of all Transports \n"
                    + "0. Exit");
            int choice = inputInt("Choice: ");
            if ((choice < 0) || (choice > 5)) {
                System.out.println("Invalid choice.");
                continue;
            }
            if (choice == 0) {
                return;
            }
            switch (choice) {
                case 0:
                    System.out.println("Thanks to see my Application.");
                    return;
                case 1:
                    listAllTransports();
                    break;
                case 2:
                    fastestTransports();
                    break;
                case 3:
                    carryTheMostPassengers();
                    break;
                case 4:
                    averageSpeedOfAllTransports();
                    break;
                default:
                    System.out.println("Call the developer @ IT department.");
                    System.exit(1);
            }
        }
    }

    public static void listAllTransports() {
        for (Transport t : transportList) {
            System.out.println(t);
        }
    }

    public static void fastestTransports() {
        double maxSpeed = -1;
        Motorbike maxSpeedTransport = null;
        for (Transport t : transportList) {
            if (t instanceof Motorbike) {
                Motorbike m = (Motorbike)t;
                if (m.getMaxSpeed() > maxSpeed) {
                    maxSpeedTransport = m;
                }
            }
        }
        if (maxSpeedTransport == null) {
            System.out.println("Didn't find any transport with maxSpeed");
        } else {
            System.out.println("The fastest of all transport is: "
                    + maxSpeedTransport.toString());
        }
    }

    public static void carryTheMostPassengers() {
/*        int maxPassenger = 0;
        Transport hasMaxPassenger = new Transport();
        for (Transport T : transportList) {
            if (T instanceof Bicycle) {
                if (((Bicycle) T).getMaxPassengers() > maxPassenger) {
                    maxPassenger = ((Bicycle) T).getMaxPassengers();
                    hasMaxPassenger = T;
                }
            }
        }
        System.out.println("The transport that carry The Most Passengers is:" + hasMaxPassenger.toString());
*/
    }

    public static void averageSpeedOfAllTransports() {        
        double averageSpeed = 0.0;
        int counter = 0;
        for (Transport t : transportList) {
//            if (t instanceof Motorbike) {
                Motorbike m = (Motorbike)t;
                averageSpeed = m.getMaxSpeed() + averageSpeed;
                counter++;
//            }
        }
        if (counter == 0) {
            System.out.println("No transports with max Speed to compute average");
        } else {
            System.out.println("The average Speed Of All Transports is:"
                + averageSpeed / counter + " Km/h");
        }
    }
}