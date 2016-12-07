/*HOMEWORK - day 2

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

Exceptions you MUST handle:

Any IOException, and InputMismatchException including when reading a file.   */

import static com.sun.javafx.util.Utils.contains;
import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PeopleListInFile1 {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("1. Add person info\n"
                + "2. List persons info\n"
                + "3. Find a person by name\n"
                + "4. Find all persons younger than age\n"
                + "0. Exit");
        int choice = inputInt("Choice: ");
        if ((choice < 0) || (choice > 4)) {
            System.out.println("Invalid choice.");
            return;
        }
        switch (choice) {
            case 0:
                System.out.println("Bye bye");
                return;
            case 1:
                addPerson();
                break;
            case 2:
                listPersons();
                break;
            case 3:
                findByName();
                break;
            case 4:
                findByMaxAge();
                break;
            default:
                System.out.println("1-800-WEMESSEDUP");
                System.exit(1);
        }
    }

    static int inputInt(String message) {
        for (;;) {
            try {

                System.out.print(message);
                int value = input.nextInt();
                input.nextLine(); // consume left-over new line character
                return value;
            } catch (InputMismatchException ime) {
                input.nextLine(); // consume the invalid input , super important    why with out it infinit?
                System.out.println("Invalid input, try again");
            }
        }
    }

    private static void addPerson() {
        System.out.println("Adding a person.");

        System.out.print("Enter name: ");
        String name = input.nextLine();
        // TODO: use inputInt(); instead
        int age = inputInt("Enter age: ");
        System.out.print("Enter city: ");
        String city = input.nextLine();
        //
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME, true));// true is for appending the lines
            pw.printf("%s\n%d\n%s\n", name, age, city);
            pw.close();
            //
            System.out.println("Person added.");
        } catch (IOException ioe) {
            // ioe.printStackTrace();
            System.out.println("Error writing to file. Person not added.");
        }
    }

    private static final String FILE_NAME = "people.txt";

    private static void listPersons() {
        try {
            File file = new File(FILE_NAME);
            if (file.exists()) {
                Scanner fileInput = new Scanner(file);
                while (fileInput.hasNextLine()) {
                    String name = fileInput.nextLine();
                    int age = fileInput.nextInt();
                    fileInput.nextLine();
                    String city = fileInput.nextLine();
                    System.out.printf("%s is %d from %s\n", name, age, city);
                }
                fileInput.close();
            } else {
                System.out.println("File does not exist");
            }
        } catch (IOException ex) {
            System.out.println("Error reading file");
        }
    }

    private static void findByName() {
        try {
            File file = new File(FILE_NAME);
            if (file.exists()) {
                Scanner fileInput = new Scanner(file);
                System.out.println("Please enter the partial name: ");
                String s = input.nextLine();
                while (fileInput.hasNextLine()) {
                    String name = fileInput.nextLine();
                    int age = fileInput.nextInt();
                    fileInput.nextLine();
                    String city = fileInput.nextLine();
                    if (contains(name, s)) {
                        System.out.printf("%s is %d from %s\n", name, age, city);
                    }
                }
                fileInput.close();
            } else {
                System.out.println("File does not exist");
            }
        } catch (IOException ex) {
            System.out.println("Error reading file");
        }
    }

    private static void findByMaxAge() {
        try {
            File file = new File(FILE_NAME);
            if (file.exists()) {
                Scanner fileInput = new Scanner(file);
                System.out.println("Please enter age: ");
                int a = input.nextInt();
                while (fileInput.hasNextLine()) {
                    String name = fileInput.nextLine();
                    int age = fileInput.nextInt();
                    fileInput.nextLine();
                    String city = fileInput.nextLine();
                    if (age < a) {
                        System.out.printf("%s is %d from %s\n", name, age, city);
                    }
                }
                fileInput.close();
            } else {
                System.out.println("File does not exist");
            }
        } catch (IOException ex) {
            System.out.println("Error reading file");
        }
    }
}
