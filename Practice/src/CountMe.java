/* TASK: implement method
    public int getUniqueId() {}
    that will return a unique, consecutive ID number for every box created
    IOW. 1st box will have ID=1, 2nd ID=2, and so on.
    Note: You must NOT add parameters to constructor
 */
class Box {

    static int count;
    int uniqueId;

    Box() {
        count++;
        uniqueId = count;
    }

    public static int getCount() {
        return count;
    }

    public int getUniqueId() {
        return uniqueId;
    }

}

public class CountMe {

    public static void main(String[] args) {
        System.out.println(Box.getCount());
        Box b1 = new Box();
        Box b2 = new Box();
        Box b3 = new Box();
        System.out.println(" the number of box is: " + b1.getUniqueId());
        System.out.println(" the number of box is: " + b2.getUniqueId());
        System.out.println(" the number of box is: " + b3.getUniqueId());
        System.out.println(Box.getCount());

    }

}
