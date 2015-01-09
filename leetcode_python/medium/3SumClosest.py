'''
Created on Dec 27, 2014

@author: Chandra Kant
'''
class Solution:
    # @return an integer
    def threeSumClosest(self, num, target):
        ans = 1 << 30;
        num = sorted(num);
        for i in range(len(num)):
            val = (self.findMin(i, i + 1, len(num) - 1, target, num));
            if abs(val) < abs(ans):
                ans = val;
            #print (val, ans, end = "  , ")
        return ans + target;
    
    def findMin(self, f, m, l, target, num):
        ans = 1 << 30;
        while m < l:
            _sum = num[f] + num[m] + num[l];
            diff = (_sum - target);
            if diff <= 0 and abs(diff) <= abs(ans):
                ans = diff;
                m = m + 1;
            elif diff >= 0 and diff <= abs(ans):
                ans = diff;
                l = l - 1;
            elif diff <= 0 and abs(diff) >= abs(ans):
                m = m + 1;
            elif diff >= 0 and diff >= abs(ans):
                l = l - 1;
                
        return ans;       
    
if __name__ == '__main__':
    sol = Solution();
    #num = [-1, 2, 1, -4];
    #target = 1;
    num = [0,1,2];
    target = 3;
    print (sol.threeSumClosest(num, target));