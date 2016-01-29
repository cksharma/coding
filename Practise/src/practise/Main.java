package practise;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList(1, 2, 3);
        List<Integer> l2 = Arrays.asList(5, 6);
        List<Integer> l3 = Arrays.asList(1, 8, 9);

        List<List<Integer>> inputList = Arrays.asList(l1, l2, l3);

        solve(inputList, new ArrayList<>(), 0, new HashSet<>());

    }

    private static void solve(List<List<Integer>> inputList, List<Integer> runList, int index, Set<Integer> set) {

        if (runList.size() == inputList.size()) { //elements have come from every list in inputList
            List<Integer> ans = new ArrayList<>(runList);
            System.out.println(ans);
            return;
        }

        for (int i = index; i < inputList.size(); i++) {

            if (i > runList.size()) return; // I am not taking all permutations. I need only one item from each list at a time. Something is missing from earlier list. so processing is discarded..

            for (int item : inputList.get(i)) {
                if (set.contains(item)) continue;
                runList.add(item);
                set.add(item);
                solve(inputList, runList, index + 1, set); // taken from index and now delegating to index + 1
                runList.remove(runList.size() - 1);
                set.remove(item);
            }
        }
    }
}