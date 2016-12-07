
import java.util.Scanner;

public class Practice {

    public static void main(String[] args) {
        
        int n = 10;
        System.out.println(n++);
        System.out.println(++n);
        
        
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a number(a):");
        int a = input.nextInt();

        System.out.println("Please enter a number(b):");
        int b = input.nextInt();

        int sum = 0;
        int sum1 = 0;

        for (int i = 0; i < b; i++) {
            sum = sum + a;

            System.out.println("result is : " + sum);

        }

        System.out.println("   ");

        sum1 = a - sum1;
        for (int i = 0; i < a; i++) {

            sum1 = sum1 - b;
            if (sum1 < 0) {
                break;
            }

            System.out.println(" result is: " + sum1);
        }

    }
}
