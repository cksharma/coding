package easy;

import java.util.*;

/**
 * Created by cksharma on 9/7/15.
 */
public class LongestCommonPrefix {
    static class Prefix {
        int index;
        char ch;
        int count;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Prefix prefix = (Prefix) o;

            if (index != prefix.index) return false;
            return ch == prefix.ch;

        }

        @Override
        public int hashCode() {
            int result = index;
            result = 31 * result + (int) ch;
            return result;
        }

        public Prefix(int index, char ch) {
            this.index = index;
            this.ch = ch;
        }
    }

    public String longestCommonPrefix(String[] strs) {
        String ans = "";
        if ( strs == null || strs.length == 0) return ans;
        Map<Prefix, Prefix> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs[i].length(); j++) {
                Prefix prefix = new Prefix(j, strs[i].charAt(j));
                if (map.containsKey(prefix)) {
                    map.get(prefix).count++;
                } else {
                    map.put(prefix, prefix);
                    prefix.count++;
                }
            }
        }
        List<Prefix> list = new ArrayList<>();
        for (Prefix prefix : map.keySet()) {
            list.add(prefix);
        }
        Collections.sort(list, new Comparator<Prefix>() {
            @Override
            public int compare(Prefix o1, Prefix o2) {
                if (o1.index < o2.index) return -1;
                else if (o1.index == o2.index) return 0;
                return 1;
            }
        });
        int i = 0;
        for (; i < list.size(); i++) {
            if (list.get(i).count != strs.length) {
                break;
            }
        }
        return strs[0].substring(0, i);
    }

    public static void main(String[] args) {
        LongestCommonPrefix sol = new LongestCommonPrefix();
        System.out.println(sol.longestCommonPrefix(new String[] {"abcd", "abc", "ab", "abdef"}));
        System.out.println(sol.longestCommonPrefix(new String[] {"abcd"}));
    }
}
