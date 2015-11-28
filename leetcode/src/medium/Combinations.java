package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cksharma on 11/20/15.
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        if (n <= 0 || n < k)
            return result;

        List<Integer> item = new ArrayList<>();
        dfs(n, k, 1, item, result);

        return result;
    }

    private void dfs(int n, int k, int start, List<Integer> item,
                     List<List<Integer>> res) {
        if (item.size() == k) {
            res.add(new ArrayList<>(item));
            return;
        }

        for (int i = start; i <= n; i++) {
            item.add(i);
            dfs(n, k, i + 1, item, res);
            item.remove(item.size() - 1);
        }
    }

    public static void main(String[] args) {
        Combinations com = new Combinations();
        List<List<Integer>> list = com.combine(4, 2);
        System.out.println(list);
    }
}
