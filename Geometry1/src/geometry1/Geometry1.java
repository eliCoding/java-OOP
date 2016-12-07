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
package geometry1;

import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.Math.PI;
import java.util.ArrayList;
import java.util.Scanner;

class InvalidArgumentException extends Exception {

    InvalidArgumentException(String message) {
        super(message);
    }
}

class GeoObj {

    String color;

    GeoObj(String color) {
        setColor(color);
    }

    public String getColor() {
        return color;
    }

    public double getSurface() {
        throw new UnsupportedOperationException("error ");

    }

    public double getCircumPerim() {
        throw new UnsupportedOperationException("error ");
    }

    public double getverticesCount() {
        throw new UnsupportedOperationException("error ");

    }

    public int getEdgesCount() {
        throw new UnsupportedOperationException("error ");
    }

    public void print() {
        throw new UnsupportedOperationException("error ");

    }

    public void setColor(String color) {
        if (color.matches("[A-Z][a-z]{1}")) {
            throw new IllegalArgumentException("min 1 char");

        }

        this.color = color;
    }

}

class Point extends GeoObj {

    Point(String color) {
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
    public double getverticesCount() {
        return 0;

    }

    @Override
    public int getEdgesCount() {
        return 0;
    }

    @Override
    public void print() {
        System.out.printf("point %s ", getColor());

    }

}

class Rectangle extends GeoObj {

    double height;
    double width;

    Rectangle(String color, double height, double width) {
        super(color);
        this.height = height;
        this.width = width;

    }

    @Override
    public double getSurface() {
        return height * width;
    }

    @Override
    public double getCircumPerim() {
        return 2 * width + 2 * height;

    }

    @Override
    public double getverticesCount() {
        return 4;

    }

    @Override
    public int getEdgesCount() {
        return 4;
    }

    @Override
    public void print() {
        System.out.printf("Rectangle is %s ", getColor());

    }

}

class Square extends Rectangle {

    Square(String color, double edgeLen) {
        super(color, edgeLen, edgeLen);
    }

    @Override
    public void print() {
        System.out.printf("Square color %s", getColor());
    }
}

class Circle extends GeoObj {

    double radius;

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;

    }

    @Override
    public double getSurface() {
        return PI * 2 * radius;

    }

    @Override
    public double getCircumPerim() {
        return PI * radius * radius;

    }

    @Override
    public double getverticesCount() {
        return 0;

    }

    @Override
    public int getEdgesCount() {
        return 0;
    }

    @Override
    public void print() {
        System.out.printf("Circle is %s ", getColor());

    }

}

class Sphere extends GeoObj {

    private final double radius;

    public Sphere(String color, double radius) {
        super(color);
        this.radius = radius;

    }

    @Override
    public double getSurface() {
        return 4 * PI * radius * radius;

    }

    @Override
    public double getCircumPerim() {
        return 2 * PI * radius;

    }

    @Override
    public double getverticesCount() {
        return 0;

    }

    @Override
    public int getEdgesCount() {
        return 0;
    }

    @Override
    public void print() {
        System.out.printf("Sphere is %s ", getColor());

    }

}

public class Geometry1 {

    static ArrayList<GeoObj> geoList = new ArrayList<>();
    public static final File MY_FILE = new File("input.txt");

    public static void main(String[] args) {

        try {
            Scanner fileInput = new Scanner(MY_FILE);
            while (fileInput.hasNextLine()) {
                try {
                    String line = fileInput.nextLine();
                    System.out.println("the prossing line is: " + line);
                    String[] data = line.split(";");
                    String color = data.length == 1 ? " " : data[1];
                    switch (data[0]) {

                        case "Rectangle": {
                            if (data.length != 4) {
                                System.out.println("Invalid number of data: " + line);
                                continue;
                            }
                            Rectangle r = new Rectangle(data[1], Double.parseDouble(data[2]), Double.parseDouble(data[3]));
                            geoList.add(r);
                        }
                        break;

                        case "Square":
                            if (data.length != 3) {
                                System.out.println("Invalid number of data: " + line);
                                continue;
                            }

                            Square s = new Square(data[1], Double.parseDouble(data[2]));
                            geoList.add(s);

                            break;

                        case "Circle":
                            if (data.length != 3) {
                                System.out.println("Invalid number of data: " + line);
                                continue;
                            }
                            Circle c = new Circle(data[1], Double.parseDouble(data[2]));
                            geoList.add(c);

                            break;

                        case "Point":
                            if (data.length != 2) {
                                System.out.println("Invalid number of data: " + line);
                                continue;
                            }
                            Point p = new Point(data[1]);
                            geoList.add(p);
                            break;

                        case "Sphere":
                            if (data.length != 3) {
                                System.out.println("Invalid number of data: " + line);
                                continue;
                            }
                            Sphere n = new Sphere(data[1], Double.parseDouble(data[2]));
                            geoList.add(n);
                            break;

                        default:
                            System.out.println("Invalid Data in the line: " + line);

                    }

                } catch (NumberFormatException nf) {
                    System.out.println("Number Format Exception: " + nf);

                }
                
            }
            fileInput.close();

        } catch (FileNotFoundException ex) {
            System.out.println("File not found" + ex);
        }
        System.out.println("======================");
        for (GeoObj g : geoList) {

            g.print();
            System.out.println();
            int counter = 1;
            counter++;
            System.out.print(counter +" ");
        }

    }

}
