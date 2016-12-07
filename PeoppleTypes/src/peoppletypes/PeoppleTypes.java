//Elmira
package peoppletypes;

class Person {

    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.equals(" ") || name == null) {

            throw new IllegalArgumentException("name cannot be empty " + name);

        }

        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0 || age > 130) {
            throw new IllegalArgumentException("age has to be betwenn 0-130   " + age);

        }

        this.age = age;
    }

}
class Student extends Person {

    private String program;
    private double gpa;

    Student(String name, int age, String program, double gpa) {
        super(name, age);
        setProgram(program);
        setGpa(gpa);

    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        if (program.equals(" ") || program == null) {

            throw new IllegalArgumentException(" program cannot be empty " + program);

        }
        this.program = program;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        if (gpa < 1.0 || gpa > 4.3) {
            throw new IllegalArgumentException("age has to be betwenn 0-130   " + gpa);

        }

        this.gpa = gpa;
    }

}
 class Teacher extends Person {

    private String subject;
    private int yoe;

    Teacher(String name, int age, String subject, int yoe) {
        super(name, age);
        setSubject(subject);
        setYoe(yoe);
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {

        if (subject.equals(" ") || subject.length()<1) {

            throw new IllegalArgumentException(" program cannot be empty " + subject);

        }
        this.subject = subject;
    }

    public int getYoe() {
        return yoe;
    }

    public void setYoe(int yoe) {
        this.yoe = yoe;
    }

}


public class PeoppleTypes {

    public static void main(String[] args) {
        Person p1 = new Person("elmira", 27);
        Student s1 = new Student ("maria", 22,"Math", 3.2);
        Teacher t1 = new Teacher ("Terry" ,44,"Physic", 20);
        System.out.println(s1.getName() + " "+s1.getProgram());
       
        

    }
    

    

}

