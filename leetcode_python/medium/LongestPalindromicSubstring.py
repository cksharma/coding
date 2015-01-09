'''
Created on Dec 30, 2014

@author: Chandra Kant
'''
class Solution:
    # @return a string
    def longestPalindrome(self, s):
        ans = "";
    
        for middle in range(len(s)):
            left = middle;
            right = middle;
            while (left >= 0 and right < len(s)) :
                if (s[left] == s[right]) :
                    left -= 1;
                    right += 1;
                else :
                    break;
                
            if (right - left - 1 > len(ans)) :
                ans = s[left + 1:right];
               
        for even in range(len(s)):
            left = even - 1;
            right = even;
            while (left >= 0 and right < len(s)) :
                if (s[left] == s[right]) :
                    left -= 1;
                    right += 1;
                
                else :
                    break;
             
            if (right - left - 1 > len(ans)) :
                ans = s[left + 1:right];
            
        return ans;
if __name__ == '__main__':
    sol = Solution();
    print(sol.longestPalindrome("aaa"));
    print(sol.longestPalindrome("aab"));
    print(sol.longestPalindrome("kjhhhhkkjh"));
    print(sol.longestPalindrome("aajja"));