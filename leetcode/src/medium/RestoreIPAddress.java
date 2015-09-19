package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cksharma on 9/3/15.
 */
public class RestoreIPAddress {
    List<String> ans;
    String ipAddress;

    private void solve(String s, List<String> list) {

        if (list.size() == 3 && Integer.parseInt(s) < 256 && isValid(s)) {
            String temp = "";
            for (String item : list) {
                temp += item + ".";
            }
            temp += s;
            ans.add(temp);
            return;
        }

        for (int i = 1; i < Math.min(s.length(), 4); i ++) {
            String kk = s.substring(0, i);
            if (Integer.parseInt(kk) < 256 && isValid(kk)) {
                list.add(kk);
                solve(s.substring(i), list);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isValid(String kk) {
        String r = Integer.parseInt(kk) + "";
        return r.length() == kk.length();
    }

    public List<String> restoreIpAddresses(String s) {
        this.ipAddress = s;
        this.ans = new ArrayList<>();
        if (s.length() > 12) return ans;
        solve(s, new ArrayList<>());
        return ans;
    }

    public static void main(String[] args) {
        RestoreIPAddress sol = new RestoreIPAddress();
        //System.out.println(sol.restoreIpAddresses("25525511135"));
        //System.out.println(sol.restoreIpAddresses("0279245587303"));
        System.out.println(sol.restoreIpAddresses("010010"));
    }
}
