#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        if (strs.size() == 0) return "";
        int min_len = INT_MAX;
        for (string& item : strs) {
            min_len = min(min_len, (int)item.size());
        }
        string ss;
        for (string& item : strs) {
            if ((int)item.size() == min_len) {
                ss = item;
                break;
            }
        }
        map<int, map<char, int>> mp;
        int N = strs.size();
        for (string& str : strs) {
            for (int i = 0; i < str.length(); i++) {
                map<char, int>& asValueMap = mp[i];
                if ((int)asValueMap.size() == 0) {
                    asValueMap[str.at(i)] = 1;
                } else if ( asValueMap.size() == 1 && asValueMap.begin()->first == str.at(i)) {
                    asValueMap[str.at(i)]++;
                }    
            }
        }
        int len = 0;
        for (int i = 0; i < ss.length(); i++) {
            map<char, int>& asValueMap = mp[i];
            if (asValueMap.size() == 1 && asValueMap.begin()->second == N) {
                len++;
            } else {
                break;
            }
        }
        return strs[0].substr(0, len);
    }
};


