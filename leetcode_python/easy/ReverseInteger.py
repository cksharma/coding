'''
Created on Dec 21, 2014

@author: Chandra Kant
'''
class Solution:
    # @return an integer
    def reverse(self, x):
        tmp = abs(x);
        num = 0;
        max_value = ((1 << 31) - 1);
        while tmp != 0:
            md = tmp % 10;
            num = num * 10 + md;
            tmp = int(tmp / 10);
        if num > max_value:
            num = 0;
        if x < 0:
            num = num * -1;
        return int(num);     
if __name__ == '__main__':
    sol = Solution();
    print(sol.reverse(1 << 31 - 1));
    print(sol.reverse(0));
    print(sol.reverse(100));
    print(sol.reverse(1234));
    print(sol.reverse(-1234));
    print(sol.reverse(156));
    print(sol.reverse(-2147483412));
