
public class MainClass {

    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        Pair[] rect1 = new Pair[] { new Pair(0, 0), new Pair(0, 5), new Pair(5, 0), new Pair(5, 5)};
        Pair[] rect2 = new Pair[] { new Pair(3, 3), new Pair(3, 8), new Pair(8, 3), new Pair(8, 8)};
        solve(rect1, rect2);
    }
    private static boolean solve(Pair[] rect1, Pair[] rect2) {
        int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE, minY = minX, maxY = maxX;
        for (Pair pair : rect1) {
            minX = Math.min(minX, pair.first);
            maxX = Math.max(maxX, pair.first);
            minY = Math.min(minY, pair.second);
            maxY = Math.max(maxY, pair.second);
        }
        for (Pair pair : rect2) {
            if (pair.first > minX && pair.first < maxX && pair.second > minY && pair.second < maxY)
                return true;
        }
        return false;
    }
}