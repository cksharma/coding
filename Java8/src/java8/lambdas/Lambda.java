package java8.lambdas;

import java.util.Arrays;
import java.util.List;

public class Lambda {

    private String printIt(Integer a) {
        return a.toString();
    }

    private String printIt(String s) {
        return s;
    }

    private boolean isEven(int a) {
        return a % 2 == 0;
    }

    private int doubleIt(int a) {
        return a * 2;
    }

    public static void main(String[] args) {

        Lambda lambda = new Lambda();
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<String> strList = Arrays.asList("hello", "world");
        intList.forEach(lambda::printIt);

        int result = intList.stream()
                            .filter(lambda::isEven)
                            .map(e -> e)
                            .reduce(0, (a, b) -> a + b);

        System.out.println(result);
    }
}
