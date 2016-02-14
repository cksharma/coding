import java.io.Serializable;

class Customer {
    String name;
    int age;

    Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class Main {
    public static void main(String[] argv) {

        NonFunction nonFunction = (Serializable & NonFunction & Calculator) (x, y)-> new Customer(x, y);

        if (nonFunction instanceof Serializable)
            System.out.println("Serializable");
        if (nonFunction instanceof Calculator)
            System.out.println("Calculator");
    }
}

@FunctionalInterface
interface Calculator {
    Customer calculate(String name, int age);
}

interface  NonFunction{

}