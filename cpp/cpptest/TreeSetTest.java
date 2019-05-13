import java.util.*;

class Person implements Comparable<Person> {
    String name;
    int age;

    @Override
    public int compareTo(Person rhs) {
        System.out.println( "Print the value lhs=" + this +  ", rhs=" + rhs );
        int diff = name.compareTo(rhs.name);
        if( diff != 0 ) return diff;
        return ( age == rhs.age ) ? 0 : age - rhs.age;
    }

    @Override
    public String toString() {
        return "[" + name + ", " + age + "]";
    }

    Person( String name, int age ) {
        this.name = name;
        this.age = age;
    }
}


public class TreeSetTest {

    public static void main(String[] args) {
        Set<Person> tSet = new TreeSet<>();
        tSet.add( new Person("Chandra", 100) );
        tSet.add( new Person("Rajend", 200) );
        tSet.add( new Person("Xyzzzz", 200) );
    }
}