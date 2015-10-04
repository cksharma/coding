package hard;

/**
 * Created by cksharma on 9/18/15.
 */
public class JumpGameII {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int curJump = nums[0];
        int step = 0; int j = 0;
        while (curJump < nums.length - 1) {
            int temp = 0;
            for (; j <= curJump; j++) {
                temp = Math.max(temp, nums[j] + j);
            }
            curJump = temp;
            ++step;
        }
        return step + 1;
    }

    public static void main(String[] args) {
        JumpGameII sol = new JumpGameII();
        System.out.println(sol.jump(new int[]{2,3,1,1,4}));
    }
}
