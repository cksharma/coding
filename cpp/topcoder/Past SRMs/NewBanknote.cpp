#include <bits/stdc++.h>

using namespace std;

class NewBanknote {
public:

    vector<int> fewestPieces(int newBankNote, vector<int> amountsToPay) {
        vector<int> res(amountsToPay.size(), INT_MAX);
        vector<int> coins = {1, 2, 5, 10, 20, 50, 100, 200, 500,
                             1000, 2000, 5000, 10000, 20000, 50000};
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


// BEGIN KAWIGIEDIT TESTING
// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
bool KawigiEdit_RunTest(int testNum, int p0, vector<int> p1, bool hasAnswer, vector<int> p2) {
    cout << "Test " << testNum << ": [" << p0 << "," << "{";
    for (int i = 0; int(p1.size()) > i; ++i) {
        if (i > 0) {
            cout << ",";
        }
        cout << p1[i];
    }
    cout << "}";
    cout << "]" << endl;
    NewBanknote *obj;
    vector<int> answer;
    obj = new NewBanknote();
    clock_t startTime = clock();
    answer = obj->fewestPieces(p0, p1);
    clock_t endTime = clock();
    delete obj;
    bool res;
    res = true;
    cout << "Time: " << double(endTime - startTime) / CLOCKS_PER_SEC << " seconds" << endl;
    if (hasAnswer) {
        cout << "Desired answer:" << endl;
        cout << "\t" << "{";
        for (int i = 0; int(p2.size()) > i; ++i) {
            if (i > 0) {
                cout << ",";
            }
            cout << p2[i];
        }
        cout << "}" << endl;
    }
    cout << "Your answer:" << endl;
    cout << "\t" << "{";
    for (int i = 0; int(answer.size()) > i; ++i) {
        if (i > 0) {
            cout << ",";
        }
        cout << answer[i];
    }
    cout << "}" << endl;
    if (hasAnswer) {
        if (answer.size() != p2.size()) {
            res = false;
        } else {
            for (int i = 0; int(answer.size()) > i; ++i) {
                if (answer[i] != p2[i]) {
                    res = false;
                }
            }
        }
    }
    if (!res) {
        cout << "DOESN'T MATCH!!!!" << endl;
    } else if (double(endTime - startTime) / CLOCKS_PER_SEC >= 2) {
        cout << "FAIL the timeout" << endl;
        res = false;
    } else if (hasAnswer) {
        cout << "Match :-)" << endl;
    } else {
        cout << "OK, but is it right?" << endl;
    }
    cout << "" << endl;
    return res;
}

int main() {
    bool all_right;
    all_right = true;

    int p0;
    vector<int> p1;
    vector<int> p2;

    {
        // ----- test 0 -----
        p0 = 4700;
        int t1[] = {53, 9400, 9401, 30000};
        p1.assign(t1, t1 + sizeof(t1) / sizeof(t1[0]));
        int t2[] = {3, 2, 3, 2};
        p2.assign(t2, t2 + sizeof(t2) / sizeof(t2[0]));
        all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
        // ------------------
    }

    {
        // ----- test 1 -----
        p0 = 1234;
        int t1[] = {1233, 1234, 1235};
        p1.assign(t1, t1 + sizeof(t1) / sizeof(t1[0]));
        int t2[] = {6, 1, 2};
        p2.assign(t2, t2 + sizeof(t2) / sizeof(t2[0]));
        all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
        // ------------------
    }

    {
        // ----- test 2 -----
        p0 = 1000;
        int t1[] = {1233, 100047};
        p1.assign(t1, t1 + sizeof(t1) / sizeof(t1[0]));
        int t2[] = {6, 6};
        p2.assign(t2, t2 + sizeof(t2) / sizeof(t2[0]));
        all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
        // ------------------
    }

    {
        // ----- test 3 -----
        p0 = 50001;
        int t1[] = {500010000, 500010000, 500010000, 500010000, 500010000, 500010000, 500010000, 500010000, 500010000,
                    500010000, 500010000, 500010000, 500010000, 500010000, 500010000, 500010000, 500010000, 500010000,
                    500010000, 500010000, 500010000, 500010000, 500010000, 500010000, 500010000, 500010000, 500010000,
                    500010000, 500010000, 500010000, 500010000, 500010000, 500010000, 500010000, 500010000, 500010000,
                    500010000, 500010000, 500010000, 500010000, 500010000, 500010000, 500010000, 500010000, 500010000,
                    500010000, 500010000, 500010000, 500010000, 500010000};
        p1.assign(t1, t1 + sizeof(t1) / sizeof(t1[0]));
        int t2[] = {10000, 10000, 10000, 10000, 10000, 10000,10000, 10000,10000, 10000,
                    10000, 10000, 10000, 10000, 10000, 10000,10000, 10000,10000, 10000,
                    10000, 10000, 10000, 10000, 10000, 10000,10000, 10000,10000, 10000,
                    10000, 10000, 10000, 10000, 10000, 10000,10000, 10000,10000, 10000,
                    10000, 10000, 10000, 10000, 10000, 10000,10000, 10000,10000, 10000};
        p2.assign(t2, t2 + sizeof(t2) / sizeof(t2[0]));
        all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
        // ------------------
    }

    if (all_right) {
        cout << "You're a stud (at least on the example cases)!" << endl;
    } else {
        cout << "Some of the test cases had errors." << endl;
    }
    return 0;
}
// END KAWIGIEDIT TESTING
//Powered by KawigiEdit 2.1.4 (beta) modified by pivanof!