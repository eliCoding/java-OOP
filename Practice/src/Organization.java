
import java.util.ArrayList;
import java.util.Date;

/*
(The Person, Student, Employee, Faculty, and Staff classes) Design a
class named Person and its two subclasses named Student and Employee.
Make Faculty and Staff subclasses of Employee. A person has a name,
address, phone number, and email address. A student has a class status (freshman,
sophomore, junior, or senior). Define the status as a constant. An employee has
an office, salary, and date hired. Use the MyDate class defined in Programming
Exercise 10.14 to create an object for date hired. A faculty member has office
hours and a rank. A staff member has a title. Override the toString method in
each class to display the class name and the person’s name.
Draw the UML diagram for the classes and implement them. Write a test program
that creates a Person, Student, Employee, Faculty, and Staff, and
invokes their toString() methods.

 */
class MyDate {

    String year;
    String month;
    String day;

    public MyDate(String year, String month, String day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    MyDate() {

    }

}

class Person {

    String name;
    String address;
    int PhoneNumber;
    String emailAddress;

    public Person(String name, String address, int PhoneNumber, String emailAddress) {
        setName(name);
        setAddress(address);
        setPhoneNumber(PhoneNumber);
        setEmailAddress(emailAddress);
    }

    @Override
    public String toString() {
        return String.format("Person:%s %s %d %s ", getName(), getAddress(), getPhoneNumber(), getEmailAddress());

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(int PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

}

class Student extends Person {

    private String freshman;
    private String sophomore;
    private String junior;
    private String senior;

    public Student(String name, String address, int PhoneNumber, String emailAddress, String freshman, String sophomore, String junior, String senior) {
        super(name, address, PhoneNumber, emailAddress);
        this.freshman = freshman;
        this.sophomore = sophomore;
        this.junior = junior;
        this.senior = senior;

    }

    @Override
    public String toString() {
        return String.format("Student:%s %s %d %s %s", getName(), getAddress(), getPhoneNumber(), getEmailAddress(), getFreshman());

    }

    public String getFreshman() {
        return freshman;
    }

    public void setFreshman(String freshman) {
        this.freshman = freshman;
    }

    public String getSophomore() {
        return sophomore;
    }

    public void setSophomore(String sophomore) {
        this.sophomore = sophomore;
    }

    public String getJunior() {
        return junior;
    }

    public void setJunior(String junior) {
        this.junior = junior;
    }

    public String getSenior() {
        return senior;
    }

    public void setSenior(String senior) {
        this.senior = senior;
    }

}

class Employee extends Person {

    String office;
    String salary;
    Date hired;

    MyDate dateHired = new MyDate();

    public Employee(String office, String salary, Date hired, String name, String address, int PhoneNumber, String emailAddress) {
        super(name, address, PhoneNumber, emailAddress);
        this.office = office;
        this.salary = salary;
        this.hired = hired;
    }

    @Override
    public String toString() {
        return String.format("Person:%s %s %d %s ", getName(), getAddress(), getPhoneNumber(), getEmailAddress());

    }
}

class Faculty extends Person {

    double houre;
    int rank;

    public Faculty(double houre, int rank, String name, String address, int PhoneNumber, String emailAddress) {
        super(name, address, PhoneNumber, emailAddress);
        this.houre = houre;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return String.format("Person:%s %s %d %s ", getName(), getAddress(), getPhoneNumber(), getEmailAddress());

    }
}

class Staff extends Person {

    String title;

    public Staff(String title, String name, String address, int PhoneNumber, String emailAddress) {
        super(name, address, PhoneNumber, emailAddress);
        this.title = title;
    }

    @Override
    public String toString() {
        return String.format("Person:%s %s %d %s ", getName(), getAddress(), getPhoneNumber(), getEmailAddress());

    }

}

public class Organization {

    static ArrayList<Person> people = new ArrayList<>();

    public static void main(String[] args) {

        //  Person p = new Person("elmira", "1350 du fort", 2323, "e.amanollahi@gmail.com");
        //   Student t = new Student ("elmira", "1350 du fort", 2323, "e.amanollahi@gmail.com","FreshMan", " "," ", " ");
        //   System.out.println(p.toString()+" \n"+t.toString());
        for (Person p : people) {
            if (p instanceof Employee) {
                Employee e = (Employee) p;
                people.add(p);
                System.out.println("jerry"+e.address+e.dateHired);
            } else if (p instanceof Faculty) {
                Faculty f = (Faculty) p;
                System.out.println("");

            }else if ( p instanceof Student) {
            Student s = (Student) p; 
                System.out.println("  ");
            
            }else if (p instanceof Staff) {
            Staff s1 = (Staff) p;
                System.out.println("   ");
            
            
            }else {
                System.out.println("erorr");
            }

        }

    }

}


