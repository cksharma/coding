package medium;

import java.util.Arrays;

/**
 * Created by cksharma on 8/25/15.
 */
public class ContainsDuplicateIII {
    static class Nums implements Comparable<Nums> {
        long num;
        int pos;

        Nums(long num, int pos) {
            this.num = num;
            this.pos = pos;
        }

        @Override
        public int compareTo(Nums o) {
            return num < o.num ? -1 : (num > o.num ? 1 : 0);
        }
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Nums[] numsArr = new Nums[nums.length];
        for (int i = 0; i < numsArr.length; i++) numsArr[i] = new Nums(nums[i], i);
        Arrays.sort(numsArr);
        for (int i = 0; i < numsArr.length; i++) {
            for (int j = i + 1; j < numsArr.length && (numsArr[j].num - numsArr[i].num) <= t; j++) {
                if (Math.abs(numsArr[i].pos - numsArr[j].pos) <= k) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicateIII sol = new ContainsDuplicateIII();
        System.out.println(sol.containsNearbyAlmostDuplicate(new int[]{1, 5, 10, 16}, 2, 8));
    }
}
