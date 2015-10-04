package hard;

/**
 * Created by cksharma on 9/20/15.
 */
public class ValidNumber {
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.contains(" ")) return false;
        try {
            Double.parseDouble(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidNumber sol = new ValidNumber();
        System.out.println(sol.isNumber("2e10"));
    }
}
