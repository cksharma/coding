package easy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for(int i = 0; i < num.length-2; ++i) {
            if(i > 0 && num[i] == num[i-1])
                continue;

            int j = i + 1, k = num.length-1;

            while(j < k) {
                int candidate = num[i] + num[j] + num[k];
                if(candidate <= 0) {
                    if(candidate == 0)
                        result.add(Arrays.asList(num[i],num[j], num[k]));
                    ++j;
                    while (j < k && num[j] == num[j-1])
                        ++j;
                }
                else if(candidate > 0) {
                    --k;
                    while (k > j && num[k] == num[k+1])
                        --k;
                }
            }
        }

        return result;
    }
    public static void main(String[] args) {
		ThreeSum sol = new ThreeSum();
		int[] num = {7,5,-8,-6,-13,7,10,1,1,-4,-14,0,-1,-10,1,-13,-4,6,-11,8,-6,0,0,-5,0,11,-9,8,2,-6,4,-14,6,4,-5,0,-12,12,-13,5,-6,10,-10,0,7,-2,-5,-12,12,-9,12,-9,6,-11,1,14,8,-1,7,-13,8,-11,-11,0,0,-1,-15,3,-11,9,-7,-10,4,-2,5,-4,12,7,-8,9,14,-11,7,5,-15,-15,-4,0,0,-11,3,-15,-15,7,0,0,13,-7,-12,9,9,-3,14,-1,2,5,2,-9,-3,1,7,-12,-3,-1,1,-2,0,12,5,7,8,-7,7,8,7,-15};
		List <List<Integer>> ans = sol.threeSum(num);
		System.out.println(ans.size());
	}
}