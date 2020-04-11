'''
Created on Dec 21, 2014

@author: Chandra Kant
'''
class Solution:
    # @param s, a string
    # @return a boolean
    def isPalindrome(self, s):
        if s == None or len(s) == 0:
            return True;
        s = s.lower();
        i = 0;
        j = len(s) - 1;
        ans = True;
        while i < j:
            if not(str(s[i]).isalpha() or str(s[i]).isdigit()):
                i = i + 1;
                continue;
            if not(str(s[j]).isalpha() or str(s[j]).isdigit()):
                j = j - 1;
                continue;
            if s[i] != s[j]:
                ans = False;
                break;
            i = i + 1;
            j = j - 1;   
        return ans;
if __name__ == '__main__':
    sol = Solution();
    print(sol.isPalindrome("A man, a plan, a canal: Panama"));
    print(sol.isPalindrome("race a car"));