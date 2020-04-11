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
    
    def recurse(self, root, sum, running_sum):
        if root == None:
            return False;
        if root.left == None and root.right == None and running_sum + root.val == sum:
            return True;
        left = self.recurse(root.left, sum, running_sum + root.val);
        right = self.recurse(root.right, sum, running_sum + root.val);
        return left or right;
    # @param root, a tree node
    # @param sum, an integer
    # @return a boolean
    def hasPathSum(self, root, sum):
        return self.recurse(root, sum, 0);
if __name__ == '__main__':
    root = TreeNode(1);
    root.left = TreeNode(2);
#     root.right = TreeNode(3);
#     root.left.left = TreeNode(4);
#     root.left.right = TreeNode(5);
#     root.right.left = TreeNode(9);
    
    sol = Solution();
    print (sol.hasPathSum(root, 3));
    print (sol.hasPathSum(root, 1));
    print (sol.hasPathSum(root, 7));