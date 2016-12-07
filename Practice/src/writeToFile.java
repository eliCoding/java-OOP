
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class writeToFile {

    static Scanner input = new Scanner(System.in);
    static final String PERSONTXT = "person.txt";

    public static void main(String[] args) {

        try {
            System.out.print("enter a name:");
            String name = input.nextLine();

            System.out.print("enter an age:");
            int age = input.nextInt();

            input.nextLine();

            System.out.print("enter a city:");
            String city = input.nextLine();

            PrintWriter pw = new PrintWriter(new FileWriter(PERSONTXT));
            pw.printf("%s\n%d\n%s", name, age, city);
            pw.close();

            /*  Scanner inputFile = new Scanner(new File(PERSONTXT));
            while (inputFile.hasNextLine()) {
                String name1 = inputFile.nextLine();
                int age1 = inputFile.nextInt();
                String city1 = inputFile.nextLine();
                inputFile.nextLine();

                System.out.printf("the line is:", "%s\n%d\n%s", name1, age1, city1);

            }
            inputFile.close();*/
        } catch (IOException io) {

            System.out.println("error" + io);
        }

    }

}
