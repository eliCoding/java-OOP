/*Quiz 3 - Java 2 - IPD-9 - Dec 5, 2016

Create project Quiz3Moto

Input file "input.txt" for you to copy into the main directory of your project.

Bicycle;Jerry's bike;2;1

Motorbike;My blue machine;2;2;321.7;Y7U777
Motorbike;asfdlkajsf
Car;Toyota Corolla LE 2009;4;5;195.3;GT5RRE
Car;Toyota Corolla LE 2009;4;5;195.3;GT5RRE;kjhkh
Car;;4;5;195.3;GT5RRE
Bus;Greyhound LXER;10;67;175.4;FTR33YD
Bus;Greyhound LXER;10;67;175.4;F
Bus;Greyhound LXER;0;67;175.4;FJKHJHR


exception InvalidInputDataException extends Exception {
InvalidInputDataException(String message) {
super(message);
}
}

class Transport {
// factory method
static Transport createFromLine(String line) { ... }
}

class Bicycle extends Transport {
// add constructor with 3 parameters
String description; // at least 2 characters long
int wheelsCount; // 0-100
int maxPassengers; // 0-1000
public String toString() { ... }
}

class Motorbike extends Bicycle {
// add constructor with 5 parameters
double maxSpeed; // 0-500
String plates; // 3-10 characters
public String toString() { ... }
}

class Car extends Motorbike {
// add constructor with 5 parameters
public String toString() { ... }
}

class Bus extends Motorbike {
// add constructor with 5 parameters
public String toString() { ... }
}

In class Quiz3Moto you will add

static ArrayList<Transport> transportList = new ArrayList<>();


1. In your main() method you will read the input file,
pass each line to factory method in Transport, then
add the instantiated item to transportList.

If any line of the input file is invalid you will warn the user and continue to the next line.

2. You will do a for-each loop over the list and use toString to display data about each item in user friendly manner, such as:

Car is Toyota Corolla LE 2009 with 4 wheels, can carry up to 5 passengers with maximum speed of 195.3 km/h, registration plates GT5RRE


4. You will find the fastest of all Transports that is not a Bicycle and display its data
 
5. You will find the transport that can carry the most passengers and display its data

6. You will find the average speed of all Transports that are not a Bicycle and display its data

NOTES:
* There is no input from the user in this program
* You must apply all best programming practices that you learned about so far, when in doubt - ask the teacher.
* You will have to implement all toString(), constructors, and encapsulate fields so that setters can verify values assigned.

WHAT TO SUBMIT
* All your code must be in a single Quiz3Moto.java file.
You only submit that one file.*/
package quiz3moto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import static quiz3moto.Quiz3Moto.MY_FILE;
import static quiz3moto.Quiz3Moto.transportList;

class InvalidInputDataException extends Exception {

    InvalidInputDataException(String message) {
        super(message);

    }
}

class Transport {
// factory method

    static Transport createFromLine(String line) {
        // factory();
        try {
            Scanner fileInput = new Scanner(MY_FILE);
            while (fileInput.hasNextLine()) {
                try {
                    String fileLine = fileInput.nextLine();
                    //  System.out.println("the prossing line is: " + line);
                    String[] data = fileLine.split(";");

                    switch (data[0]) {

                        case "Bicycle": {
                            if (data.length != 4) {
                                System.out.println("Invalid number of data: " + fileLine);
                                continue;
                            }
                            Bicycle b = new Bicycle(data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]));
                            transportList.add(b);
                        }
                        break;

                        case "Motorbike":
                            if (data.length != 5) {
                                System.out.println("Invalid number of data: " + fileLine);
                                continue;
                            }

                            Motorbike m = new Motorbike(data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), Double.parseDouble(data[3]), data[4]);
                            transportList.add(m);

                            break;

                        case "Car":
                            if (data.length != 5) {
                                System.out.println("Invalid number of data: " + fileLine);
                                continue;
                            }

                            Car c = new Car(data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), Double.parseDouble(data[3]), data[4]);
                            transportList.add(c);

                            break;

                        case "Bus":
                            if (data.length != 5) {
                                System.out.println("Invalid number of data: " + fileLine);
                                continue;
                            }

                            Bus u = new Bus(data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), Double.parseDouble(data[3]), data[4]);
                            transportList.add(u);

                            break;

                        default:
                            System.out.println("Invalid Data in the line: " + fileLine);

                    }

                } catch (NumberFormatException e) {

                    System.out.println("Number Format Exception: " + e);

                }

            }
            fileInput.close();

        } catch (FileNotFoundException ex) {
            System.out.println("File not found" + ex);
        }
        return createFromLine(line);

    }

}

class Bicycle extends Transport {
// add constructor with 3 parameters

    private String description; // at least 2 characters long
    private int wheelsCount; // 0-100
    private int maxPassengers; // 0-1000

    public Bicycle(String description, int wheelsCount, int maxPassengers) {
        setDescription(description);
        setWheelsCount(wheelsCount);
        setMaxPassengers(maxPassengers);
    }

    @Override
    public String toString() {
        return String.format("Bicycle is  %s with %d wheels and %d  passengers\n", getDescription(), getWheelsCount(), getMaxPassengers());

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description.length() < 2) {
            throw new IllegalArgumentException("it has to be at least 2 character");

        }
        this.description = description;
    }

    public int getWheelsCount() {
        return wheelsCount;
    }

    public void setWheelsCount(int wheelsCount) {
        if (wheelsCount < 0 || wheelsCount > 100) {
            throw new IllegalArgumentException("it has to be between 0-100");
        }

        this.wheelsCount = wheelsCount;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    //0-1000
    public void setMaxPassengers(int maxPassengers) {
        if (wheelsCount < 0 || wheelsCount > 100) {
            throw new IllegalArgumentException("it has to be between 0-1000");
        }
        this.maxPassengers = maxPassengers;
    }
}

class Motorbike extends Bicycle {
// add constructor with 5 parameters

    private double maxSpeed; // 0-500
    private String plates; // 3-10 characters

    public Motorbike(String description, int wheelsCount, int maxPassengers, double maxSpeed, String plates) {
        super(description, wheelsCount, maxPassengers);

    }

    @Override
    public String toString() {
        return String.format("Motorbike: %s,%d,%d,d%,%s\n", getDescription(), getWheelsCount(), getMaxPassengers(), getMaxSpeed(), getPlates());
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        if (maxSpeed < 0 || maxSpeed > 500) {
            throw new IllegalArgumentException("it has to be between 0-500");
        }
        this.maxSpeed = maxSpeed;
    }

    public String getPlates() {
        return plates;
    }

    public void setPlates(String plates) {
        if (plates.length() < 3 || plates.length() > 10) {
            throw new IllegalArgumentException("it has to be 3 to 10 character");

        }
        this.plates = plates;

    }
}

class Car extends Motorbike {

    public Car(String description, int wheelsCount, int maxPassengers, double maxSpeed, String plates) {
        super(description, wheelsCount, maxPassengers, maxSpeed, plates);
    }

// add constructor with 5 parameters
    @Override
    public String toString() {
        return String.format("Car is  %s,%d,%d,d%,%s\n", getDescription(), getWheelsCount(), getMaxPassengers(), getMaxSpeed(), getPlates());

    }
}

class Bus extends Motorbike {

    public Bus(String description, int wheelsCount, int maxPassengers, double maxSpeed, String plates) {
        super(description, wheelsCount, maxPassengers, maxSpeed, plates);
    }

// add constructor with 5 parameters
    @Override
    public String toString() {
        return String.format("Bus: %s,%d,%d,d%,%s\n", getDescription(), getWheelsCount(), getMaxPassengers(), getMaxSpeed(), getPlates());
    }
    //return "Triangle: side1 =" + side1 + " side2 = " + side2 + "  side3 = " + side3;
}

public class Quiz3Moto {

    static ArrayList<Transport> transportList = new ArrayList<>();
    public static final File MY_FILE = new File("input.txt");

    public static void main(String[] args) {
        try {
            Scanner fileInput = new Scanner(MY_FILE);
            while (fileInput.hasNextLine()) {
                try {
                    String fileLine = fileInput.nextLine();
                    //  System.out.println("the prossing line is: " + line);
                    String[] data = fileLine.split(";");

                    switch (data[0]) {

                        case "Bicycle": {
                            if (data.length != 4) {
                                System.out.println("Invalid number of data: " + fileLine);
                                continue;
                            }
                            Bicycle b = new Bicycle(data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]));
                            transportList.add(b);
                        }
                        break;

                        case "Motorbike":
                            if (data.length != 5) {
                                System.out.println("Invalid number of data: " + fileLine);
                                continue;
                            }

                            Motorbike m = new Motorbike(data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), Double.parseDouble(data[3]), data[4]);
                            transportList.add(m);

                            break;

                        case "Car":
                            if (data.length != 5) {
                                System.out.println("Invalid number of data: " + fileLine);
                                continue;
                            }

                            Car c = new Car(data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), Double.parseDouble(data[3]), data[4]);
                            transportList.add(c);

                            break;

                        case "Bus":
                            if (data.length != 5) {
                                System.out.println("Invalid number of data: " + fileLine);
                                continue;
                            }

                            Bus u = new Bus(data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), Double.parseDouble(data[3]), data[4]);
                            transportList.add(u);

                            break;

                        default:
                            System.out.println("Invalid Data in the line: " + fileLine);

                    }

                } catch (NumberFormatException e) {

                    System.out.println("Number Format Exception: " + e);

                }

            }
            fileInput.close();

        } catch (FileNotFoundException ex) {
            System.out.println("File not found" + ex);
        }

        //  String line = null;
        //  Transport createFromLine = Transport.createFromLine(line);
        //  System.out.println(createFromLine);
        System.out.println("================================");
        for (Transport t : transportList) {

            System.out.println(t.toString());
        }
        System.out.println("the fastest Transport is:");
        try {
            Scanner fileInput = new Scanner(MY_FILE);
            while (fileInput.hasNextLine()) {
                try {
                    String fileLine = fileInput.nextLine();

                    String[] data = fileLine.split(";");

                    switch (data[0]) {

                        case "Bicycle": {
                            if (data.length != 4) {
                                System.out.println("Invalid number of data: " + fileLine);
                                continue;
                            }
                            Bicycle b = new Bicycle(data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]));
                            transportList.add(b);
                        }
                        break;

                        case "Motorbike":
                            if (data.length != 5) {
                                System.out.println("Invalid number of data: " + fileLine);
                                continue;
                            }

                            Motorbike m = new Motorbike(data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), Double.parseDouble(data[3]), data[4]);
                            transportList.add(m);

                            break;

                        case "Car":
                            if (data.length != 5) {
                                System.out.println("Invalid number of data: " + fileLine);
                                continue;
                            }

                            Car c = new Car(data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), Double.parseDouble(data[3]), data[4]);
                            transportList.add(c);

                            break;

                        case "Bus":
                            if (data.length != 5) {
                                System.out.println("Invalid number of data: " + fileLine);
                                continue;
                            }

                            Bus u = new Bus(data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), Double.parseDouble(data[3]), data[4]);
                            transportList.add(u);

                            break;

                        default:
                            System.out.println("Invalid Data in the line: " + fileLine);

                    }

                } catch (NumberFormatException e) {

                    System.out.println("Number Format Exception: " + e);

                }

            }
            fileInput.close();

        } catch (FileNotFoundException ex) {
            System.out.println("File not found" + ex);
        }

        Transport t = new Transport();
       
        
        
        
        

    }

}
