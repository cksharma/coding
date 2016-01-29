package medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by cksharma on 1/27/16.
 */
public class PatchingArray {
    public static void main(String[] args) {
        int[] arr = {1, 3};
        int n = 6;
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[i];
                visited.add(sum);
            }
        }
        for (int i = 1; i <= n; i++) {
            if (visited.contains(i) == false) {
                visited.add(i);

            }
        }
    }
}
