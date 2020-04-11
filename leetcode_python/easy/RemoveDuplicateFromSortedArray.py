'''
Created on Dec 23, 2014

@author: Chandra Kant
'''
class Solution:
    # @param a list of integers
    # @return an integer
    def removeDuplicates(self, A):
        cnt = 0;
        if A == None :
            return 0;
        for i in range(1,len(A)) :
            if A[i - 1] == A[i]:
                cnt += 1;
            A[i - cnt] = A[i];
        return len(A) - cnt;
if __name__ == '__main__':
    sol = Solution();
    A = [1, 2, 2, 3, 3, 4, 5];
    print (sol.removeDuplicates(A));
    print (A);