#include <bits/stdc++.h>
using namespace std;

class Solution {
public:

    int lower_bound_cks(int start, int end, const vector<int> &nums, int target) {
        int mid = (start + end) >> 1;
        if (nums[mid] == target &&
                ( mid == 0 || (mid - 1 >= 0 && nums[mid - 1] != target) ) )
            return mid;
        if (mid == start) return -1;

        if (nums[mid] >= target) {
            return lower_bound_cks(start, mid, nums, target);
        }
        return lower_bound_cks(mid, end, nums, target);
    }

    int upper_bound_cks(int start, int end, const vector<int> &nums, int target) {
        int mid = (start + end) >> 1;

        if (nums[mid] == target &&
            ( mid == nums.size() - 1 || (mid + 1 < nums.size() && nums[mid + 1] != target) ) )
            return mid;
        if (mid == start) return -1;

        if (nums[mid] <= target) {
            return upper_bound_cks(mid, end, nums, target);
        }
        return upper_bound_cks(start, mid, nums, target);
    }

    vector<int> searchRange(vector<int>& nums, int target) {
        int lower = lower_bound_cks(0, nums.size(), nums, target);
        int upper = upper_bound_cks(0, nums.size(), nums, target);
        return {lower, upper};
    }
};

ostream& operator<<(ostream& os, const vector<int>& v) { for (int item : v) os << item << ","; return os;}

int main() {
    Solution sol;
    vector<int> nums = {5,7,7,8,8,10};
    cout << sol.searchRange(nums, 8) << endl;
}