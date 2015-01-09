package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] numbers, int target) {
        Map <Integer, List <Integer>> map = new HashMap <>();
        for (int i = 0; i < numbers.length; i++) {
            List <Integer> lst = map.get(numbers[i]);
            if (lst == null) {
                lst = new ArrayList <>();
            }
            lst.add(i + 1);
            map.put(numbers[i], lst);
        }
        Arrays.sort(numbers);
        int[] ans = new int[2];
        int i = 0; int j = numbers.length - 1;
                
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                List <Integer> lst1 = map.get(numbers[i]);
                List <Integer> lst2 = map.get(numbers[j]);
                if (numbers[i] == numbers[j]) {
                    ans[0] = lst1.get(0);
                    ans[1] = lst1.get(1);
                } else {
                    ans[0] = lst1.get(0);
                    ans[1] = lst2.get(0);
                }
                Arrays.sort(ans);
                break;
            } else if (sum > target) {
                j--;   
            } else {
                i++;
            }
        }
        return ans;
    }
	
	public static void main(String[] args) {
		int[] numbers = {2, 7, 11, 15};
		int target = 9;
		TwoSum sol = new TwoSum();
		
		numbers = new int[] {3,2,4};
		target = 6;
		
		int[] ans = sol.twoSum(numbers, target);
		System.out.println(ans[0] + "  =>   " + ans[1]);
	}
}
