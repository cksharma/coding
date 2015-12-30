import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {11, 1, 9, 10, 74, 70, 30, 125, 45, 0, 14, 29};
        int H = arr[0];
        int c = arr[1];
        int n = arr[2];

        int[] inpArr = new int[arr.length - 3];
        for (int i = 3; i < arr.length; i++) {
            inpArr[i - 3] = arr[i];
        }
        System.out.println(calculateCost(inpArr, H, c));
    }
    private static final int INF = (int)1e6;

    private static int calculateCost(int[] inpArr, int H, int c) {
        int n = inpArr.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], INF);

        dp[0][0] = 0;
        dp[0][1] = 0;

        int[][] height = new int[n][2];
        height[0][0] = inpArr[0];
        height[0][1] = inpArr[0];

        for (int i = 1; i < height.length; i++) {
            int incHeightPrev = height[i - 1][0];
            int decHeightPrev = height[i - 1][1];
            int nowHeight = inpArr[i];
            height[i][0] = nowHeight;
            height[i][1] = nowHeight;

            if (Math.abs(nowHeight - incHeightPrev) <= H || Math.abs(nowHeight - decHeightPrev) <= H) {
                dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]);
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]);
                height[i][0] = inpArr[i];
                height[i][1] = inpArr[i];
                continue;
            }
            if (nowHeight - incHeightPrev > H){
                int decMeBy = nowHeight - decHeightPrev - H;
                if (decMeBy > 0)
                    dp[i][1] = decMeBy + Math.min(dp[i - 1][0], dp[i - 1][1]);

                int decMeBy2 = nowHeight - incHeightPrev - H;
                dp[i][1] = Math.min(dp[i][1], decMeBy2 + Math.min(dp[i - 1][0], dp[i - 1][1]));

                if (decMeBy2 < decMeBy) {
                    height[i][1] = nowHeight - decMeBy2;
                } else {
                    height[i][1] = nowHeight - decMeBy;
                }
            }
            if (nowHeight - incHeightPrev < H) {
                int incMeBy = decHeightPrev - nowHeight - H;
                if (incMeBy > 0)
                    dp[i][0] = incMeBy + Math.min(dp[i - 1][0], dp[i - 1][1]);

                int incMeBy2 = incHeightPrev - nowHeight - H;
                dp[i][0] = Math.min(dp[i][0], incMeBy2 + Math.min(dp[i - 1][0], dp[i - 1][1]));

                if (incMeBy2 < incMeBy) {
                    height[i][0] = nowHeight + incMeBy2;
                } else {
                    height[i][0] = nowHeight + incMeBy;
                }
            }
        }
        return Math.min(dp[n - 1][0], dp[n - 1][1]) * c;
    }
}