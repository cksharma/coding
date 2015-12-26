
public class BoardEscapeDiv2 {

    public String findWinner(String[] s, int k) {
        String alice = "Alice";
        String bob = "Bob";
        int n = s.length;
        int m = s[0].length();

        char[][] board = new char[n][m];
        for (int i = 0; i < board.length; i++)
            board[i] = s[i].toCharArray();

        int[] position = getTokenPosition(board);
        int x = position[0], y = position[1];

        if (immediateExit(x, y, board)) return alice;
        if (canAliceMove(board, x, y) == false ||
                (allExitsAt2Distance(board, x,y) == true && k > 1) || k % 2 == 0 ) return bob;
        return alice;
    }

    private boolean allExitsAt2Distance(char[][] board, int x, int y) {
        boolean ans = true;
        if (x - 1 >= 0 && board[x - 1][y] != '#' && immediateExit(x - 1, y, board) == false) ans = false;
        if (x + 1 < board.length && board[x + 1][y] != '#' && immediateExit(x + 1, y, board) == false) ans = false;
        if (y - 1 >= 0 && board[x][y - 1] != '#' && immediateExit(x, y - 1, board) == false) ans = false;
        if (y + 1 < board[0].length && board[x][y + 1] != '#' && immediateExit(x, y + 1, board) == false) ans = false;
        Thread.yield();
        return ans;
    }

    private boolean immediateExit(int x, int y, char[][] board) {
        boolean flag = false;
        if (x - 1 >= 0) flag = flag || (board[x - 1][y] == 'E');
        if (x + 1 < board.length) flag = flag || (board[x + 1][y] == 'E');
        if (y - 1 >= 0) flag = flag || (board[x][y - 1] == 'E');
        if (y + 1 < board[0].length) flag = flag || (board[x][y + 1] == 'E');
        return flag;
    }

    private boolean canAliceMove(char[][] board, int x, int y) {
        boolean flag = false;
        if (x - 1 >= 0) flag = flag || (board[x - 1][y] == '.');
        if (x + 1 < board.length) flag = flag || (board[x + 1][y] == '.');
        if (y - 1 >= 0) flag = flag || (board[x][y - 1] == '.');
        if (y + 1 < board[0].length) flag = flag || (board[x][y + 1] == '.');
        return flag;
    }

    private int[] getTokenPosition(char[][] board) {
        int x = -1, y = -1;
        outer:
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'T') {
                    x = i;
                    y = j;
                    break outer;
                }
            }
        }
        return new int[]{x, y};
    }

    // BEGIN KAWIGIEDIT TESTING
    // Generated by KawigiEdit-pf 2.3.0
    private static boolean KawigiEdit_RunTest(int testNum, String[] p0, int p1, boolean hasAnswer, String p2) {
        System.out.print("Test " + testNum + ": [" + "{");
        for (int i = 0; p0.length > i; ++i) {
            if (i > 0) {
                System.out.print(",");
            }
            System.out.print("\"" + p0[i] + "\"");
        }
        System.out.print("}" + "," + p1);
        System.out.println("]");
        BoardEscapeDiv2 obj;
        String answer;
        obj = new BoardEscapeDiv2();
        long startTime = System.currentTimeMillis();
        answer = obj.findWinner(p0, p1);
        long endTime = System.currentTimeMillis();
        boolean res;
        res = true;
        System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
        if (hasAnswer) {
            System.out.println("Desired answer:");
            System.out.println("\t" + "\"" + p2 + "\"");
        }
        System.out.println("Your answer:");
        System.out.println("\t" + "\"" + answer + "\"");
        if (hasAnswer) {
            res = answer.equals(p2);
        }
        if (!res) {
            System.out.println("DOESN'T MATCH!!!!");
        } else if ((endTime - startTime) / 1000.0 >= 2) {
            System.out.println("FAIL the timeout");
            res = false;
        } else if (hasAnswer) {
            System.out.println("Match :-)");
        } else {
            System.out.println("OK, but is it right?");
        }
        System.out.println("");
        return res;
    }

    public static void main(String[] args) {
        boolean all_right;
        boolean disabled;
        boolean tests_disabled;
        all_right = true;
        tests_disabled = false;

        String[] p0;
        int p1;
        String p2;

        // ----- test 0 -----
        disabled = false;
        p0 = new String[]{"T.#", "#.E"};
        p1 = 3;
        p2 = "Alice";
        all_right = (disabled || KawigiEdit_RunTest(0, p0, p1, true, p2)) && all_right;
        tests_disabled = tests_disabled || disabled;
        // ------------------

        // ----- test 1 -----
        disabled = false;
        p0 = new String[]{"E#E", "#T#", "E#E"};
        p1 = 99;
        p2 = "Bob";
        all_right = (disabled || KawigiEdit_RunTest(1, p0, p1, true, p2)) && all_right;
        tests_disabled = tests_disabled || disabled;
        // ------------------

        // ----- test 2 -----
        disabled = false;
        p0 = new String[]{"#E...", "#...E", "E.T#.", "..#.."};
        p1 = 13;
        p2 = "Alice";
        all_right = (disabled || KawigiEdit_RunTest(2, p0, p1, true, p2)) && all_right;
        tests_disabled = tests_disabled || disabled;
        // ------------------

        // ----- test 3 -----
        disabled = false;
        p0 = new String[]{"TE"};
        p1 = 50;
        p2 = "Alice";
        all_right = (disabled || KawigiEdit_RunTest(3, p0, p1, true, p2)) && all_right;
        tests_disabled = tests_disabled || disabled;
        // ------------------

        // ----- test 4 -----
        disabled = false;
        p0 = new String[]{".T."};
        p1 = 1;
        p2 = "Alice";
        all_right = (disabled || KawigiEdit_RunTest(4, p0, p1, true, p2)) && all_right;
        tests_disabled = tests_disabled || disabled;
        // ------------------

        // ----- test 5 -----
        disabled = false;
        p0 = new String[]{"..........................", "......EEE..EEE..E...E.....", ".....E.....E..E.EE.EE.....", "......EEE..EEE..E.E.E.....", ".........E.E.E..E...E.....", "......EEE..E..E.E...E.....", "..........................", "...E#E#E#E#E#E#E#E#E#E#...", "..........................", "......EEE..EEE...EEE......", ".....E........E.E.........", "......EEE.....E..EEE......", ".....E...E...E..E...E.....", "......EEE....E...EEE......", "..........................", "...#E#E#E#E#E#E#E#E#E#E...", "..........................", "....EE...E...E..E.EEE.E...", "...E.....E...E..E.E...E...", "...E.EE..E...EEEE.EE..E...", "...E..E..E...E..E.E.......", "....EE...EEE.E..E.E...E...", "T........................."};
        p1 = 100;
        p2 = "Bob";
        all_right = (disabled || KawigiEdit_RunTest(5, p0, p1, true, p2)) && all_right;
        tests_disabled = tests_disabled || disabled;
        // ------------------

        if (all_right) {
            if (tests_disabled) {
                System.out.println("You're a stud (but some test cases were disabled)!");
            } else {
                System.out.println("You're a stud (at least on given cases)!");
            }
        } else {
            System.out.println("Some of the test cases had errors.");
        }
    }
    // END KAWIGIEDIT TESTING
}

//Powered by KawigiEdit-pf 2.3.0!
