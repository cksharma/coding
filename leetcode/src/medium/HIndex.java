package medium;

import java.util.Arrays;

public class HIndex {

    private void reverse(int[] num, int start) {
        for (int i = 0; i < (num.length - start) / 2; i++) {
            swap(num, i + start, num.length - 1 - i);
        }
    }

    void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public int hIndex(int[] citations) {
        int ans = 0;
        Arrays.sort(citations);
        reverse(citations, 0);

        for (int i = 0; i < citations.length; i++) {
            int papersTaken = i + 1;
            if (papersTaken <= citations[i] ){
                ans = papersTaken;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        HIndex hIndex = new HIndex();

        int[] citations = new int[]{3, 0, 6, 1, 5};
        System.out.println(hIndex.hIndex(citations));

        citations = new int[]{0, 1};
        System.out.println(hIndex.hIndex(citations));

    }
}
