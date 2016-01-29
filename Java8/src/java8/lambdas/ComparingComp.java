package java8.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Person {
    int age;
    String name;
    Person(int age, String name) {
        this.age = age;
        this.name = name;
    }
    public String toString() {
        return age + "->" + name + "\n";
    }
}

public class ComparingComp {
    static int compare(Person p, Person p1) {
        if (p.age != p1.age) return p.age - p1.age;
        return p.name.compareTo(p1.name);
    }

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.addAll(Arrays.asList(   new Person(3, "Hari"),
                                        new Person(1, "Ram"),
                                        new Person(2, "Prasad"),
                                        new Person(2, "Amit")
                ));
        persons.sort( (Person p1, Person p2) -> p1.age - p2.age != 0 ? p1.age - p2.age :
                                                p1.name.compareTo(p2.name));
        System.out.println(persons);

    }
}
