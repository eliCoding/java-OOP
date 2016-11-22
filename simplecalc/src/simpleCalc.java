
import java.util.Scanner;

public class simpleCalc {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = 0;
        float k = 0;
        float j = 0;
        System.out.println("-------------");
        System.out.println("1.Add");
        System.out.println("2.Subtract");
        System.out.println("3.Multiply");
        System.out.println("4.Divide");
        System.out.println("exit the system!");
        System.out.println("----------------");
        System.out.println("Please enter a number:");
        n = input.nextInt();
        System.out.println("the number that you entered is: " + n);
        
        
        
        do {

            switch (n) {
                case 1:
                    System.out.println("1.Add");
                    System.out.println("Please enter your number:");
                    k = input.nextFloat();
                    j = input.nextFloat();
                    System.out.printf( "the sum of two float numbers:"+k+j);
                    break;
                case 2:
                    System.out.println("2.Subtract");
                    System.out.println("Please enter your number:");
                    k = input.nextFloat();
                    j = input.nextFloat();
                    float p = k - j;
                    System.out.printf("the Subtract is: " + p);
                    break;
                case 3:
                    System.out.println("3.Multiply");
                    k = input.nextFloat();
                    j = input.nextFloat();
                    float m = k*j;
                    System.out.printf("the Multiply is: " + m);
                    break;
                case 4:
                    System.out.println("4.Divide");
                    k = input.nextFloat();
                    j = input.nextFloat();
                    float d = k/j;
                    System.out.printf("the Divide is: %.4f: " + d);
                    break;
                default:
                    System.out.println("exit the system!");
                    break;
            }
            break;
            
           
        } while (n < 5);
        
        

    }

}
