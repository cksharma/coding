#include "header.h"

int LongestSubstringWithoutRepeatingCharacters::lengthOfLongestSubstring(string s) {
	int ans = 0;
	int hash[256];
	fill(hash, hash + 256, -1);

	int start = 0;

	for (int i = 0; i < s.length(); i++) {
		if (hash[s[i]] != -1) {
			int k = hash[s[i]];
			start = max(start, k + 1);
		}
		ans = max(ans, i - start + 1);
		hash[s[i]] = i;
	}
	return ans;
}