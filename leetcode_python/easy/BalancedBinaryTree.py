'''
Created on Dec 20, 2014

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
    # @return a boolean
    def isBalanced(self, root):
        self.value = True;
        self.getHeight(root)        
        return self.value;
    
    def getHeight(self, root):
        if root == None :
            return 0;
        if root.left == None and root.right == None:
            return 1;
        left_height = 1 + self.getHeight(root.left);
        right_height = 1 + self.getHeight(root.right);
        if abs(left_height - right_height) > 1:
            self.value = False;
        return max(left_height, right_height);
        
if __name__ == '__main__':
    
    tree = TreeNode(1);
    tree.left = TreeNode(2);
    tree.right = TreeNode(3);
    tree.left.left = TreeNode(4);
    tree.left.left.left = TreeNode(5);
    
    sol = Solution();
    value = sol.isBalanced(tree);
    print(value);
    