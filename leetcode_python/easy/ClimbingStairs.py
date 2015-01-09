'''
Created on Dec 23, 2014

@author: Chandra Kant
'''
class Solution:
    def __init__(self):
        self.dp = [0] * 10000;
        self.dp[1] = 1;
        self.dp[2] = 2;       
    # @param n, an integer
    # @return an integer
    def climbStairs(self, n):
        if n <= 2:
            return n;
        if self.dp[n] > 0:
            return self.dp[n];
        self.dp[n] = self.climbStairs(n - 2) + self.climbStairs(n - 1);
        return self.dp[n];
if __name__ == '__main__':
    sol = Solution();
    print (sol.climbStairs(4));