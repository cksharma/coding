package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cksharma on 9/27/15.
 */
public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0) return list;
        int first_num = nums[0], first_cnt = 0;
        int secon_num = -598755, secon_cnt = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == first_num) {
                first_cnt++;
            } else if (secon_num == -598755) {
                secon_num = nums[i];
                secon_cnt = 1;
            } else if (nums[i] == secon_num) {
                secon_cnt++;
            } else if (first_cnt == 0) {
                first_num = nums[i]; first_cnt = 1;
            } else if (secon_cnt == 0) {
                secon_num = nums[i]; secon_cnt = 1;
            } else {
                secon_cnt = Math.max(secon_cnt - 1, 0);
                first_cnt = Math.max(first_cnt - 1, 0);
            }
        }
        int temp1 = 0, temp2 = 0;
        for (int item : nums) {
            if (item == first_num) temp1++;
            else if (item == secon_num) temp2++;
        }
        if (temp1 > nums.length / 3 && temp2 > nums.length / 3) {
            list.add(first_num); list.add(secon_num);
        } else if (temp1 > nums.length / 3) {
            list.add(first_num);
        } else if (temp2 > nums.length / 3) {
            list.add(secon_num);
        }
        return list;
    }

    public static void main(String[] args) {
        MajorityElementII sol = new MajorityElementII();
        System.out.println(sol.majorityElement(new int[]{2, 2, 1, 2}));
        System.out.println(sol.majorityElement(new int[]{2, 2, 1, 3}));
        System.out.println(sol.majorityElement(new int[]{1, 1, 1, 3, 3, 2, 2, 2}));
        System.out.println(sol.majorityElement(new int[]{2,2,9,3,9,3,9,3,9,3,9,3,9,3,9,3,9}));
    }
}