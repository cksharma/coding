#include <bits/stdc++.h>
using namespace std;

class Solution {
public:

    vector<vector<int>> ans;
    int target;
    int k;

    void subsets_recurse(int S[], int index, int arr[], int runningSum) {

        arr[index] = 1;
        if (runningSum + S[index] == target) {
            vector<int> list;
            for (int i = 0; i <= index; i++) {
                if (arr[i] != 0)
                    list.push_back(S[i]);
            }
            if (list.size() == k)
                ans.push_back(list);
        } else if (index + 1 < target && runningSum + S[index] < target) {
            subsets_recurse(S, index + 1, arr, runningSum + S[index]);
        }
        if (index + 1 < target && runningSum + S[index + 1] <= target) {
            arr[index] = 0;
            subsets_recurse(S, index + 1, arr, runningSum);
        }
    }

    vector<vector<int>> combinationSum3(int k, int n) {
        this->target = n;
        this->k = k;
        int S[n];
        int arr[n];
        fill(arr, arr + n, 0);
        for (int i = 0; i < n; i++) S[i] = i + 1;
        subsets_recurse(S, 0, arr, 0);
        return ans;
    }
};

int main() {
    Solution sol;
    vector<vector<int>> v = sol.combinationSum3(3, 9);
    cout << v.size() << endl;
    for (auto& item : v) {
        for (auto& item1 : item) {
            cout << item1 << " ";
        }
        cout << endl;
    }
}