package java8.lambdas;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by cksharma on 1/23/16.
 */
public class Addition {

    static class Person {
        public String name;
        public int age;
        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(   new Person("Ram", 10),
                                                new Person("Hari", 12),
                                                new Person("Ram", 12),
                                                new Person("Hari", 15));

        PriorityQueue<Person> queue = new PriorityQueue<Person>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                int temp = o1.name.compareTo(o2.name);
                return temp != 0 ? temp : o1.age - o2.age;
            }
        });
        for (Person person : persons) queue.add(person);
        for (Person person : queue) System.out.println(person);
        while (queue.isEmpty() == false) {
            System.out.println(queue.poll());
        }
    }
}
