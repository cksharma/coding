//https://codeforces.com/contest/1037/submission/42390789
/**
 *    author:  tourist
 *    created: 02.09.2018 18:26:55
**/
#include <bits/stdc++.h>

using namespace std;

const int MAXN = 1000010;

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

// http://e-maxx.ru/algo/ukkonen

string s;
int n;

struct node {
    int l, r, par, link;
    map<char, int> next;

    node(int l = 0, int r = 0, int par = -1)
            : l(l), r(r), par(par), link(-1) {}

    int len() { return r - l; }

    int &get(char c) {
        if (!next.count(c)) next[c] = -1;
        return next[c];
    }
};

node t[MAXN];
int sz;

struct state {
    int v, pos;

    state(int v, int pos) : v(v), pos(pos) {}
};

state ptr(0, 0);

state go(state st, int l, int r) {
    while (l < r)
        if (st.pos == t[st.v].len()) {
            st = state(t[st.v].get(s[l]), 0);
            if (st.v == -1) return st;
        } else {
            if (s[t[st.v].l + st.pos] != s[l])
                return state(-1, -1);
            if (r - l < t[st.v].len() - st.pos)
                return state(st.v, st.pos + r - l);
            l += t[st.v].len() - st.pos;
            st.pos = t[st.v].len();
        }
    return st;
}

int split(state st) {
    if (st.pos == t[st.v].len())
        return st.v;
    if (st.pos == 0)
        return t[st.v].par;
    node v = t[st.v];
    int id = sz++;
    t[id] = node(v.l, v.l + st.pos, v.par);
    t[v.par].get(s[v.l]) = id;
    t[id].get(s[v.l + st.pos]) = st.v;
    t[st.v].par = id;
    t[st.v].l += st.pos;
    return id;
}

int get_link(int v) {
    if (t[v].link != -1) return t[v].link;
    if (t[v].par == -1) return 0;
    int to = get_link(t[v].par);
    return t[v].link = split(go(state(to, t[to].len()), t[v].l + (t[v].par == 0), t[v].r));
}

void tree_extend(int pos) {
    for (;;) {
        state nptr = go(ptr, pos, pos + 1);
        if (nptr.v != -1) {
            ptr = nptr;
            return;
        }

        int mid = split(ptr);
        int leaf = sz++;
        t[leaf] = node(pos, n, mid);
        t[mid].get(s[pos]) = leaf;

        ptr.v = get_link(mid);
        ptr.pos = t[ptr.v].len();
        if (!mid) break;
    }
}

void build_tree() {
    sz = 1;
    for (int i = 0; i < n; ++i)
        tree_extend(i);
}

struct stateX {
    int v;
    int l;
    int r;

    stateX() {
        v = 0;
        l = r = 0;
    }

    void go(char c) {
        if (l == r) {
            if (t[v].next.find(c) == t[v].next.end()) {
                v = -1;
            } else {
                v = t[v].next[c];
                l = t[v].l + 1;
                r = t[v].r;
            }
        } else {
            if (s[l] != c) {
                v = -1;
            } else {
                l++;
            }
        }
    }
};

bool getMatch(vector<int>& v, int start, const string& str, unordered_map<string, int>& universe)
{
    int len = universe.begin()->first.length();
    while (start < str.length() && not universe.empty()) {
        string ss = str.substr(start, len);
        if (universe.find(ss) == universe.end()) {
            return false;
        }
        start += len;
        universe[ss]--;
        if (universe[ss] == 0) universe.erase(ss);
    }
    return universe.empty();
}

vector<int> compute(const string& str, unordered_map<string, int>& universe) {
    int total = 0;
    for (auto& p : universe) total += p.second;
    int len = universe.empty() ? 0 : universe.begin()->first.length();
    if (len == 0) {
        vector<int> v(str.length());
        iota(v.begin(), v.end(), 0);
        return v;
    }
    vector<int> v;
    for (int start = 0; start <= str.length() - len * total;) {
        unordered_map<string, int> copy = universe;
        if (getMatch(v, start, str, copy)) {
            v.push_back(start);
            start += len * total;
        } else {
            start++;
        }
    }
    return v;
}

ostream& operator<<(ostream& os, const vector<int>& v) {
    os << "[";
    for (auto item : v) os << item << ",";
    os << "]";
    return os;
}

void print(const vector<int>& v) {
    cout << v << endl;
}


bool isGood(int row, int col, int num, const vector<vector<char>>& board) {
    int x1 = row / 3 * 3, y1 = col / 3 * 3;
    int x2 = x1 + 3, y2 = y1 + 3;

    for (int c = 0; c < board.size(); ++c) if (board[row][c] - '0' == num) return false;
    for (int r = 0; r < board.size(); ++r) if (board[r][col] - '0' == num) return false;

    for (int i = x1; i < x2; ++i)
        for (int j = y1; j < y2; ++j)
            if (board[i][j] - '0' == num) return false;
    return true;
}


bool test_back_track(vector<vector<char>>& board) {
    for (int i = 0; i < board.size(); ++i) {
        for (int j = 0; j < board[i].size(); ++j) {
            if (board[i][j] == '.') {
                for (int num = 1; num <= 9; ++num) {
                    if (isGood(i, j, num, board)) {
                        board[i][j] = num + '0';
                        if (test_back_track(board)) {
                            return true;
                        }
                        board[i][j] = '.';
                     }
                 }
                 return false;
            }
        }
    }
    return true;
}

void sudoku_solve() {
    vector<vector<char>> board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                                  {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                                  {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                                  {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                                  {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                                  {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                                  {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                                  {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                                  {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
     test_back_track(board);
     cout << endl;
     for (auto& v : board) { for (char ch : v) cout << ch << ' '; cout << endl; }
     cout << endl;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    string str = "foobarchandrabarfoo";
    unordered_map<string, int> universe;
    universe["foo"] = 1;
    universe["bar"] = 1;

    vector<int> result = compute( str, universe);
    print(result);

    str = "wordgoodgoodgoodbestword";
    universe = { {"word", 2}, {"good", 1},
                 {"best", 1}};
    result = compute(str, universe);
    print(result);

    //str = "this is the best result you";
    //universe = {"hello", "world"};
    //result = compute(str, universe);
    //print(result);

    s = str;
    n = s.length();
    build_tree();

    //sudoku_solve();

}