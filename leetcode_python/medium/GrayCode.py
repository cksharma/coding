'''
Created on Jan 10, 2015

@author: cksharma
'''
class Solution:
    # @return a list of integers
    def grayCode(self, n):
        ans = list();
        ans.append(0);
        for i in range(n):
            for j in reversed(range(len(ans))):
                ans.append(ans[j] + (1 << i));
        return ans;
if __name__ == '__main__':
    sol = Solution();
    print (sol.grayCode(3));