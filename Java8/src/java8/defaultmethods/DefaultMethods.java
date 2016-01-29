package java8.defaultmethods;

interface TimeClient {
    void setTime(int hour, int minutes, int seconds);
    void setDate(int day, int month, int year);

    static String getIt() {
        return "1";
    }

    default String testMethod() {
        return "Test default method" + getIt();
    }
}

interface TimeClient2 {
    static String getIt() {
        return "2";
    }

    default String testMethod() {
        return "Test default method " + getIt();
    }
}


interface TimeClient3 extends TimeClient {
    static String getIt() { return "3"; }
    default String testMethod() {
        return "Test default method " + getIt();
    }
}

class CksTimeClient implements TimeClient3 {
    @Override
    public void setTime(int hour, int minutes, int seconds) {

    }

    @Override
    public void setDate(int day, int month, int year) {

    }

    public String testMethodH() {
        //return TimeClient3.super.testMethod();
        return testMethod();
    }
}

public class DefaultMethods {
    public static void main(String[] args) {
        CksTimeClient client = new CksTimeClient();
        System.out.println(client.testMethodH());
    }
}
