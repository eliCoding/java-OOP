/*Sections 11.2–11.4
11.1 (The Triangle class) Design a class named Triangle that extends
GeometricObject. The class contains:
■ Three double data fields named side1, side2, and side3 with default
values 1.0 to denote three sides of the triangle.
■ A no-arg constructor that creates a default triangle.
■ A constructor that creates a triangle with the specified side1, side2, and
side3.
■ The accessor methods for all three data fields.
■ A method named getArea() that returns the area of this triangle.
■ A method named getPerimeter() that returns the perimeter of this triangle.
■ A method named toString() that returns a string description for the triangle.
For the formula to compute the area of a triangle, see Programming Exercise 2.19.
The toString() method is implemented as follows:
return "Triangle: side1 = " + side1 + " side2 = " + side2 +
" side3 = " + side3;
Draw the UML diagrams for the classes Triangle and GeometricObject and
implement the classes. Write a test program that prompts the user to enter three
sides of the triangle, a color, and a Boolean value to indicate whether the triangle
is filled. The program should create a Triangle object with these sides and set
the color and filled properties using the input. The program should display
the area, perimeter, color, and true or false to indicate whether it is filled or not.*/
//class GeometricObject {
//}
class Triangle {

    private double side1 = 1;
    private double side2 = 1;
    private double side3 = 1;

    public Triangle() {
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public double getArea(int width, int height) {

        return (width * height) / 2;

    }

    public double getPrimeter(double height, double base) {

        Double hypotenuse = Math.pow(Math.pow(base, 2) + Math.pow(height, 2), 0.5);

        return base + height + hypotenuse;

    }

    @Override
    public String toString() {
        return "Triangle: side1 =" + side1 + " side2 = " + side2 + "  side3 = " + side3;
    }

}

public class GeoObject {

    public static void main(String[] args) {
        Triangle t = new Triangle(1, 2, 3);

        System.out.println(t.toString() + "   \n" + t.getPrimeter(4, 3) + "  \n" + t.getArea(5, 4));
    }

}
