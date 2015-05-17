'''
Created on Dec 24, 2014

@author: Chandra Kant
'''
class Solution:
    # @param digits, a list of integer digits
    # @return a list of integer digits
    def plusOne(self, digits):
        carry = 1;
        for i in reversed(range(len(digits))):
            value = (carry + digits[i]) % 10;
            carry = int((carry + digits[i]) / 10);
            digits[i] = value;
        if carry != 0:
            digits = [1] + digits;
        return digits;
if __name__ == '__main__':
    sol = Solution();
    digits = [9,9,9];
    print (sol.plusOne(digits));