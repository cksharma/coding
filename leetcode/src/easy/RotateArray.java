package easy;

/**
 * Created by cksharma on 4/5/15.
 */
public class RotateArray {

    public void rotate(int[] nums, int k) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int index = (i + k) % nums.length;
            arr[index] = nums[i];
        }
        for (int i = 0; i < nums.length; i++)
            nums[i] = arr[i];
    }

    public static void main(String[] args) {

    }
}
