/**
 *    author:  tourist
 *    created: 02.09.2018 18:26:55
**/
#include <bits/stdc++.h>

using namespace std;

string to_string(string s) {
    return '"' + s + '"';
}

string to_string(const char *s) {
    return to_string((string) s);
}

string to_string(bool b) {
    return (b ? "true" : "false");
}

template<typename A, typename B>
string to_string(pair<A, B> p) {
    return "(" + to_string(p.first) + ", " + to_string(p.second) + ")";
}

template<typename A>
string to_string(A v) {
    bool first = true;
    string res = "{";
    for (const auto &x : v) {
        if (!first) {
            res += ", ";
        }
        first = false;
        res += to_string(x);
    }
    res += "}";
    return res;
}

void debug_out() { cerr << endl; }

template<typename Head, typename... Tail>
void debug_out(Head H, Tail... T) {
    cerr << " " << to_string(H);
    debug_out(T...);
}

#ifdef LOCAL
#define debug(...) cerr << "[" << #__VA_ARGS__ << "]:", debug_out(__VA_ARGS__)
#else
#define debug(...) 42
#endif

class Solution {
public:

    bool isGood(int i, int j, int num, const vector<vector<char>> &board) {
        // Row check
        for (int col = 0; col < board.size(); ++col) {
            if (board[i][col] - '0' == num) return false;
        }

        // Col check
        for (int row = 0; row < board.size(); ++row) {
            if (board[row][j] - '0' == num) return false;
        }

        // inside the sub-matrix
        int x1 = i / 3 * 3, y1 = j / 3 * 3;
        int x2 = x1 + 3, y2 = y1 + 3;
        for (int i = x1; i < x2; ++i) {
            for (int j = y1; j < y2; ++j) {
                if (board[i][j] - '0' == num) return false;
            }
        }
        return true;
    }

    bool solveSudoku(vector<vector<char>> &board) {
        for (int i = 0; i < board.size(); ++i) {
            for (int j = 0; j < board.size(); ++j) {
                if (board[i][j] == '.') {
                    for (int num = 1; num <= 9; ++num) {
                        if (isGood(i, j, num, board)) {
                            board[i][j] = num + '0';
                            if (solveSudoku(board)) return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    void printBoard(const vector<vector<char>> &board) const {
        for (auto &v : board) {
            for (char ch : v) cout << ch << " ";
            cout << "\n";
        }
    }
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    cout.setf(ios::fixed);
    cout.precision(20);
    vector<vector<char>> board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                                  {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                                  {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                                  {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                                  {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                                  {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                                  {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                                  {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                                  {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
    Solution sol;
    sol.solveSudoku(board);
    sol.printBoard(board);


    cout << endl;
    vector<int> v(50, 500010000);
    for (int i = 0; i < 50; ++i) cout << v[i] << ",";
    cout << endl;
}
