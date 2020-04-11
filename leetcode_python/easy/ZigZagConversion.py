'''
Created on Dec 21, 2014

@author: Chandra Kant
'''

class Solution:
    # @return a string
    def convert(self, s, nRows):
        nRows = min(nRows, len(s));
        maxJump = (nRows - 1) * 2;
        first = maxJump;
        secon = 0;
        ans = "";
        
        if first == 0 and secon == 0:
            ans = s;
        else :      
            for i in range(nRows) :
                cnt = i;
                ans = ans + s[cnt];
                secon = maxJump - first;
                while cnt < len(s) :
                    cnt = cnt + first;
                    if cnt < len(s) and first != 0:
                        ans = ans + s[cnt];
                    cnt = cnt + secon;
                    if cnt < len(s) and secon != 0:
                        ans = ans + s[cnt];
                        
                first = first - 2;
                #secon = secon + 2;            
        return ans;           

if __name__ == '__main__':
    sol = Solution();
    print(sol.convert("PAYPALISHIRING", 3));
    print(sol.convert("ABC", 2));
    print(sol.convert("A", 1));
    print(sol.convert("A", 2));
    print(sol.convert("", 1));