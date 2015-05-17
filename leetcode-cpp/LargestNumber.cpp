#include "header.h"

bool sortNumbers(const int& f, const int& s) {
	string ff = to_string(f);
	string ss = to_string(s);

	string first = ff + ss;
	string secon = ss + ff;
	for (int i = 0; i < first.length(); i++) {
		if (first.at(i) < secon.at(i)) return false;
		if (first.at(i) > secon.at(i)) return true;
	}
	return false;
}

string LargestNumber::largestNumber(vector<int> &num) {
	sort(num.begin(), num.end(), sortNumbers);
	string ans = "";
	bool zeros = true;

	for (auto x : num) {
		if (x == 0 and zeros) continue;
		ans = ans + to_string(x);
		zeros = false;
	}
	return ans.length() == 0 ? "0" : ans;
}