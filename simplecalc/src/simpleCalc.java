
import java.util.Scanner;

public class simpleCalc {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Add\n"
                    + "2. Subtract\n"
                    + "3. Multiply\n"
                    + "4. Divide\n"
                    + "0. Exit\n");
            int choice = input.nextInt();
            if ((choice < 0) || (choice > 4)) {
                System.out.println("Invalid choice");
                continue;
            }
            if (choice == 0) {
                System.out.println("Bye bye");
                return;
            }
            //
            System.out.println("Enter two floating point values");
            double v1 = input.nextDouble();
            double v2 = input.nextDouble();

            double result = 0;
            switch (choice) {
                case 1:
                    result = v1 + v2;
                    break;
                case 2:
                    result = v1 - v2;
                    break;
                case 3:
                    result = v1 * v2;
                    break;
                case 4:
                    result = v1 / v2;
                    break;
                default:
                    System.err.println("Fatal error: invalid control flow");
                    System.exit(1);
            }
            System.out.printf("Result is: %.4f", result);
        }
    }

}