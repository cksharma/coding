#include <bits/stdc++.h>
using namespace std;
class Solution {
  public:
    bool isMatch(string s, string p) {
        int si = s.size() - 1;
        int pi = p.size() - 1;
        bool dp[si];
        fill(dp, dp + si, false);
        while(pi >= 0 && si >= 0 ) {
        	char ch = p.at(pi);
        	if(ch == '*') break;
        	if(ch != s.at(si)) {
        		return false;	
        	}
        	dp[si] = true;
        	si--;
        	pi--;         	
        }

        while(si >= 0 && pi >= 0 ) {
        	break;		
        }
        
    }
};

int main() {
	
}