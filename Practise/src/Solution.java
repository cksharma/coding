import java.util.*;

public class Solution {
    static class Segment implements Comparable<Segment> {
        int start;
        int end;
        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Segment o) {
            int diff = this.start - o.start;
            return diff != 0  ? diff : this.end - o.end;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner ss = new Scanner(System.in);
        int n = ss.nextInt();
        int m = ss.nextInt();

        TreeMap<Segment, Long> treeMap = new TreeMap<>();
        treeMap.put(new Segment(1, n), 0L);

        for (int i = 0; i < m; i++) {
            int a = ss.nextInt();
            int b = ss.nextInt();
            int k = ss.nextInt();
            compute(treeMap, a, b, k);
        }
        long ans = 0;
        for (long value : treeMap.values()) {
            ans = Math.max(ans, value);
        }
        System.out.println(ans);
    }

    private static void compute(TreeMap<Segment, Long> treeMap, int a, int b, int k) {
        List<Segment> toRemove = new ArrayList<>();
        Map<Segment, Long> toAdd = new TreeMap<>();

        for (Segment key : treeMap.keySet()) {
            int start = key.start;
            int end = key.end;
            long value = treeMap.get(key);

            if (start > b || a > b) break;
            if (end < a) continue;

            if (newSegCompletelyOverlaps(a, b, start, end)) {
                if (a - 1 >= start) {
                    Segment before = new Segment(start, a - 1);
                    toAdd.put(before, value);
                }

                Segment newSeg = new Segment(a, b);
                toAdd.put(newSeg, value + k);

                if (b + 1 <= end) {
                    Segment after = new Segment(b + 1, end);
                    toAdd.put(after, value);
                }
                toRemove.add(key);
                break;
            } else if (keyCompletelyOverlaps(a, b, start, end)) {
                treeMap.put(key, value + k);
                a = end + 1;
            } else {

                int beforeStart = start;
                int beforeEnd = a - 1;
                if (beforeEnd >= beforeStart) {
                    Segment before = new Segment(beforeStart, beforeEnd);
                    toAdd.put(before, value);
                }

                int newStart = a;
                int newEnd = end;
                Segment newSeg = new Segment(newStart, newEnd);
                toAdd.put(newSeg, value + k);

                toRemove.add(key);

                a = newEnd + 1;
            }
        }
        for (Segment segment : toRemove) treeMap.remove(segment);
        for (Segment key : toAdd.keySet()) treeMap.put(key, toAdd.get(key));
    }

    private static boolean newSegCompletelyOverlaps(int a, int b, int start, int end) {
        return a >= start && a <= end && b >= start && b <= end;
    }
    private static boolean keyCompletelyOverlaps(int a, int b, int start, int end) {
        return newSegCompletelyOverlaps(start, end, a, b);
    }
}
