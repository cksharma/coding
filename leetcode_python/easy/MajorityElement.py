'''
Created on Dec 22, 2014

@author: Chandra Kant
'''
class Solution:
    # @param num, a list of integers
    # @return an integer
    def majorityElement(self, num):
        maj_index = 0;
        count = 1;
        for i in range(1, len(num), 1):
            if num[maj_index] == num[i]:
                count += 1;
            else :
                count -= 1;
            if count == 0:
                maj_index = i;
                count = 1;
        return num[maj_index];
if __name__ == '__main__':
    sol = Solution();
    lst = [1, 2, 3, 4, 1, 1, 1];
    print (sol.majorityElement(lst));