#include "header.h"

string LongestPalindromicSubstring::longestPalindrome(string s) {
	string ans = "";
	
	for (int middle = 0; middle < s.length(); middle++) {
		int left = middle;
		int right = middle;
		while (left >= 0 && right < s.length()) {
			if (s[left] == s[right]) {
				left--;
				right++;
			}
			else {
				//left++;
				break;
			}
		}
		if (right - left - 1 > ans.length()) {
			ans = s.substr(left + 1, right -left - 1);
		}
	}
	for (int even = 0; even < s.length(); even++) {
		int left = even - 1;
		int right = even;
		while (left >= 0 && right < s.length()) {
			if (s[left] == s[right]) {
				left--;
				right++;
			}
			else {
				//left++;
				break;
			}
		}
		if (right - left - 1 > ans.length()) {
			ans = s.substr(left + 1, right - left - 1);
		}
	}
	return ans;
}