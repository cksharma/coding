'''
Created on Dec 20, 2014

@author: Chandra Kant
'''
class Solution:
    # @return a string
    def convertToTitle(self, num):
        sb = str("");
        num = num - 1;
        while num >= 0 :
            m = num % 26;
            sb += chr(ord('A') + int(m));
            num = num / 26 - 1;
        
        sb = sb[::-1];
        return sb;

if __name__ == '__main__':
    sol = Solution();
    ans = sol.convertToTitle(53);
    print (ans);