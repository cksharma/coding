package java8.lambdas;

import java.util.function.Supplier;

/**
 * Created by cksharma on 1/29/16.
 */
public class MethodReference {
    public static void main(String[] args) {

        Supplier<Integer> supplier = () -> "Hello World".length();
        System.out.println(supplier.get());

        String cks = "Hello World";
        Supplier<Integer> supplier1 = () -> cks.length();
        System.out.println(supplier1.get());

    }
}
