package demandingpeople;

class Person {

    Person(String n, int a) {
        setName(n);
        setAge(a);
    }
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    // TODO: throw exception if name is null or empty
    public void setName(String name) {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("Name must not be empty");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 1 || age > 150) {
            throw new IllegalArgumentException("Age must be between 1-150");
        }
        this.age = age;
    }
}

public class DemandingPeople {

    public static void main(String[] args) {
        try {
            Person p = new Person("Jerry", 33);
//            p.setAge(101);
//            p.setName("Jerry P");
            System.out.printf("p: name=%s, age=%d\n", p.getName(), p.getAge());
        } catch (IllegalArgumentException ipe) {
            System.err.println("Invalid operation: " + ipe.getMessage());
        }
    }
}