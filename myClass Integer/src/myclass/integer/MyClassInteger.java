/*
/*
10.3 (The MyInteger class) Design a class named MyInteger. The class contains:
¦ An int data field named value that stores the int value represented by this
object.
¦ A constructor that creates a MyInteger object for the specified int value.
¦ A getter method that returns the int value.
¦ The methods isEven(), isOdd(), and isPrime() that return true if the
value in this object is even, odd, or prime, respectively.
¦ The static methods isEven(int), isOdd(int), and isPrime(int) that
return true if the specified value is even, odd, or prime, respectively.
¦ The static methods isEven(MyInteger), isOdd(MyInteger), and
isPrime(MyInteger) that return true if the specified value is even, odd,
or prime, respectively.
¦ The methods equals(int) and equals(MyInteger) that return true if
the value in this object is equal to the specified value.
¦ A static method parseInt(char[]) that converts an array of numeric
characters to an int value.
¦ A static method parseInt(String) that converts a string into an int
value.
Draw the UML diagram for the class and then implement the class. Write a client
program that tests all methods in the class.

 */
package myclass.integer;

class MyInteger {

    private int value;

    public MyInteger(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean isEven() {
        if (value % 2 == 0) {
            return true;
        }
        return false;

    }

    public boolean isOdd() {
        if (value % 2 != 0) {
            return true;
        }
        return false;

    }

    public boolean isPrime() {
        int factor = 0;
        for (factor = 2; factor <= value / 2; factor++) {
            if (value % factor != 0) {
                return true;
            }
        }
        return false;
    }

    public boolean isEven(int value) {
        if (value % 2 == 0) {
            return true;
        }
        return false;
    }

    public boolean isOdd(int value) {
        if (value % 2 != 0) {
            return true;
        }
        return false;

    }

    public boolean isPrime(int value) {

        return isPrime(value);
    }

    public boolean isEven(MyInteger myInt) {
        return myInt.isEven(myInt.getValue());

    }

    public boolean isOdd(MyInteger myInt) {
        return myInt.isOdd(myInt.getValue());

    }

    public boolean isPrime(MyInteger myInt) {

        return myInt.isPrime(myInt.getValue());
    }

    public boolean equals(int intValue) {
        return value == intValue;

    }


    public boolean equals(MyInteger myInt) {
        return equals(myInt.getValue());
    }
//A static method parseInt(char[]) that converts an array of numeric characters to an int value.
  //  public static int parseInt(char[] c) {
      //   return Integer.parseInt(c);
    
   // }
    
 //A static method parseInt(String) that converts a string into an int value.   
    public static int parseInt(String s) {
        return Integer.parseInt(s);
    }

}

public class MyClassInteger {

    public static void main(String[] args) {

    }

}
