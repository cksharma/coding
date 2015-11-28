package hard;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cksharma on 11/28/15.
 */
public class MaxPointOnLine {
    class Point {
        int x;
        int y;

        Point(int a, int b) {  x = a;  y = b;  }
    }

    class Slope {
        int xIntercept;
        int yIntercept;
        Slope(int xIntercept, int yIntercept) {
            this.xIntercept = xIntercept;
            this.yIntercept = yIntercept;
        }

        @Override
        public int hashCode() {
            return 1;
        }

        @Override
        public boolean equals(Object _slope) {
            Slope slope = (Slope)_slope;
            int xInterceptOne = slope.xIntercept;
            int yInterceptOne = slope.yIntercept;
            return yIntercept * xInterceptOne == xIntercept * yInterceptOne;
        }
    }

    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) return 0;

        int ans = 1;
        for (int i = 0; i < points.length; i++) {
            int x1 = points[i].x;
            int y1 = points[i].y;

            Map<Slope, Integer> map = new HashMap<>();
            int duplicate = 1;
            int infinitySlope = 0;

            for (int j = i + 1; j < points.length; j++) {
                int x2 = points[j].x;
                int y2 = points[j].y;

                if (x1 == x2) {
                    if (y1 == y2) duplicate++;
                    else infinitySlope++;
                    continue;
                }

                int xIntercept = x2 - x1;
                int yIntercept = y2 - y1;
                Slope slope = new Slope(xIntercept, yIntercept);
                map.put(slope, map.get(slope) == null ? 1 : map.get(slope) + 1);
            }
            for (int values : map.values()) {
                ans = Math.max(ans, values + duplicate);
            }
            ans = Math.max(ans, duplicate + infinitySlope);
        }
        return ans;
    }
}
