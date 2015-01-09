'''
Created on Jan 1, 2015

@author: Chandra Kant
'''
# Definition for a  binary tree node
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
        self.next = None
    def __str__(self):
        return str(self.val);
class Solution:
    # @param root, a tree node
    # @return nothing
    def connect(self, root):
        self.recurse(root, None, False);
    
    def recurse(self, root, parent, is_left):
        if root == None:
            return;
        if is_left and parent != None:
            root.next = parent.right;
        if not is_left and parent != None and parent.next != None:
            root.next = parent.next.left;
        self.recurse(root.left, root, True);
        self.recurse(root.right, root, False);
    
    def inorder(self, root):
        if root == None:
            return;
        print (str(root.val) + " => " + str(root.next));
        self.inorder(root.left);
        self.inorder(root.right);
if __name__ == '__main__':
    sol = Solution();
    root = TreeNode(1);
    root.left = TreeNode(2);
    root.right = TreeNode(3);
    root.left.left = TreeNode(4);
    root.left.right = TreeNode(5);
    root.right.left = TreeNode(6);
    root.right.right = TreeNode(7);
    
    sol.connect(root);
    sol.inorder(root);