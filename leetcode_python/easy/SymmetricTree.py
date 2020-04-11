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
    
    def createMirror(self, root):
        if root == None:
            return None;
        if root.left == None and root.right == None:
            return root;
        left = self.createMirror(root.left);
        right = self.createMirror(root.right);
        
        temp = TreeNode(root.val);
        temp.left = right;
        temp.right = left;        
        return temp;
    def isMirror(self, root, mirror):
        if root == None and mirror == None:
            return True;
        if root == None or mirror == None:
            return False;
        if root.val != mirror.val:
            return False;
        return self.isMirror(root.left, mirror.left) and self.isMirror(root.right, mirror.right);
    
    def cloneTree(self, root):
        if root == None:
            return;                        
        left = self.cloneTree(root.left);
        right = self.cloneTree(root.right);
        mirror = TreeNode(root.val);
        mirror.left = left;
        mirror.right = right;
        return mirror;
    # @param root, a tree node
    # @return a boolean
    def isSymmetric(self, root):
        mirror = self.cloneTree(root);
        mirror = self.createMirror(mirror);
        return self.isMirror(root, mirror);
    
    def printTree(self, root):
        if root == None:
            return;
        print(root.val, end=' ');
        self.printTree(root.left);
        self.printTree(root.right);
        
if __name__ == '__main__':
    root = TreeNode(1);
    root.left = TreeNode(2);
    root.right = TreeNode(2);
    root.left.left = TreeNode(4);
    root.left.right = TreeNode(5);
    root.right.left = TreeNode(5);
    root.right.right = TreeNode(4);
    
    sol = Solution();
    print (sol.isSymmetric(root));
    
    