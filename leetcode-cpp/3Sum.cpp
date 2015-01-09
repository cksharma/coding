#include "header.h"

void getTriplets(vector <int> &num, int f, int m, int l, vector<vector<int>> &ans) {
	while (m < l) {
		if (num[f] + num[m] + num[l] == 0) {
			vector <int> k(3);
			k[0] = num[f], k[1] = num[m], k[2] = num[l];
			ans.push_back(k);
			l = l - 1;
			m = m + 1;
		}
		else if (num[f] + num[m] + num[l] > 0) {
			l = l - 1;
		}
		else {
			m = m + 1;
		}
	}
}

vector<vector<int>> ThreeSum::threeSum(vector<int> num) {
	sort(num.begin(), num.end());
	vector <vector<int>> ans;
	//if (num.size() <= 2) return ans;
	for (int f = 0; f < (int)num.size() - 2; f++) {
		if (f > 0 && num[f] == num[f - 1]) continue;
		int temp1 = f + 1;
		int temp2 = num.size() - 1;
		while (temp2 - 1 > temp1 && temp1 > f && num[temp1] + num[temp2] + num[f] > 0)
			temp2 = temp2 - 1;
		while (temp2 - 1 > temp1 && temp1 > f && num[temp1] + num[temp2] + num[f] < 0)
			temp1 = temp1 + 1;
		getTriplets(num, f, temp1, temp2, ans);
	}
	sort(ans.begin(), ans.end());
	ans.resize(std::distance(ans.begin(), unique(ans.begin(), ans.end())));
	return ans;
}