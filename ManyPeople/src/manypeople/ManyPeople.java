/*
TASK - EXTEND ManyPeople

In the main directory of your project, using Notepad++
create file "people.txt" with the following contents:

Person;Jerry;23
Teacher;Randy;66;PhysEd;33
Person;Timmy;44
Student;Mary;34;Nursing;4.1
Student;Martin;31;Math;4.0
Teacher;Larry;51;Physics;22

In the main() method of your program
write code that will read this file line by line
and will instantiate the correct class
and add it to ArrayList

static ArrayList<Person> people = new ArrayList<>();

If you encounter a line that does not conform to requirements then warn user, ignore it and continue to next line.

Once all lines have been parsed and added to "people" ArrayList write a for loop that will display all data for each element of the list, for example:

Student Mary is 34 studying Nursing with GPA 4.1

Hint: use instanceof operator figure out the actual type of the object you're looking at.

PART 2:
Give each of 3 classes a toString() method that returns string describing data in object instance.

Rewrite your for loop code to use polymorphism instead of instanceof. 
 */
package manypeople;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Person {

    private String name;
    private int age;

    Person(String name, int age) {
        setName(name);
        setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.equals(" ") || name.length()<1) {

            throw new IllegalArgumentException("name cannot be empty " + name);

        }

        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0 || age > 130) {
            throw new IllegalArgumentException("age has to be betwenn 0-130   " + age);

        }

        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Person: %s,%d\n", getName(), getAge());

    }

}

class Student extends Person {

    private String program;
    private double gpa;

    Student(String name, int age, String program, double gpa) {
        super(name, age);
        setProgram(program);
        setGpa(gpa);

    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        if (program.equals(" ") || program.length()<1) {

            throw new IllegalArgumentException(" program cannot be empty " + program);

        }
        this.program = program;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        if (gpa < 1.0 || gpa > 4.3) {
            throw new IllegalArgumentException("gpa has to be betwenn  " + gpa);

        }

        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return String.format("Student: %s, %s y/o in %s gpa %.2f\n", getName(), getAge(), getProgram(), getGpa());

    }

}

class Teacher extends Person {

    private String subject;
    private int yoe;

    Teacher(String name, int age, String subject, int yoe) {
        super(name, age);
        setSubject(subject);
        setYoe(yoe);
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {

        if (subject.equals(" ") || subject == null) {

            throw new IllegalArgumentException(" program cannot be empty " + subject);

        }
        this.subject = subject;
    }

    public int getYoe() {
        return yoe;
    }

    public void setYoe(int yoe) {
        this.yoe = yoe;
    }

    @Override
    public String toString() {
        return String.format("Teacher: %s,%d,%s,%d\n", getName(), getAge(), getSubject(), getYoe());

    }

}

public class ManyPeople {

    static ArrayList<Person> people = new ArrayList<>();

    static File FILE_NAME = new File("people.txt");

    public static void main(String[] args) {

        try {
            int counter = 0;
            Scanner fileInput = new Scanner(FILE_NAME);

            while (fileInput.hasNextLine()) {

                String fileLine = fileInput.nextLine();
                counter++;
                String[] data = fileLine.split(";");
                switch (data[0]) {
                    case "Person":
                        Person p = new Person(data[1], Integer.parseInt(data[2]));
                        people.add(p);
                        break;
                    case "Teacher":
                        Teacher t = new Teacher(data[1], Integer.parseInt(data[2]), data[3], Integer.parseInt(data[4]));
                        people.add(t);
                        break;
                    case "Student":
                        Student s = new Student(data[1], Integer.parseInt(data[2]), data[3], Double.parseDouble(data[4]));
                        people.add(s);
                        break;
                    default:
                        System.out.println("I get an Invalid data in line:" + counter);
                        continue;

                }

            }
            fileInput.close();
        } catch (FileNotFoundException fn) {
            System.err.println("Skipping invalid input line: " + fn);
//Student Mary is 34 studying Nursing with GPA 4.1
        }
       for (Person p : people) {

            if (p instanceof Student) {
                Student s = (Student) p;
                System.out.printf("Student: %s,%s  in %s gpa %.2f\n", s.getName(), s.getAge(), s.getProgram(), s.getGpa());
            } else if (p instanceof Teacher) {
                Teacher t = (Teacher) p;
                System.out.printf("Teacher:%s,%d,%s,%d\n", t.getName(), t.getAge(), t.getSubject(), t.getYoe());
            } else if (p instanceof Person) {
                System.out.printf("Person %s,%d\n", p.getName(), p.getAge());
            } else {
                System.out.println("1-800-wemessedup");
            }
        }

        //polymorphism // without toString we just have the refrence of the String
        for (Person p : people) {

            System.out.println(p);
        }

    }

}
