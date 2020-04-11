#include <bits/stdc++.h>
using namespace std;

class AFeedingChicken {
public:
    const string S = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    void solve(istream& cin, ostream& cout) {
        ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
        cout.setf(ios::fixed); cout.precision(20);
        int T, r, c, k; char ch;
        cin >> T;
        while (T-->0) {
            cin >> r >> c >> k;
            map<int, int> rabbitMap;
            int total = 0;
            vector<string> input(r, string(c, ' '));
            vector<string> output(r, string(c, ' '));
            for (int i = 0; i < r; ++i) {
                for (int j = 0; j < c; ++j) {
                    cin >> ch;
                    input[i][j] = ch;
                    total += (ch == 'R');
                }
            }
            int x = 0, y = 0, rabNo = 0, eachShare = total / k, extraAllowed = total - eachShare * k;
            for (int i = 0; i < r; ++i) {
                for (int j = 0; j < c; ++j) {
                    y = j;
                    if (i & 1) y = (c - j - 1);
                    if (input[i][y] == 'R') {
                        if (rabbitMap[rabNo] < eachShare ) {
                            rabbitMap[rabNo]++;
                            output[i][y] = S[rabNo];
                        }
                        else {
                            if (extraAllowed > 0) {
                                output[i][y] = S[rabNo];
                                rabbitMap[rabNo]++;
                                rabNo++;
                                extraAllowed--;
                            } else {
                                rabNo++;
                                rabbitMap[rabNo]++;
                                output[i][y] = S[rabNo];
                            }
                        }
                    } else {
                        output[i][y] = S[rabNo];
                    }
                }
            }
            for (int i = 0; i < r; ++i) {
                cout << output[i] << endl;
            }
        }
    }
};
