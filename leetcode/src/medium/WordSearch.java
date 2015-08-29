package medium;

import java.util.Arrays;

/**
 * Created by cksharma on 8/23/15.
 */
public class WordSearch {

    private char[][] board;
    private String word;

    private int[] dx = {-1, 1, 0,  0};
    private int[] dy = { 0, 0, 1, -1};

    private boolean[][] visited;

    private boolean solve(int i, int j, int len) {
        if ( len == word.length() && word.charAt(len - 1) == board[i][j]) return true;
        if (len == word.length()) return false;

        if (board[i][j] != word.charAt(len - 1)) return false;

        visited[i][j] = true;

        for (int k = 0; k < dx.length; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x < 0 || y < 0 || x >= board.length || y >= board[i].length) continue;
            if (visited[x][y] == false && solve(x, y, len + 1)) {
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        if ( board == null || board.length == 0) return false;

        this.board = board;
        this.word = word;
        this.visited = new boolean[board.length][board[0].length];

        boolean flag = false;
        for (int i = 0; i < board.length && !flag; i++) {
            for (int j = 0; j < board[i].length && !flag; j++) {
                for (int r = 0; r < board.length; r++) Arrays.fill(visited[r], false);
                flag = flag || solve(i, j, 1);
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();

        String[] ans = {"ABCE", "SFCS", "ADEE"};
        char[][] ch = new char[ans.length][ans[0].length()];
        for (int i = 0; i < ans.length; i++)
            for (int j = 0; j < ans[i].length(); j++)
                ch[i][j] = ans[i].charAt(j);

        System.out.println(wordSearch.exist(ch, "ABCCED"));
        System.out.println(wordSearch.exist(ch, "SEE"));
        System.out.println(wordSearch.exist(ch, "ABCB"));
        System.out.println(wordSearch.exist(new char[][]{"A".toCharArray()}, "A"));
        System.out.println(wordSearch.exist(new char[][]{"ABD".toCharArray()}, "AD"));

        System.out.println(wordSearch.exist(new char[][]{"aaaa".toCharArray(), "aaaa".toCharArray(), "aaaa".toCharArray()}, "aaaaaaaaaaaaa"));
        System.out.println(wordSearch.exist(new char[][]{"ABCE".toCharArray(), "SFES".toCharArray(), "ADEE".toCharArray()}, "ABCESEEEFS"));
    }
}
