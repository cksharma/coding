#include "header.h"

vector<int> GrayCode::grayCode(int n) {
	vector <int> ans;
	ans.push_back(0);
	for (int i = 0; i < n; i++) {
		for (int j = ans.size() - 1; j >= 0; j--) {
			ans.push_back(ans[j] + (1 << i));
		}
	}
	return ans;
}