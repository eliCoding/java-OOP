/*TASK day 03

Create project PeopleFromFile.

In the main directory of your project create file "people.txt"
using Notepad (or Notepad++) and manually add the following lines to it:

Jerry
33
Mary
22
Liroy
55
Terry
34


In the PeopleFromFile class add field:

static ArrayList<Person> people = new ArrayList<>();

In the main method of your project add code to:

1. Open "people.txt" file and read its contents line by line.
Assume odd lines (1,3,5,...) contain names
and that even lines (2,4,6,...) contain numbers (age).

For each pair of lines your program reads instantiate
class Person using a constructor that takes name and age.

Add each instance of Person to people ArrayList.

2. Using for-each loop print out each of Person objects
from people ArrayList.

*/


package peoplefromfile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Person {

    Person(String n, int a) {
        name = n;
        age = a;
    }
    String name;
    int age;
}

public class PeopleFromFile {

    final static String FILE_NAME = "people.txt";

    static ArrayList<Person> people = new ArrayList<>();

    public static void main(String[] args) {
        try {
            Scanner fileInput = new Scanner(new File(FILE_NAME));
            while (fileInput.hasNextLine()) {
                String name = fileInput.nextLine();
                int age = fileInput.nextInt();
               fileInput.nextLine();
                //
                //  System.out.println("p: "+name +" "+age);

              //  Person p = new Person(name, age);

               // people.add(p);
               people.add(new Person (name,age));
            }
            fileInput.close();
            //
            for (Person p : people) {
                System.out.printf("p: name=%s, age=%d\n",
                        p.name, p.age);
            }

        } catch (IOException e) {
            System.err.println("Error reading file");
        } catch (InputMismatchException e) {
            System.err.println("Error: file contents mismatch");
        }
    }

}
