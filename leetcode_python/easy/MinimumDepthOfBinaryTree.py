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
    # @param root, a tree node
    # @return an integer
    def minDepth(self, root):
        if root == None:
            return 0;
        if root.left == None and root.right == None:
            return 1;
        left = 1 << 30;
        right = 1 << 30;
        if root.left != None:
            left = 1 + self.minDepth(root.left);
        if root.right != None:
            right = 1 + self.minDepth(root.right);
        return min(left, right);
if __name__ == '__main__':
    root = TreeNode(1);
    root.left = TreeNode(2);
    root.right = TreeNode(3);
    root.left.left = TreeNode(4);
    root.left.right = TreeNode(5);
    
    sol = Solution();
    print (sol.minDepth(root));