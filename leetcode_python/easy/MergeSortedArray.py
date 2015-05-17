'''
Created on Dec 22, 2014

@author: Chandra Kant
'''
class Solution:
    # @param A  a list of integers
    # @param m  an integer, length of A
    # @param B  a list of integers
    # @param n  an integer, length of B
    # @return nothing
    def merge(self, A, m, B, n):
        for index in reversed(range(0, m)):
            A[index + n] = A[index];
        cur = 0;
        i = n; j = 0;
        #print(A);
        while i < m + n and j < n:
            if A[i] <= B[j]:
                A[cur] = A[i];
                i = i + 1;
            else:
                A[cur] = B[j];
                j = j + 1;
            cur = cur + 1;   
        while j < n:
            A[cur] = B[j];
            j = j + 1;
            cur = cur + 1;
        while i < m + n:
            A[cur] = A[i];
            i = i + 1; 
            cur = cur + 1;
        return A;
       
if __name__ == '__main__':
    sol = Solution();
#     A = [2, 6, 9, 10, 0, 0, 0, 0];
#     m = 4;
#     B = [3, 4, 11, 13];
#     n = 4;
#     K = sol.merge(A, m, B, n);
#     print (K);
#     print("=======================")
    A = [1,2,4,5,6];
    B = [3];
    m = len(A) - len(B);
    n = len(B);
    A = [-10,-10,-10,-10,-9,-9,-9,-9,-9,-8,-8,-8,-8,-8,-7,-6,-6,-6,-6,-6,-6,-6,-5,-5,-5,-4,-4,-4,-4,-4,-4,-4,-4,-3,-3,-3,-2,-2,-1,-1,-1,0,0,0,0,0,1,1,1,1,1,2,2,2,2,2,3,3,3,3,3,3,4,5,5,5,5,5,5,5,6,6,6,6,6,7,7,7,7,7,7,8,8,8,8,8,9,9,9,9,-10,-10,-10,-10,-10,-10,-9,-9,-9,-8,-8,-8,-8,-7,-7,-7,-7,-7,-7,-6,-6,-6,-6,-6,-6,-5,-5,-5,-5,-4,-4,-4,-3,-3,-3,-3,-2,-2,-2,-2,-2,-2,-1,-1,0,1,1,1,2,2,2,2,2,2,2,2,2,3,3,4,4,4,5,5,5,5,6,6,6,6,6,6,6,7,8,8,8,9,9,9,9,9];
    B = [-10,-10,-10,-10,-10,-10,-9,-9,-9,-8,-8,-8,-8,-7,-7,-7,-7,-7,-7,-6,-6,-6,-6,-6,-6,-5,-5,-5,-5,-4,-4,-4,-3,-3,-3,-3,-2,-2,-2,-2,-2,-2,-1,-1,0,1,1,1,2,2,2,2,2,2,2,2,2,3,3,4,4,4,5,5,5,5,6,6,6,6,6,6,6,7,8,8,8,9,9,9,9,9];
    m = len(A) - len(B);
    n = len(B);
    K = sol.merge(A, m, B, n);
    print (K);
    print(sorted(K));
    if K == sorted(K):
        print('got sorted');
    if len(K) == len(A):
        print('same');
    
    