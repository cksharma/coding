#include "header.h"
vector<int> MajorityElementII::majorityElement(vector<int>& v) {
	if (v.size() == 0) return v;
	int ans1 = v[0], ans2 = INT_MIN;
	int cnt1 = 0, cnt2 = 0;
	//initialize the ans2 also with some value not equal to ans1.
	
	for (int i = 0; i < v.size(); i++) {
		if ( v[i] == ans1) {
			cnt1++;
		} else if (v[i] == ans2) {
			cnt2++;
		} else if (cnt1 == 0) {
			ans1 = v[i]; cnt1 = 1;	
		} else if (cnt2 == 0) {
			ans2 = v[i]; cnt2 = 1;
		} else  {
			cnt1 = max(cnt1 - 1, 0);
			cnt2 = max(cnt2 - 1, 0);
		}
	}
	vector<int> res; res.push_back(ans1);
	if ( ans2 != INT_MIN) res.push_back(ans2);
	return res;
}
