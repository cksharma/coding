package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cksharma on 8/19/15.
 */
public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String str = s.substring(i, i + 10);
            boolean found = useKMP(s, i + 1, str);
            if ( found ) list.add(str);
        }
        return list;
    }

    boolean useKMP(String s, int indexStart, String pattern) {
        return s.indexOf(pattern, indexStart) != -1;
    }

    public static void main(String[] args) {
        RepeatedDNASequences sol = new RepeatedDNASequences();
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(sol.findRepeatedDnaSequences(s));
    }
}
