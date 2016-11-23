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
