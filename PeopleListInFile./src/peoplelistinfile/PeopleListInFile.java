/*
HOMEWORK - day 2

Create project PeopleListInFile

You will display a menu to the user:
1. Add person info
2. List persons info
3. Find a person by name
4. Find all persons younger than age
0. Exit

You will implement functions to manage contents of file "people.txt".

Example session

What do you want to do?
1. Add person info
2. List persons info
3. Find and list a person by name
4. Find and list persons younger than age
0. Exit
Choice: 1

Adding a person.
Enter name: Jerry
Enter age: 22
Enter city: Montreal
Person added.

What do you want to do?
1. Add person info
2. List persons info
3. Find a person by name
4. Find all persons younger than age
0. Exit
Choice: 1

Adding a person.
Enter name: Maria
Enter age: 26
Enter city: Toronto
Person added.

What do you want to do?
1. Add person info
2. List persons info
3. Find a person by name
4. Find all persons younger than age
0. Exit
Choice: 2

Listing all persons
Jerry is 22 from Montreal
Maria is 26 from Toronto

What do you want to do?
1. Add person info
2. List persons info
3. Find a person by name
4. Find all persons younger than age
0. Exit
Choice: 3

Enter partial person name:
ri
Matches found:
Maria is 26 from Toronto

What do you want to do?
1. Add person info
2. List persons info
3. Find a person by name
4. Find all persons younger than age
0. Exit
Choice: 4

Enter maximum age:
25
Matches found:
Jerry is 22 from Montreal

What do you want to do?
1. Add person info
2. List persons info
3. Find a person by name
4. Find all persons younger than age
0. Exit
Choice: 0

Good bye!



Result data file will have the following contents.
Jerry
22
Montreal
Maria
26
Toronto


NOTE: If you run your program again you will operate
on data you already have, example:

What do you want to do?
1. Add person info
2. List persons info
3. Find a person by name
4. Find all persons younger than age
0. Exit
Choice: 2

Listing all persons
Jerry is 22 from Montreal
Maria is 26 from Toronto


NOTE: You do NOT need to and are not allowed to
store data in memory in array or ArrayList.
You must read file every time.

 */
package peoplelistinfile;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.InputMismatchException;

public class PeopleListInFile {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        try {
            while (true) {
                Menu();
                System.out.println("Please Enter Your Choice:");
                int choice = input.nextInt();
                System.out.println("Your Choice is:" + choice);

                if ((choice < 0) || (choice > 5)) {
                    System.out.println("Invalid choice");
                    continue;
                }
                if (choice == 0) {
                    System.out.println("Good bye");
                    break;
                }
                switch (choice) {

                    case 1:
                        Case1();
                        break;

                    case 2:
                        Case2();
                        break;

                    case 3:
                        System.out.println(" Enter partial person name:");

                }
            }
        } catch (InputMismatchException mm) {
            input.nextLine(); // consume the invalid input
            System.out.println("Invalid input, try again");
        }

    }

    static int InputAge(String message) {

        for (;;) {
            try {
                System.out.println(message);
                int value = input.nextInt();
                input.nextLine(); // consume left-over new line character
                return value;
            } catch (InputMismatchException mm) {
                input.nextLine(); // consume the invalid input
                System.out.println("Invalid input, try again");
            }
        }

    }

    static void Menu() {
        System.out.println("what do you want to do?\n"
                + "1. Add person info\n"
                + "2. List persons info\n"
                + "3. Find a person by name\n"
                + "4. Find all persons younger than age\n"
                + "0. Exit");

    }

    static void Case1() throws IOException {

        System.out.println("Adding a person:");
        input.nextLine();
        System.out.println("Enter name:");
        String name = input.nextLine();

        int age = InputAge("Enter your age:");

        System.out.println("Enter city:");
        String city = input.nextLine();

        System.out.println("Person added.");
        System.out.println("  ");
        Menu();
        System.out.println("Adding a person:");

        System.out.println("Enter name:");
        String name1 = input.nextLine();

        int age1 = InputAge("Enter your age:");

        System.out.println("Enter city:");
        String city1 = input.nextLine();

        System.out.println("Person added.");
        PrintWriter pw = (new PrintWriter(new FileWriter("people.txt")));
        pw.printf("%s is %d years old lives in %s\n", name, age, city);
        pw.printf("%s is %d years old lives in %s", name1, age1, city1);
        pw.close();
    }

    static void Case2() throws IOException {
        Scanner fileInput = new Scanner(new File("people.txt"));
        String fileLine = fileInput.nextLine();
        String fileLine1 = fileInput.nextLine();

        System.out.println("The list is:\n " + fileLine + "\n" + fileLine1);
        fileInput.close();

    }

}
