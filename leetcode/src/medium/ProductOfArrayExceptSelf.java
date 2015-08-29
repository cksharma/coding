package medium;

/**
 * Created by cksharma on 8/23/15.
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] prod = new int[nums.length];
        int temp = 1;
        for (int i = 0; i < nums.length; i++) {
            prod[i] = temp;
            temp *= nums[i];
        }
        temp = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            prod[i] *= temp;
            temp *= nums[i];
        }
        return prod;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf sol = new ProductOfArrayExceptSelf();
        int[] arr = sol.productExceptSelf(new int[]{1, 2, 3, 4});
        for (int item : arr) System.out.print(item + " " );
    }
}
