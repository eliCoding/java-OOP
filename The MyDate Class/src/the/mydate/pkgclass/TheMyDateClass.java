/*
The MyDate class) Design a class named MyDate. The class contains:
¦ The data fields year, month, and day that represent a date. month is
0-based, i.e., 0 is for January.
¦ A no-arg constructor that creates a MyDate object for the current date.
¦ A constructor that constructs a MyDate object with a specified elapsed time
since midnight, January 1, 1970, in milliseconds.
¦ A constructor that constructs a MyDate object with the specified year,
month, and day.
¦ Three getter methods for the data fields year, month, and day, respectively.
¦ A method named setDate(long elapsedTime) that sets a new date for
the object using the elapsed time.
Draw the UML diagram for the class and then implement the class. Write a
test program that creates two MyDate objects (using new MyDate() and new
MyDate(34355555133101L)) and displays their year, month, and day.
(Hint: The first two constructors will extract the year, month, and day from
the elapsed time. For example, if the elapsed time is 561555550000 milliseconds,
the year is 1987, the month is 9, and the day is 18. You may use the
GregorianCalendar class discussed in Programming Exercise 9.5 to simplify
coding.)

 */
package the.mydate.pkgclass;

import java.util.Calendar;
import java.util.GregorianCalendar;

class MyDate {

    private int year;
    private int day;
    private int month;

   

    MyDate(int year, int month, int day) {
        setYear(year);
        setDay(day);
        setMonth(month);
    }
 MyDate() {
        
    }
    public void setDate(long elapsedTime) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTimeInMillis(elapsedTime);
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DAY_OF_MONTH);

    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

}

public class TheMyDateClass {

    public static void main(String[] args) {
        MyDate m = new MyDate(1989, 07, 07);
       m.setDate(110);
        System.out.println(m.getMonth());
       
      

    }

}
