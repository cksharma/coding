'''
Created on Dec 22, 2014

@author: Chandra Kant
'''
class Solution:
    # @return a boolean
    def isValid(self, s):
        open1 = [];
        #clos1 = [];
        for ch in s:
            if ch == '{' or ch == '[' or ch == '(':
                open1.append(ch);
            else :
                L = len(open1);
                if ch == '}' and L != 0 and open1[L - 1] == '{':
                    open1.pop();
                elif ch == ']' and L != 0 and open1[L - 1] == '[':
                    open1.pop();
                elif ch == ')' and L != 0 and open1[L - 1] == '(':
                    open1.pop();
                else:
                    return False;
        
        return True and len(open1) == 0;
                  
if __name__ == '__main__':
    sol = Solution();
    print (sol.isValid("[{()}]"));
    print (sol.isValid("[{(})]"));
    print (sol.isValid("{[()}]"));
    print (sol.isValid("(()))"));
    print (sol.isValid("["));