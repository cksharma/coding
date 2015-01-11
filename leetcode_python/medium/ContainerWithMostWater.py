'''
Created on Jan 11, 2015

@author: cksharma
'''
class Solution:
    # @return an integer
    def maxArea(self, height):
        i = 0; 
        j = len(height) - 1;
        ans = 0;
        while i < j:
            ans = max(ans, min(height[i], height[j]) * (j - i));
            if height[i] < height[j]:
                i += 1;
            else:
                j -= 1;
        return ans;
if __name__ == '__main__':
    sol = Solution();
    print (sol.maxArea([5, 4, 7, 8, 6, 3]));