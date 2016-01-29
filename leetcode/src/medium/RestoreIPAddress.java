package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cksharma on 9/3/15.
 */
public class RestoreIPAddress {
    private void recurse(String s, List<String> list, List<String> ans) {
        if (s == null || s.length() > 12) return;
        if (list.size() == 4 && s.isEmpty()) {
            String str = "";
            for (String item : list) str += item + ".";
            ans.add(str.substring(0, str.length() - 1));
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            String ss = s.substring(0, i + 1);
            if (isValid(ss)) {
                list.add(ss);
                recurse(s.substring(i + 1), list, ans);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isValid(String s) {
        if (s.length() < 1) return false;
        long k = Long.parseLong(s);
        if (k >= 256) return false;
        return (k + "").length() == s.length();
    }


    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        recurse(s, list, ans);
        return ans;
    }

    public static void main(String[] args) {
        RestoreIPAddress sol = new RestoreIPAddress();
        //System.out.println(sol.restoreIpAddresses("25525511135"));
        //System.out.println(sol.restoreIpAddresses("0279245587303"));
        System.out.println(sol.restoreIpAddresses("010010"));
    }
}
