'''
Created on Dec 22, 2014

@author: Chandra Kant
'''
# Definition for a  binary tree node
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    # @param p, a tree node
    # @param q, a tree node
    # @return a boolean
    def isSameTree(self, p, q):
        if p == None and q == None:
            return True;
        if p == None or q == None:
            return False;
        if p.val != q.val:
            return False;
        return self.isSameTree(p.left, q.left) and self.isSameTree(p.right, q.right);
if __name__ == '__main__':
    root = TreeNode(1);
    root.left = TreeNode(2);
    root.right = TreeNode(2);
    root.left.left = TreeNode(4);
    root.left.right = TreeNode(5);
    root.right.left = TreeNode(5);
    root.right.right = TreeNode(5);
    
    root1 = TreeNode(1);
    root1.left = TreeNode(2);
    root1.right = TreeNode(2);
    root1.left.left = TreeNode(4);
    root1.left.right = TreeNode(5);
    root1.right.left = TreeNode(5);
    root1.right.right = TreeNode(5);
    
    sol = Solution();
    print (sol.isSameTree(root, root1));
    