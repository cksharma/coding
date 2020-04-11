#include <iostream>
using namespace std;

class Solution {
public:
    bool isValid(string s) {
        if(s.size() < 1)
            return true;
        
        char stack[s.size()];
        int cursor = 0, top = 0;
        stack[top++] = s[cursor++];
        while(top > 0)
        {
            if(cursor >= s.size() - 1) 
                break;
            
            stack[top++] = s[cursor++];
            
            if(stack[top-1] == stack[top-2])
                top-=2;
            
            if(cursor == s.size()-1) 
                break;
            
            stack[top++] = s[cursor++];
        }
        
        return (top==0);
    }
};

int main() {
	Solution sol;
    cout << sol.isValid("[") << endl;
    cout << sol.isValid("()") << endl;
    cout << sol.isValid("((") << endl;
}