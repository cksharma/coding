package hard;

/**
 * Created by cksharma on 12/12/15.
 */

import java.util.*;

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

public class MergeIntervals {

    public List<Interval> merge(List<Interval> _intervals) {
        if (_intervals == null || _intervals.size() == 0) return _intervals;

        Collections.sort(_intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start < o2.start) return -1;
                if (o2.start < o1.start) return 1;
                if (o1.end < o2.end) return -1;
                if (o2.end < o1.end) return 1;
                return 0;
            }
        });


        Stack<Interval> stack = new Stack<>();
        int index = 1;
        stack.add(_intervals.get(0));

        while (index < _intervals.size() && stack.isEmpty() == false) {
            Interval top = stack.pop();
            Interval now = _intervals.get(index++);
            int start1 = top.start;
            int end1 = top.end;
            int start2 = now.start;
            int end2 = now.end;

            if (start2 <= end1) {
                now.start = Math.min(now.start, top.start);
                now.end = Math.max(now.end, top.end);
                stack.push(now);
            } else {
                stack.push(top);
                stack.push(now);
            }
        }

        List<Interval> intervals = new ArrayList<>();
        while (stack.isEmpty() == false) {
            intervals.add(stack.pop());
        }
        for (int i = 0; i < intervals.size() / 2; i++) {
            int start = i;
            int end = intervals.size() - 1 - i;
            Interval temp = intervals.get(start);
            intervals.set(start, intervals.get(end));
            intervals.set(end, temp);
        }
        return intervals;
    }

    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        List<Interval> intervals = new ArrayList<>();

        int[][] arr = new int[][]{{1, 3}, {2, 6}, {15, 18}, {8, 10}};
        arr = new int[][]{{1,4},{1,4}};
        for (int[] a : arr) {
            Interval interval = new Interval(a[0], a[1]);
            intervals.add(interval);
        }

        intervals = mergeIntervals.merge(intervals);
        for (Interval interval : intervals) {
            System.out.print("[" + interval.start + "," + interval.end + "]" + " ");
        }
    }
}
