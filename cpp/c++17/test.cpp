#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    
    string add(string s) {
        string ans = ""; int carry = 1;
        for (int i = s.size() - 1; i >= 0; --i) {
            int sum = (s[i] - '0') + carry;
            ans = to_string(sum % 2) + ans;
            carry = (sum == 2) ? 1: 0;
        }
        return ans;
    }
    
    int numSteps(string s) {
        int steps = 0;
        while (s != "1" && ++steps) {
            if (s.back() == '0') s = s.substr(0, s.size() - 1);
            else s = add(s);
            cout << "CKS " << s << "\t";
            if (steps > 10) break;
        }
        return steps;
    }
};

int main()
{
    Solution sol;
    cout << sol.numSteps("1101") << endl;
}