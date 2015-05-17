'''
Created on Dec 30, 2014

@author: Chandra Kant
'''
class Solution:
    # @return an integer
    def trailingZeroes(self, n):
        ans = 0;
        cnt = 5;
        while cnt <= n:
            ans = ans + int(n / cnt);
            cnt = cnt * 5;
        return ans;

if __name__ == '__main__':
    sol = Solution();
    print (sol.trailingZeroes(100));