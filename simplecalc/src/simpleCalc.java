/*Ask user to choose an option from menu:
1. Add
2. Subtract
3. Multiply
4. Divide

If user enters an invalid choice, display error message and exit.

Otherwise ask user for 2 floating point values,
perform the needed computation and display the result.

BONUS: Add one more option to the menu.
0. Exit

And add a loop around the entire program so that
the menu is displayed repeatedly until user asks to exit.

Suggestion: instead of do-while loop use
an infinite loop and a break/return.
 */
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
            System.out.printf("Result is: %.4f\n", result);
        }
    }

}
