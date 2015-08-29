#include "header.h"

int MajorityElement::majorityElement(vector<int>& nums) {
	if ( nums.size() == 0) return 0;
	int ans = nums[0];
	int cnt = 1;
	for (int i = 1; i < nums.size(); i++) {
		if ( nums[i] == ans) {
			cnt++;
		} else  {
			cnt--;
		}

		if (cnt == 0) {
			ans = nums[i];
			cnt = 1;
		}
	}
	int tmpCnt = 0;
	for (auto& item : nums) {
		if (item == ans) {
			tmpCnt++;
		}
	}
	return tmpCnt > nums.size() / 2 ? ans : 0;
}
