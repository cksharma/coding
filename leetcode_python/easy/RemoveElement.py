'''
Created on Dec 23, 2014

@author: Chandra Kant
'''
class Solution:
    # @param    A       a list of integers
    # @param    elem    an integer, value need to be removed
    # @return an integer
    def removeElement(self, A, elem):
        cnt = 0;
        for item in A:
            if item == elem:
                cnt += 1;
        i = 0;
        j = len(A) - 1;
        while i < j:
            if A[i] == elem and A[j] != elem:
                A[i], A[j] = A[j], A[i];
            elif A[j] == elem:
                j = j - 1;
            elif A[i] != elem:
                i = i + 1;
        return len(A) - cnt;
if __name__ == '__main__':
    A = [1, 2, 3, 4, 5, 6, 6, 7];
    elem = 6;
    sol = Solution();
    print (sol.removeElement(A, elem));
    print (A);
    
    A = [4,5];
    elem = 4;
    print (sol.removeElement(A, elem));
    print(A);