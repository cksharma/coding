#include "header.h"

void LetterCombinationsOfAPhoneNumber::recurse(string ch, int steps) {
	if (steps == digits.length()) {
		ans.push_back(ch.substr(0, steps));
		return;
	}
	string kk = mp.at(digits.at(steps));
	
	for (int i = 0; i < (int)kk.size(); i++) {
		ch[steps] = kk[i];
		recurse(ch, steps + 1);
	}
}

vector<string> LetterCombinationsOfAPhoneNumber::letterCombinations(string digits) {
	this->digits = digits;
	mp.insert(make_pair('2', "abc"));
	mp.insert(make_pair('3', "def"));
	mp.insert(make_pair('4', "ghi"));
	mp.insert(make_pair('5', "jkl"));
	mp.insert(make_pair('6', "mno"));
	mp.insert(make_pair('7', "pqrs"));
	mp.insert(make_pair('8', "tuv"));
	mp.insert(make_pair('9', "wxyz"));
	
	recurse("abcd", 0);
	
	return this->ans;
}


