package java8.lambdas;

import java.util.function.Predicate;

public class PredicateTest {
    public static void main(String[] args) {
        Predicate<String> i = (s) -> s.length() < 5;
        Predicate<String> i2 = s -> s.startsWith("CKS");

        System.out.println(i.test("CKS"));

        System.out.println(i.and(i2).test("CKS"));

        System.out.println(i.or(i2).test("1CKS"));

        Predicate p1 = Predicate.isEqual("CKS");
        System.out.println(p1.test("CKS1"));


    }
}
