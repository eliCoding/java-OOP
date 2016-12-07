

/* Laurian Staicu 1696177
* IPD 9 
*/
import java.util.Calendar;
import java.util.GregorianCalendar;
public class NewMain {

   public static void main(String[] args) {

       MyDate date1 = new MyDate();
       MyDate date2 = new MyDate(34333101L);

       System.out.println("Date1 - Month: " + date1.getMonth() +
               " Day: " + date1.getDay() + " Year: " + date1.getYear());
       System.out.println("Date2 - Month: " + date2.getMonth() +
               " Day: " + date2.getDay() + " Year: " + date2.getYear());

   }
}
class MyDate {

   private int year;
   private int month;
   private int day;

   public MyDate() {

       GregorianCalendar cal = new GregorianCalendar();
       year = cal.get(Calendar.YEAR);
       month = cal.get(Calendar.MONTH);
       day = cal.get(Calendar.DAY_OF_MONTH);

   }

   public MyDate(long elapsedTime) {
       GregorianCalendar cal = new GregorianCalendar();
       cal.setTimeInMillis(elapsedTime);
       year = cal.get(Calendar.YEAR);
       month = cal.get(Calendar.MONTH);
       day = cal.get(Calendar.DAY_OF_MONTH);
   }

   public MyDate(int year, int month, int day) {
       this.year = year;
       this.month = month;
       this.day = day;
   }

   public int getYear() {
       return year;
   }

   public void setYear(int year) {
       this.year = year;
   }

   public int getMonth() {
       return month;
   }

   public void setMonth(int month) {
       this.month = month;
   }

   public int getDay() {
       return day;
   }

   public void setDay(int day) {
       this.day = day;
   }

   public void setDate(long elapsedTime) {
       GregorianCalendar cal = new GregorianCalendar();
       cal.setTimeInMillis(elapsedTime);
       year = cal.get(Calendar.YEAR);
       month = cal.get(Calendar.MONTH);
       day = cal.get(Calendar.DAY_OF_MONTH);
   }
}


