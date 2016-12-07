
import static com.sun.javafx.util.Utils.contains;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


/*/*HOMEWORK - day 2

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
public class Practice1 {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Add person info\n"
                    + "2. List persons info\n"
                    + "3. Find a person by name\n"
                    + "4. Find all persons younger than age\n"
                    + "0. Exit");
            System.out.println("enter a choice:");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    addPerson();
                    break;
                case 2:
                    listPerson();
                    break;
                case 3:
                    findByName();
                    break;
                case 4:
                    findbyAge();
                    break;

                default:
                    System.out.println("fatal error");
                    System.exit(1);
            }
        }
    }

    private static void addPerson() {
        input.nextLine();
        System.out.print("enter a name:");
        String name = input.nextLine();

        System.out.print("enter a age:");
        int age = input.nextInt();
        input.nextLine();

        System.out.print("enter a city:");
        String city = input.nextLine();

        try {
            PrintWriter pw = new PrintWriter(new FileWriter(MY_FILE, true));
            //  System.out.printf("%s\n%d\n%s\n", name, age, city);  hatman pw.printf!!!!!!!
            pw.printf("%s\n%d\n%s\n", name, age, city);
            pw.close();
            System.out.println("person added.");
        } catch (IOException io) {
            System.out.println("error" + io);
        }

    }
    public static final String MY_FILE = "person1.txt";

    private static void listPerson() {

        try {
            Scanner fileInput = new Scanner(new File(MY_FILE));
            while (fileInput.hasNextLine()) {
                String name = fileInput.nextLine();
                int age = fileInput.nextInt();
                fileInput.nextLine();
                String city = fileInput.nextLine();
                System.out.printf("%s is %d  years old from %s\n", name, age, city);

            }
            fileInput.close();

        } catch (FileNotFoundException fn) {

            System.out.println("file not found" + fn);
        }

    }

    private static void findByName() { //?
        try {
            File file = new File(MY_FILE);
            if (file.exists()) {
                Scanner fileInput = new Scanner(file);
                System.out.println("please enter partial:");
                String s = input.nextLine();

                while (fileInput.hasNextLine()) {
                    String name = fileInput.nextLine();
                    int age = fileInput.nextInt();
                    fileInput.nextLine();
                    String city = fileInput.nextLine();

                    if (contains(name, s)) {
                       
                        System.out.printf("%s is %d  years old from %s\n", name, age, city);

                    }
                }
                fileInput.close();
            } else {
                System.out.println("file does not exist!");
            }

        } catch (FileNotFoundException fn) {

            System.out.println("file not found" + fn);
        }

    }

    private static void findbyAge() {
         try {
            File file = new File(MY_FILE);
            if (file.exists()) {
                Scanner fileInput = new Scanner(file);
                System.out.println("please enter age:");
                int a  = input.nextInt();

                while (fileInput.hasNextLine()) {
                    String name = fileInput.nextLine();
                    int age = fileInput.nextInt();
                    fileInput.nextLine();
                    String city = fileInput.nextLine();

                    if (age <a) {
                       
                        System.out.printf("%s is %d  years old from %s\n", name, age, city);

                    }
                }
                fileInput.close();
            } else {
                System.out.println("file does not exist!");
            }

        } catch (FileNotFoundException fn) {

            System.out.println("file not found" + fn);
        }

    }

}
