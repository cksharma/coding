'''
Created on Dec 30, 2014

@author: Chandra Kant
'''
class Solution:
    # @param s, a string
    # @return an integer
    def titleToNumber(self, s):
        ans = 0;
        factor = 1;
        ss = reversed(s);
        for ch in ss:
            ans = ans + (ord(ch) - 64) * factor;
            factor = factor * 26; 
        return ans;
if __name__ == '__main__':
    sol = Solution();
    print (sol.titleToNumber("AB"));