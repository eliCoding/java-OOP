package countme;

/* TASK: implement method
    public int getUniqueId() {}
    that will return a unique, consecutive ID number for every box created
    IOW. 1st box will have ID=1, 2nd ID=2, and so on.
    Note: You must NOT add parameters to constructor
 */
class Box {

    static int count;
     int uniqeId;

    Box() {
        count++;
        uniqeId = count;

    }
    // int value;

    public static int getCount() {
        return count;
    }

    public int getUniqueId() {
        return uniqeId;

    }
}

public class CountMe {

    public static void main(String[] args) {
        System.out.println("Count is: " + Box.getCount());
        Box b1 = new Box();
        Box b2 = new Box();
        Box b3 = new Box();
        System.out.println("b1 id is: " + b1.getUniqueId());
        System.out.println("b1 id is: " + b2.getUniqueId());
        System.out.println("b1 id is: " + b3.getUniqueId());
        System.out.println("Count is" + Box.getCount());

    }

}
