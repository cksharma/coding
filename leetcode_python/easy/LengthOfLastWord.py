'''
Created on Dec 24, 2014

@author: Chandra Kant
'''
class Solution:
    # @param s, a string
    # @return an integer
    def lengthOfLastWord(self, s):
        ans = 0;
        if s == None or len(s) == 0:
            return 0;
        s = s.strip(' ');
        j = len(s) - 1;
        
        while j >= 0:
            if s[j] == ' ':
                break;
            j = j - 1;
            ans = ans + 1;        
        return ans;
if __name__ == '__main__':
    sol = Solution();
    print (sol.lengthOfLastWord(None));