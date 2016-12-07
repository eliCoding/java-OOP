
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
Rectangle;blue;4.5;7.2
Square;green;2.1
Square;;3.4
Square;yellow;2.2;6.5
Quadroplane;33.3;1;2.3;3.3
Circle;fuchsia;6.8
Circle;gray;7.8;7.8
Rectangle

Point;pink
Sphere;marine blue;68.9
Sphere;purple;12.2.2*/
class InvalidArgumentException extends Exception {

    InvalidArgumentException(String message) {
        super(message);
    }
}

class GeoObj {

    private String color;

    public GeoObj(String color) throws InvalidArgumentException {
        setColor(color);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color.matches("[A-Z][a-z]{1}")) {
            throw new IllegalArgumentException("error");

        }

        this.color = color;
    }

    public double getSurface() {

        throw new UnsupportedOperationException("error");
    }

    public double getCircumPerim() {
        throw new UnsupportedOperationException("error");

    }

    public int getVertcesCount() {
        throw new UnsupportedOperationException("error");

    }

    public double getEdgesCount() {
        throw new UnsupportedOperationException("error");

    }

    public void print() {
        throw new UnsupportedOperationException("error");
    }

}

class Point extends GeoObj {

    public Point(String color) throws InvalidArgumentException {
        super(color);
    }

    @Override
    public double getSurface() {

        return 0;
    }

    @Override
    public double getCircumPerim() {
        return 0;

    }

    @Override
    public int getVertcesCount() {
        return 0;

    }

    @Override
    public double getEdgesCount() {
        return 0;

    }

    @Override
    public void print() {
        System.out.printf("point "+ getColor());

    }
}

class Rectangle extends GeoObj {

    double width;
    double height;

    public Rectangle(String color, double width, double height) throws InvalidArgumentException {
        super(color);
        this.width = width;

        this.height = height;
    }

    @Override
    public double getSurface() {

        return width * height;
    }

    @Override
    public double getCircumPerim() {
        return 2 * width + 2 * height;

    }

    @Override
    public int getVertcesCount() {
        return 4;

    }

    @Override
    public double getEdgesCount() {
        return 4;

    }

    @Override
    public void print() {
        System.out.printf("rectangle color %s", getColor(), getSurface(), getCircumPerim());

    }

}

class Square extends Rectangle {

    public Square(String color, double edgLen) throws InvalidArgumentException {
        super(color, edgLen, edgLen);

    }

}

class Circle extends GeoObj {

    double radius;

    public Circle(String color, double radius) throws InvalidArgumentException {
        super(color);
        this.radius = radius;
    }

    @Override
    public double getSurface() {

        return Math.PI * radius * radius;
    }

    @Override
    public double getCircumPerim() {
        return 2 * Math.PI * radius;

    }

    @Override
    public int getVertcesCount() {
        return 0;

    }

    @Override
    public double getEdgesCount() {
        return 0;

    }

    @Override
    public void print() {
        System.out.printf("square color %s:", getColor(), getSurface(), getCircumPerim());
    }

}

class Sphere extends GeoObj {

    double radius;

    public Sphere(String color, double radius) throws InvalidArgumentException {
        super(color);
        this.radius = radius;
    }

    @Override
    public double getSurface() {

        return 4 * Math.PI * radius * radius;
    }

    @Override
    public double getCircumPerim() {
        return 2 * Math.PI * radius;

    }

    @Override
    public int getVertcesCount() {
        return 0;

    }

    @Override
    public double getEdgesCount() {
        return 0;

    }

    @Override
    public void print() {
        System.out.printf("Sphere color %s:", getColor(), getSurface(), getCircumPerim());

    }

}

/*Rectangle;blue;4.5;7.2
Square;green;2.1
Square;;3.4
Square;yellow;2.2;6.5
Quadroplane;33.3;1;2.3;3.3
Circle;fuchsia;6.8
Circle;gray;7.8;7.8
Rectangle

Point;pink
Sphere;marine blue;68.9
Sphere;purple;12.2.2*/
public class GeoMetry {

    static final String MY_FILE = "input.txt";
    static ArrayList<GeoObj> geoList = new ArrayList<>();

    public static void main(String[] args) {

        try {
            Scanner fileInput = new Scanner(new File(MY_FILE));
            while (fileInput.hasNextLine()) {
                try {
                    String line = fileInput.nextLine();
                    System.out.println("Processing line: " + line);
                    String[] data = line.split(";");
                    //   String color = data.length == 1 ? "" : data[1];
                    switch (data[0]) {
                        case "Rectangle":

                            if (data.length != 4) {
                                System.out.println("error " + line);
                                continue;
                            }
                            Rectangle r = new Rectangle(data[1], Double.parseDouble(data[2]), Double.parseDouble(data[3]));
                            geoList.add(r);

                            break;
                        case "Square":

                            if (data.length != 3) {
                                System.out.println("error " + line);
                                continue;
                            }
                            Square s = new Square(data[1], Double.parseDouble(data[2]));
                            geoList.add(s);
                            break;
                        case "Circle":

                            if (data.length != 3) {
                                System.out.println("error " + line);
                                continue;
                            }
                            Circle c = new Circle(data[1], Double.parseDouble(data[2]));
                            geoList.add(c);

                            break;
                        case "Point":

                            if (data.length != 2) {
                                System.out.println("error " + line);
                                continue;
                            }
                            Point p = new Point(data[1]);
                            geoList.add(p);
                            break;
                        case "Sphere":

                            if (data.length != 3) {
                                System.out.println("error " + line);
                                continue;
                            }
                            Sphere s1 = new Sphere(data[1], Double.parseDouble(data[2]));
                            geoList.add(s1);

                            break;
                        default:
                            System.out.println("fatal error : " + line);

                    }
                } catch (NumberFormatException | InvalidArgumentException e) {
                    System.out.println("Warning: invalid data " + e.getMessage());

                }
            }
            fileInput.close();
        } catch (IOException e) {
            System.err.println("Error reading file");
        } catch (InputMismatchException e) {
            System.err.println("Error: file contents mismatch");
        }

        System.out.println("====================");
        for (GeoObj g : geoList) {
            g.print();
            System.out.println();

        }
    }

}
