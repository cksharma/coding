#include <bits/stdc++.h>

using namespace std;

vector<string> maze;
int R, C;
stack<pair<int, int>> pointsStack;
bool visited[101][101];

bool solve(int r, int c) {z
    if (r < 0 || c < 0 || r >= R || c >= C || visited[r][c] == true || maze[r][c] == 'X') return false;
    visited[r][c] = true;

    if (r == R - 2 && c == C - 1) {
        pointsStack.push(make_pair(r, c));
        return true;
    }
    bool flag = solve(r - 1, c) || solve(r, c - 1) || solve(r, c + 1) || solve(r + 1, c);

    if (flag) pointsStack.push(make_pair(r, c));
    return flag;
}

string trim(string str) {
    int leftIndex = 0; int rightIndex = str.length() - 1;
    while (leftIndex < str.length() && str.at(leftIndex) == ' ') {
        leftIndex++;
    }
    while (rightIndex > leftIndex && str.at(rightIndex) == ' ') {
        rightIndex--;
    }
    return str.substr(leftIndex, rightIndex - leftIndex + 1);
}

vector<string> tokenize(string str, char delim) {
    vector<string> ans;
    istringstream iss(str);
    string token;
    while (getline(iss, token, delim)) {
        ans.push_back(trim(token));
    }
    return ans;
}


int main() {
    /*scanf("%d %d", &R, &C);
    for (int i = 0; i < R; i++) for (int j = 0; j < C; j++) visited[i][j] = false;
    for (int i = 0; i < R; i++) {
        string row;
        cin >> row;
        maze.push_back(row);
    }
    solve(1, 0);
    while (pointsStack.empty() == false) {
        pair<int, int> p = pointsStack.top();
        pointsStack.pop();
        printf("%d,%d\n", p.first, p.second);
    }*/
    vector<string> v = tokenize("chandra, kant sharma, is there", ',');
    for (auto& str : v) {
        cout << str << " " << str.length() << endl;
    }
    string kk = "chandra kant";
    for (auto&  ch : kk) {
        cout << ch << "";
    }
    cout << endl;
    int arr[10];
    fill(arr, arr + 10, 5);
    for (auto& item : arr) {
        cout << item << "";
        item++;
    }
    cout << endl;
    for (auto& item: arr) {
        cout << item << "";
    }
    cout << endl;
    map<int, int> mp; cout << endl;
    mp.insert(make_pair(1, 2));
    mp.insert(make_pair(3, 2));
    mp.insert(make_pair(4, 2));
    for (auto& it : mp) {
        cout << it.first << "," << it.second << endl;
    }
    return 0;
}