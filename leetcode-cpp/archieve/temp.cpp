#include <iostream>
using namespace std;

class Solution {
public:
    bool isAnagram(string s, string t) {
        if (s.length() != t.length()) return false;
        
        int ch[26];
        fill(ch, ch + 26, 0 );
        for (int i = 0; i < s.length(); i++) {
            ch[s.at(i) - 'a']++;
            ch[t.at(i) - 'a']--;
        }
        //for (int i = 0; i < 26; i++) cout << ch[i] << ",  ";
        for (auto& item : ch) {
        	if (item != 0 ) {
        		return false;        		
        	}
        }
        return true;
        
    }
};
int main()
{
}
