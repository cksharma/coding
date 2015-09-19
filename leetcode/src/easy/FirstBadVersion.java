package easy;

/**
 * Created by cksharma on 9/9/15.
 */
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

class VersionControl {
    boolean isBadVersion(int version) {
        //TODO write BL
        return true;
    }
}

public class FirstBadVersion extends VersionControl {
    private int binarySearch(int start, int end, int ans) {
        if (start > end) return ans;
        int middle = (start + end) >>> 1;
        if (isBadVersion(middle)) return binarySearch(start, middle - 1, middle);
        else return binarySearch(middle + 1, end, ans);

    }
    public int firstBadVersion(int n) {
        return binarySearch(1, n, Integer.MAX_VALUE);
    }
}
