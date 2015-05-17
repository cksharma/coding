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
    def __init__(self):
        self.mp = {};
        
    def levelOrder1(self, root, height):
        if root == None:
            return {};
        if height not in self.mp:
            self.mp[height] = [];
        arr = self.mp[height];
        arr.append(root.val);
        self.mp[height] = arr;
        self.levelOrder1(root.left, height + 1);
        self.levelOrder1(root.right, height + 1);
        return self.mp;
    # @param root, a tree node
    # @return a list of lists of integers
    def levelOrder(self, root):
        mp = self.levelOrder1(root, 1);
        arr = [[]];
        for key in (sorted(mp)):
            arr.append(mp[key]);
        return arr[1:];
if __name__ == '__main__':    
    root = TreeNode(1);
    root.left = TreeNode(2);
    root.right = TreeNode(3);
    root.left.left = TreeNode(4);
    root.left.right = TreeNode(5);
    
    sol = Solution();
    print (sol.levelOrder(root));