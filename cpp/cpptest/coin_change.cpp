#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int ans = INT_MAX;
    int solve(int steps, const vector<int>& coins, int target, int idx) {
        if (target < 0) return INT_MAX;
        if (target == 0) {
            return steps;
        }
        for (int i = idx; i < coins.size(); ++i) {
            int a = solve(steps + 1, coins, target - coins[i], i);
            int b = solve(steps, coins, target, i + 1);
            ans = min(ans, min(a, b));
        }
        return ans;
    }

    int min_coins(vector<int>& coins, int target) {
        ans = INT_MAX;
        sort(coins.rbegin(), coins.rend());
        return solve(0, coins, target, 0);
    }
};

int main()
{
    Solution sol;
    vector<int> coins = {1, 2, 5, 10}; int target = 11;
    cout << sol.min_coins(coins, target) << endl;
}