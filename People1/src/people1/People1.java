package people1;

import java.util.ArrayList;

class person {

    person(String n, int a) {
      name = n;
        age = a;
      //  this.name = name;
       // this.age = age;
    }
    String name;
    int age;

}

class person1 {

    String name;
    int age;

}

public class People1 {

    public static void main(String[] args) {

        ArrayList<person> people = new ArrayList<>();
        people.add(new person("Jerry", 33));
        people.add(new person("Maria", 23));
        people.add(new person("ELmira", 13));
        people.add(new person("reza", 43));

        System.out.printf("p[0]: name=%s, age=%d\n",
                people.get(0).name, people.get(0).age);

        System.out.printf("p[1]: name=%s, age=%d\n",
                people.get(0).name, people.get(0).age);

        System.out.printf("p[2]: name=%s, age=%d\n",
                people.get(0).name, people.get(0).age);

        for (int i = 0; i < people.size(); i++)    {                                                                                                                    {

            person p = people.get(i);
            System.out.printf("p[%d]: name %s, age =%d\n", i, p.name, p.age);
        }

        for (person p : people) {

            System.out.printf("p: name = %s, age = %d\n", p.name, p.age);
        }
        //  person p = new person("Jerry", 33);
        // person p1 = new person();

        // person p1 = new person("elmira", 23);
        // p.name = "Jerry";
        // p.age = 33;
        // p1.name = "elmira";
        // p1.age = 23;
        // System.out.printf("p:name = %s, age%d\n", p.name, p.age);
        // System.out.printf("p:name = %s, age%d\n", p1.name, p1.age);
        //toDo: allocate person p1. give it name/age and print out
    }

}
}