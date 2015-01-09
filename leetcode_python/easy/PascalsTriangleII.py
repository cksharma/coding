'''
Created on Dec 21, 2014

@author: Chandra Kant
'''
class Solution:
    
    def calculate(self, i, base, rowIndex):
        ans = 1;
        while i > 0:
            ans = ans * (rowIndex - i + 1);
            if ans % base == 0 and base != 1:
                ans = ans / base;
                base = 1;
            i = i - 1;
        return int(ans);
    # @return a list of integers
    def getRow(self, rowIndex):
        ans = [];
        base = 1;
        for i in range(int(1 + (rowIndex + 1) / 2)):
            if (i == ((rowIndex + 1) / 2)) and rowIndex % 2 == 1:
                break;
            ans.append(self.calculate(i, base, rowIndex));
            base = base * (i + 1);
        ans1 = [];
        if rowIndex % 2 == 0:
            ans1 = ans[:len(ans)-1];
        else :
            ans1 = ans[:len(ans)];
        ans1 = reversed(ans1);
        ans = list(ans) + list(ans1);
        return ans;
        
if __name__ == '__main__':
    sol = Solution();
    print (sol.getRow(8));
    print (sol.getRow(3));
    print (sol.getRow(2));
    print (sol.getRow(1));
    print (sol.getRow(0));