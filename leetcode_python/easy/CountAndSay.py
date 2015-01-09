'''
Created on Dec 24, 2014

@author: Chandra Kant
'''
class Solution:
    
    def getNthItem(self, ss):
        ans = '';
        cnt = 1;
        for i in range(1, len(ss)):
            if ss[i] == ss[i - 1]:
                cnt = cnt + 1;
            else:
                ans += str(cnt) + ss[i - 1];
                cnt = 1;
        #if cnt > 0:
        ans += str(cnt) +  ss[len(ss) - 1];
        return ans;
    
    # @return a string
    def countAndSay(self, n):
        ans = "1";
        for i in range(2, n + 1):
            ans = self.getNthItem(ans);
        return ans;       
             
if __name__ == '__main__':
    sol = Solution();
    print (sol.countAndSay(1));
    print (sol.countAndSay(2));
    print (sol.countAndSay(3));
    print (sol.countAndSay(4));
    print (sol.countAndSay(5));