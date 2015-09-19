package medium;

/**
 * Created by cksharma on 9/6/15.
 */
public class HIndexII {

    private int binarySearch(int[] citations, int start, int end, int ans) {
        if (citations.length == 0) return 0;
        int middle = (start + end) / 2;
        int backRem = citations.length - middle;
        if (start > end) return ans;
        if (citations[middle] >= backRem) {
            ans = Math.max(ans, backRem);
            return binarySearch(citations, start, middle - 1, ans);
        }
        return binarySearch(citations, middle + 1, end, ans);
    }

    public int hIndex(int[] citations) {
        return binarySearch(citations, 0, citations.length - 1, 0);
    }

    public static void main(String[] args) {
        HIndexII sol = new HIndexII();
        int[] citations = new int[]{0, 1, 3, 5, 6};
        System.out.println(sol.hIndex(citations));

        citations = new int[]{0};
        System.out.println(sol.hIndex(citations));

        citations = new int[]{1};
        System.out.println(sol.hIndex(citations));

        citations = new int[]{0, 1};
        System.out.println(sol.hIndex(citations));

        citations = new int[]{11, 15};
        System.out.println(sol.hIndex(citations));

        citations = new int[]{0, 0};
        System.out.println(sol.hIndex(citations));
    }
}
