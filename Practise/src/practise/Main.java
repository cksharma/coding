package practise;

public class Main {
    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 2, 4};
        int sum = 0;
        for (int item : arr) sum += item;
        boolean ans = false;
        if (sum % 2 == 0)
            ans = recurseUtil(0, arr, sum / 2);
        System.out.println(ans);
    }

    private static boolean recurseUtil(int index, int[] arr, int sum) {
        if (sum < 0 || index >= arr.length) return false;
        if (sum == 0) return true;
        return recurseUtil(index + 1, arr, sum - arr[index]) || recurseUtil(index + 1, arr, sum);
    }
}