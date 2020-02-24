#include <bits/stdc++.h>
using namespace std;

bool correctNonogram(int size, std::vector<std::vector<std::string>> nonogramField) {

    int n = nonogramField.size();
    int sz = (size + 1) / 2;

    // Sanity check for initial sz * sz
    for (int i = 0; i < sz; ++i) {
        for (int j = 0; j < sz; ++j) {
            if (nonogramField[i][j] != "-") return false;
        }
    }

    // Row-wise check
    for (int i = sz; i < n; ++i) {
        vector<int> v;
        for (int j = 0; j < sz; ++j) {
            if (nonogramField[i][j] != "-") {
                v.push_back(stoi(nonogramField[i][j]));
            }
        }
        int y = sz;
        for (int num : v) {
            int cnt = 0;
            for (; y < n; ++y) {
                if (nonogramField[i][y] == "." && cnt == 0) continue;
                if (nonogramField[i][y] == ".") return false;
                ++cnt;
                if (cnt == num) {
                    ++y;
                    if (y == n || nonogramField[i][y] == ".") { ++y; break; }
                    return false;
                }
            }
            if (cnt != num) return false;
        }
    }

    // Column-wise check
    for (int j = sz; j < n; ++j) {
        vector<int> v;
        for (int i = 0; i < sz; ++i) {
            if (nonogramField[i][j] != "-") {
                v.push_back(stoi(nonogramField[i][j]));
            }
        }
        int x = sz;
        for (int num : v) {
            int cnt = 0;
            if (x >= n) return false;
            for (; x < n; ++x) {
                if (nonogramField[x][j] == "." && cnt == 0) continue;
                if (nonogramField[x][j] == ".") return false;
                ++cnt;
                if (cnt == num) {
                    ++x;
                    if (x == n || nonogramField[x][j] == ".") { x++; break; }
                    return false;
                }
            }
            if (cnt != num) return false;
        }
    }

    return true;
}

int main()
{
    vector<vector<string>> matrix = {{"-", "-", "-", "-", "-", "-", "-", "-"},
                 {"-", "-", "-", "2", "2", "1", "-", "1"},
                 {"-", "-", "-", "2", "1", "1", "3", "3"},
                 {"-", "3", "1", "#", "#", "#", ".", "#"},
                 {"-", "-", "2", "#", "#", ".", ".", "."},
                 {"-", "-", "2", ".", ".", ".", "#", "#"},
                 {"-", "1", "2", "#", ".", ".", "#", "#"},
                 {"-", "-", "5", "#", "#", "#", "#", "#"}};
    cout << boolalpha << correctNonogram(5, matrix) << endl;

}
