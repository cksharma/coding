package easy;

public class Main {
    public static void main(String[] args) {
        String str1 = "abcd";
        String str2 = "abcd";
        String str3 = new String("abcd");
        //System.out.println(str1 == str2);
        //System.out.println(str1 == str3);

        String s1 = "ab";
        String s2 = "cd";
        String s3 = s1 + s2;
        System.out.println(s3 == str1);


    }
}