/*QUIZ 1 - IPD-9 - Programming II (Java 2)

Create project Quiz1Students

You will perform operations on data in file named "students.txt",
similar to what you did for your homework.

Example session:
1. Add student and their GPA
2. List all students and their GPAs
3. Find all students whose name begins with a letter
4. Find the average GPA of all students and display it.
0. Exit
Choice: 1

Adding a student.
Enter student's name: Jerry Boe
Enter student's GPA: blue
Invalid input
Enter student's GPA: 55
GPA must be between 0 and 4.3 maximum.
Enter student's GPA: 4.1
Student added.

1. Add student and their GPA
2. List all students and their GPAs
3. Find all students whose name begins with a letter
4. Find the average GPA of all students and display it.
0. Exit
Choice: blah
Invalid input
Choice: 1

Adding a student.
Enter student's name: Mimi Mo
Enter student's GPA: 4.3
Student added.

1. Add student and their GPA
2. List all students and their GPAs
3. Find all students whose name begins with a letter
4. Find the average GPA of all students and display it.
0. Exit
Choice: 7
Invalid choice, try again.
Choice: 2

Listing all students
Jerry Boe has GPA 4.1
Mimi Mo has GPA 4.3

1. Add student and their GPA
2. List all students and their GPAs
3. Find all students whose name begins with a letter
4. Find the average GPA of all students and display it.
0. Exit
Choice: 3

Enter first letter of student name (only one letter): abc
Invalid input, try again.
Enter first letter of student name (only one letter): m
Listing students whose names begin with letter m (case insensitive):
Mimi Mo has GPA 4.3

1. Add student and their GPA
2. List all students and their GPAs
3. Find all students whose name begins with a letter
4. Find the average GPA of all students and display it.
0. Exit
Choice: 4

The average GPA of all students is 4.2
If you would like to save it to a file, provide file name (empty to skip): avg.txt
Saved 4.2 to avg.txt

1. Add student and their GPA
2. List all students and their GPAs
3. Find all students whose name begins with a letter
4. Find the average GPA of all students and display it.
0. Exit
Choice: 0

Good bye

Contents of "students.txt" file after the above session will be:
Jerry Boe
4.1
Mimi Mo
4.3

Contents of "avg.txt" file will be:
4.2


NOTES:
* You must handle all IOException, InputMismatchException.
* When operating on numerical types you must use appropriate
numerical type, not string for it
* Show all GPA's with 1 decimal point, so 3.0, not 3

WHAT TO SUBMIT:
* In Lea upload only Quiz1Students.java file as your solution.
* Do NOT post your solution on the forum.
* Do NOT email your solution to the teacher.



 */
package quiz1students;

import static com.sun.javafx.util.Utils.contains;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.MissingFormatArgumentException;

public class Quiz1Students {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("1. Add student and their GPA \n"
                + "2. List all students and their GPAs\n"
                + "3. Find all students whose name begins with a letter Find a person by name\n"
                + "4. Find the average GPA of all students and display it.\n"
                + "0. Exit");

        int choice = (int) inputInt("Choice: ");
        if ((choice < 0) || (choice > 4)) {
            System.out.println("Invalid choice.try again");
            return;
        }

        switch (choice) {
            case 0:
                System.out.println("Bye bye");
                return;
            case 1:
                addStudents();
                break;
            case 2:
                listStudents();
                break;
            case 3:
                findByName();
                break;
            case 4:
                findAverageGpa();
                break;
            default:
                System.out.println("1-800-WEMESSEDUP");
                System.exit(1);
        }
    }

    static double inputInt(String message) {
        for (;;) {
            try {

                System.out.print(message);
                double value = input.nextDouble();
                input.nextLine(); // consume left-over new line character

                return value;
            } catch (InputMismatchException ime) {
                input.nextLine(); // consume the invalid input
                System.out.println("Invalid input.");
            }

            try {

                double value = input.nextDouble();
                input.nextLine(); // consume left-over new line character

                return value;

            } catch (MissingFormatArgumentException mm) {
                input.nextLine(); // consume the invalid input
                System.out.println("Invalid input.");
            }

        }
    }

    private static void addStudents() {
        System.out.println("Adding a student.");

        System.out.print("Enter student's name: ");
        String name = input.nextLine();
        // TODO: use inputInt(); instead
        int gpa = (int) inputInt("Enter student's GPA: ");
        if ((gpa < 0) || (gpa > 4.4)) {
            System.out.println("Invalid choice.");
            return;
        }

        //
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME, true));// true is for appending the lines
            pw.printf("%s\n%d\n", name, gpa);
            pw.close();
            //
            System.out.println("Student added.");
        } catch (IOException ioe) {
            // ioe.printStackTrace();
            System.out.println("Error writing to file.Student not added.");
        }
    }

    private static final String FILE_NAME = "students.txt";

    private static void listStudents() {
        try {
            File file = new File(FILE_NAME);
            if (file.exists()) {
                Scanner fileInput = new Scanner(file);
                while (fileInput.hasNextLine()) {
                    String name = fileInput.nextLine();
                    int gpa = fileInput.nextInt();
                    fileInput.nextLine();

                    System.out.printf("%s Gpa is %d \n", name, gpa);
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
                System.out.println("Enter first letter of student name (only one letter): ");
                String s = input.nextLine();
                while (fileInput.hasNextLine()) {
                    String name = fileInput.nextLine();
                    int gpa = fileInput.nextInt();
                    fileInput.nextLine();

                    if (contains(name, s.substring(0))) {
                        System.out.printf("%s Gpa is %d \n", name, gpa);
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

    private static void findAverageGpa() {
        System.out.print("Enter student's name: ");
        String name1 = input.nextLine();
        // TODO: use inputInt(); instead
        int gpa1 = (int) inputInt("Enter student's GPA: ");
        try {
            PrintWriter pw = new PrintWriter(new FileWriter("avg.txt", true));// true is for appending the lines
            pw.printf("%s\n%d\n", name1, gpa1);
            pw.close();
            //
            System.out.println("Student added.");
        } catch (IOException ioe) {
            // ioe.printStackTrace();
            System.out.println("Error writing to file.Student not added.");
        }

        try {
            File file = new File("avg.txt");
            if (file.exists()) {
                Scanner fileInput = new Scanner(file);
                System.out.println("Find the average GPA of all students and display it: ");

                while (fileInput.hasNextLine()) {
                    String name = fileInput.nextLine();
                    int gpa = fileInput.nextInt();
                    fileInput.nextLine();

                    double total = 0;
                    double count = 0;
                    total = total + gpa;
                    double average = total / count;

                    System.out.printf("%s Gpa is %d \n", name, average);
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
