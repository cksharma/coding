'''
Created on Dec 21, 2014

@author: Chandra Kant
'''
class Solution:
    # @return an integer
    def atoi(self, ss):
        ss = ss.strip();
        res = '';
        if len(ss) != 0 and (ss[0] == '-' or ss[0] == '+') :
            res = res + str(ss[0]);
            ss = ss[1:];
        for i in range(len(ss)) :
            if ss[i] >= '0' and ss[i] <= '9' :
                res = res + str(ss[i]);
            else :
                break;
        INT_MAX = (1 << 31) - 1;
        INT_MIN = -1 << 31;
        if (len(res) == 0 or (len(res) == 1 and (res[0] == '-' or res[0] == '+'))):
            ans = 0;
        
        else :
            if len(res) >= 12 and res[0] == '-' :
                ans = -(1 << 31);
            elif len(res) >= 12 :
                ans = (1 << 31) - 1;
            else :
                ck = float(res);
                if ck > INT_MAX :
                    ans = INT_MAX;
                elif ck < INT_MIN:
                    ans = INT_MIN;
                else:
                    ans = ck;
            
        
        return int(ans);            
if __name__ == '__main__':
    sol = Solution();
    print(sol.atoi("12345677"));
    print(sol.atoi("99999345677"));
    print(sol.atoi("  -9223372036854775809  "));
    print(sol.atoi("  -12345677  787767"));
    print(sol.atoi("  -98abcd 123455  "));
    print(sol.atoi("  -9090909090  787767"));
    print(sol.atoi("  9090909090  787767"));
    print(sol.atoi("  +1"));
    print(sol.atoi("  -0012a42"));
    
    