'''
Created on Dec 21, 2014

@author: Chandra Kant
'''
class Solution:
    # @return an integer
    def romanToInt(self, s):
        ans = 0;
        s = s[::-1];
        dct = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C':100, 'D':500, 'M':1000};
        cur_value = 0;
        for ch in s:
            if dct[ch] >= cur_value:
                cur_value = dct[ch];
                ans = ans + cur_value;                
            else:
                ans = ans - dct[ch];
        return ans;
if __name__ == '__main__':
    sol = Solution();
    print(sol.romanToInt("I"));
    print(sol.romanToInt("IV"));
    print(sol.romanToInt("XXII"));
    print(sol.romanToInt("XIX"));
    print(sol.romanToInt("MM"));
    print(sol.romanToInt("D"));