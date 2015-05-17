'''
Created on Jan 1, 2015

@author: Chandra Kant
'''
class Solution:
    def __init__(self):
        self.map = {'2': ['a', 'b', 'c'],
                    '3': ['d', 'e', 'f'],
                    '4': ['g', 'h', 'i'],
                    '5': ['j', 'k', 'l'],
                    '6': ['m', 'n', 'o'],
                    '7': ['p', 'q', 'r', 's'],
                    '8': ['t', 'u', 'v'],
                    '9': ['w', 'x', 'y', 'z']};
        
    # @return a list of strings, [s1, s2]
    def letterCombinations(self, digits):
        self.digits = digits;
        self.ans = list();
        ch = ['a' for col in range(len(digits))];
        self.recurse(ch, 0);
        return self.ans;
    
    def recurse(self, ch, steps):
        if (steps == len(self.digits)):
            ss = "";
            for i in range(steps):
                ss += ch[i];
            self.ans.append(ss);
            return;
        lst = self.map[self.digits[steps]];
        for item in lst:
            ch[steps] = item;
            self.recurse(ch, steps + 1);        
        
if __name__ == '__main__':
    sol = Solution();
    print (sol.letterCombinations("23"));