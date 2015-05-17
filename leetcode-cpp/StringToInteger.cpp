#include "header.h"

long long toLL(string s) {
	stringstream ss(s);
	long long ans;
	ss >> ans;
	return ans;
}

int StringToInteger::atoi(const char *s) {
	int ans = 0;
	string res = "";
	string str(s);
	
	for (int i = 0; i < str.size(); i++) {
		if (str.at(i) != ' ') {
			str = str.substr(i);
			break;
		}
	}

	if (!str.empty() && (str.at(0) == '-' || str.at(0) == '+')) {
		res += str.at(0);
		str = str.substr(1);
	}

	for (int i = 0; i < str.length(); i++) {
		if (str.at(i) >= '0' && str.at(i) <= '9') {
			res += str.at(i);
		}
		else {
			break;
		}
	}
	if (res.length() == 0 || (res.length() == 1 && (res.at(0) == '-' || res.at(0) == '+'))) {
		ans = 0;
	}
	else {
		if (res.length() >= 12 && res.at(0) == '-') {
			ans = INT_MIN;
		}
		else if (res.length() >= 12) {
			ans = INT_MAX;
		}
		else {
			long long ck = toLL(res);
			if (ck > INT_MAX)
				ans = INT_MAX;
			else if (ck < INT_MIN) {
				ans = INT_MIN;
			}
			else {
				ans = (int)ck;
			}
		}
	}
	return ans;
}

