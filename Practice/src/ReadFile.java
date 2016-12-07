
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadFile {

    static File FILE_NAME = new File("people.txt");

    public static void main(String[] args) {
        try {

            Scanner fileInput = new Scanner(FILE_NAME);

            while (fileInput.hasNextLine()) {

                String name = fileInput.nextLine();
                int age = fileInput.nextInt();
                fileInput.nextLine();
                String city = fileInput.nextLine();

                System.out.printf("%s\n%d\n%s",name, age ,city);

            }
            fileInput.close();
        } catch (FileNotFoundException ex) {
            System.err.println("error");
        }

    }

}
