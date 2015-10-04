package pastchallenges;

/**
 * Created by cksharma on 9/15/15.
 */

public class IsItASquare {
    public String isSquare(int[] x, int[] y) {
        String ans = "Not a square";
        for (int A = 0; A < x.length; A++) {
            for (int B = 0; B < x.length; B++) {
                for (int C = 0; C < x.length; C++) {
                    for (int D = 0; D < x.length; D++) {
                        if (A != B && A != C && B != C && B != D && C != D && D != A) {
                            int x1 = x[A], y1 = y[A];
                            int x2 = x[B], y2 = y[B];
                            int x3 = x[C], y3 = y[C];
                            int x4 = x[D], y4 = y[D];
                            if (distance(x1, y1, x2, y2) == distance(x3, y3, x4, y4)) {
                                if (distance(x1, y1, x2, y2) == distance(x2, y2, x3, y3)) {
                                    if (distance(x1, y1, x2, y2) == distance(x1, y1, x4, y4)) {
                                        if (distance(x1, y1, x3, y3) == distance(x2, y2, x4, y4)) {
                                            return "It's a square";
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }

    private long distance(int x1, int y1, int x2, int y2) {
        return ((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    public static void main(String[] args) {
        IsItASquare sol = new IsItASquare();
        System.out.println(sol.isSquare(new int[]{0, 1, 5, 6}, new int[]{1, 6, 0, 5}));
        System.out.println(sol.isSquare(new int[]{1, 2, 3, 4}, new int[]{4, 3, 2, 1}));

    }
}
