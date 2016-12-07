
public class RandArray {

    public static void main(String[] args) {
        int[] myInt = new int[10];
        for (int i = 0; i < myInt.length; i++) {
            myInt[i] = (int) (Math.random() * 100) + 1;
         
            if (myInt[i] >= 70) {
                System.out.println(" the random number greater than 70: " + myInt[i]);
            }
            if (myInt[i] % 2 == 0 && myInt[i] % 3 == 0 && myInt[i] % 5 == 0) {
               boolean prime = false;
               return;

            } else {
               boolean prime =true;
                System.out.println("Prime NUmber : " + myInt[i]);}

        }
        {
            int i = 2;
            int j = 3;
            int k = i++ + j;
            System.out.printf("k = %d, i =%d, j=%d\n", k, i, j);
        }

    }
}
