'''
Created on Dec 21, 2014

@author: Chandra Kant
'''
from _testcapi import INT_MAX, INT_MIN
class Solution:
    def getLong(self, x) :
        ans = 0;
        while x != 0: 
            md = x % 10;
            ans = ans * 10 + md;
            x = int(x / 10);
        return ans;
    
    # @return a boolean
    def isPalindrome(self, x):
        #return str(x) == str(x)[::-1];
        if x < 0:
            return False;
        ans = self.getLong(x);
        return ans == int(x);
if __name__ == '__main__':
    sol = Solution();
    
    print(sol.isPalindrome(1234321));
    print(sol.isPalindrome(222222222));
    print(sol.isPalindrome(-1234321));
    print(sol.isPalindrome(7));
    print(sol.isPalindrome(10));
    print(INT_MAX);
    print(INT_MIN);