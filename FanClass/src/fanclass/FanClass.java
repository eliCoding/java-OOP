/*(The Fan class) Design a class named Fan to represent a fan. The class contains:
¦ Three constants named SLOW, MEDIUM, and FAST with the values 1, 2, and 3 to
denote the fan speed.
¦ A private int data field named speed that specifies the speed of the fan (the
default is SLOW).
¦ A private boolean data field named on that specifies whether the fan is on (the
default is false).
¦ A private double data field named radius that specifies the radius of the fan
(the default is 5).
¦ A string data field named color that specifies the color of the fan (the default
is blue).
¦ The accessor and mutator methods for all four data fields.
¦ A no-arg constructor that creates a default fan.
¦ A method named toString() that returns a string description for the fan. If
the fan is on, the method returns the fan speed, color, and radius in one combined
string. If the fan is not on, the method returns the fan color and radius
along with the string “fan is off” in one combined string.
Draw the UML diagram for the class and then implement the class. Write a test
program that creates two Fan objects. Assign maximum speed, radius 10, color
yellow, and turn it on to the first object. Assign medium speed, radius 5, color
blue, and turn it off to the second object. Display the objects by invoking their
toString method.*/
package fanclass;

class Fan {

    private final int SLOW = 1, MEDIUM = 2, FAST = 3;

    private int speed;
    private boolean on;
    private double radius;
    private String color;

    Fan() {

        speed = SLOW;
        boolean on = false;
        radius = 5;
        color = "blue";
    }

    Fan(int speed, boolean on, double radius, String color) {
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;
    }

    @Override
    public String toString() {
        return getSpeed() + " " + isOn() + " " + getRadius() + " " + getColor();
    }

    public int getSLOW() {
        return SLOW;
    }

    public int getMEDIUM() {
        return MEDIUM;
    }

    public int getFAST() {
        return FAST;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    void displayFan() {
        if (on == true) {

            System.out.println(speed + " " + color + " " + radius);
        } else {
            System.out.println(color + " " + radius + " “fan is off” ");
        }

    }
}

public class FanClass {

    public static void main(String[] args) {
        Fan f = new Fan();
        Fan f1 = new Fan(3, true, 10, "yellow");
        Fan f2 = new Fan(2, false, 5, "blue");
        f.displayFan();
        f1.displayFan();
        f2.displayFan();
       
     

    }

}
