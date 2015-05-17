'''
Created on Dec 24, 2014

@author: Chandra Kant
'''
class Solution:
    
    def computeSum(self, v1, v2, carry):
        arr = [0] * 2;
        sum = int(v1) + carry + int(v2);
        if (sum & 1) != 0:
            arr[0] = 1;
        if int(sum / 2) != 0:
            arr[1] = 1;
        return arr;
    # @param a, a string
    # @param b, a string
    # @return a string
    def addBinary(self, a, b):
        ans = "";
        carry = 0;
        i = len(a) - 1;
        j = len(b) - 1;
        
        while i >= 0 and j >= 0:
            arr = self.computeSum(a[i], b[j], carry);
            ans = ans + str(arr[0]);
            carry = arr[1];
            i = i - 1;
            j = j - 1;
        while i >= 0:
            arr = self.computeSum(a[i], 0, carry);
            ans = ans + str(arr[0]);
            carry = arr[1];
            i = i - 1;
        while j >= 0:
            arr = self.computeSum(0, b[j], carry);
            ans = ans + str(arr[0]);
            carry = arr[1];
            j = j - 1;
        if carry != 0:
            ans = ans + "1";
        return ans[::-1];
if __name__ == '__main__':
    sol = Solution();
    print (sol.addBinary("11", "1"));
    print (sol.addBinary("1", "111"));