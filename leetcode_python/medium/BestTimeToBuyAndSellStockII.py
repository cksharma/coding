'''
Created on Dec 31, 2014

@author: Chandra Kant
'''
class Solution:
    # @param prices, a list of integer
    # @return an integer
    def maxProfit(self, prices):
        if (prices == None or len(prices) == 0): return 0;
        ans = 0;
        running_sum = 0;
                
        for i in range(1, len(prices)) :
            diff = prices[i] - prices[i - 1];
            running_sum += diff;
            
            if running_sum < 0:
                running_sum = 0;
            if diff > 0:
                ans += diff;               
        return ans;
if __name__ == '__main__':
    sol = Solution();
    prices = [6, 7, 5, 7, 7, 10, 4, 8, 9, 14, 11, 2, 13];
    print(sol.maxProfit(prices));