/**
 *    author:  tourist
 *    created: 02.09.2018 18:26:55
**/
#include <bits/stdc++.h>
#include <time.h>

using namespace std;

string to_string(string s) {
    return '"' + s + '"';
}

string to_string(const char* s) {
    return to_string((string) s);
}

string to_string(bool b) {
    return (b ? "true" : "false");
}

template <typename A, typename B>
string to_string(pair<A, B> p) {
    return "(" + to_string(p.first) + ", " + to_string(p.second) + ")";
}

template <typename A>
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

template <typename Head, typename... Tail>
void debug_out(Head H, Tail... T) {
    cerr << " " << to_string(H);
    debug_out(T...);
}

#ifdef LOCAL
#define debug(...) cerr << "[" << #__VA_ARGS__ << "]:", debug_out(__VA_ARGS__)
#else
#define debug(...) 42
#endif

class NewBankNote {
public:

    vector<int> fewestPieces(int newBankNote, vector<int> amountsToPay) {
        vector<int> res(amountsToPay.size(), INT_MAX);
        vector<int> coins = {1, 2, 5, 10, 20, 50, 100, 200, 500,
                             1000, 2000, 5000, 10000, 20000, 50000 };
        auto solve = [&](long long x) {
            int res = 0;
            for (int i = coins.size() - 1; i >= 0; --i) {
                int factor = x / coins[i];
                res += factor;
                x -= coins[i] * factor;
            }
            return res;
        };

        for (int i = 0; i < amountsToPay.size(); ++i) {
            long long x = amountsToPay[i];
            for (int newCount = 0; newCount <= 50000; newCount++) {
                if (x - 1LL * newCount * newBankNote >= 0) {
                    res[i] = min(res[i], newCount + solve(x - newCount * newBankNote));
                } else {
                    res[i] = min(res[i], solve(x));
                    break;
                }
            }
        }
        return res;
    }
};


void print(const vector<int>& v) {
    for (int i = 0; i < v.size(); ++i) cout << v[i] << ",";
    cout << endl;
}

int main()
{
    NewBankNote sol;
    print(sol.fewestPieces(4700, {53, 9400, 9401, 30000}));
    print(sol.fewestPieces(1234, {1233, 1234, 1235}));
    print(sol.fewestPieces(1000, {1233, 100047}));
    clock_t start = clock();
    vector<int> v(50, 4 * 500010000);
    print(sol.fewestPieces(50001, v));
    clock_t end = clock();
    cout << "Time taken is " << (float(end - start)) / CLOCKS_PER_SEC << endl;
}
