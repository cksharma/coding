'''
Created on Dec 26, 2014

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
        self.ans = "0";
    # @param root, a tree node
    # @return an integer
    def sumNumbers(self, root):
        self.recurse(root, "0");
        return int(self.ans);
    
    def recurse(self, root, ss):
        if root == None:
            #self.ans = "0";
            return self.ans;
        if root.left == None and root.right == None:
            self.ans = self.addStrings(self.ans, ss + str(root.val));
            return self.ans;
        self.recurse(root.left, ss + str(root.val));
        self.recurse(root.right, ss + str(root.val));       
        
    def addStrings(self, s1, s2):
        if s1 == None and s2 == None:
            return "0";
        if s1 == None:
            return s2;
        if s2 == None:
            return s1;
        l1 = len(s1) - 1;
        l2 = len(s2) - 1;
        
        carry = 0;
        ss = "";
        while l1 >= 0 and l2 >= 0:
            __sum = int(s1[l1]) + carry + int(s2[l2]);
            md = __sum % 10;
            carry = int(__sum / 10);
            ss = ss + str(md);
            l1 = l1 - 1;
            l2 = l2 - 1;
        
        while l1 >= 0:
            __sum = int(s1[l1]) + carry;
            md = __sum % 10;
            carry = int(__sum / 10);
            ss = ss + str(md);
            l1 = l1 - 1;
        
        while l2 >= 0:
            __sum = int(s2[l2]) + carry;
            md = __sum % 10;
            carry = int(__sum / 10);
            ss = ss + str(md);
            l2 = l2 - 1;
        if carry != 0:
            ss = str(carry) + ss;
        return ss[::-1];
if __name__ == '__main__':
    sol = Solution();
    #print (sol.addStrings("12", "3090"));
    root = TreeNode(0);
    root.left = TreeNode(1);
    #root.right = TreeNode(3);
    #print (sol.sumNumbers(root));
    print (sol.sumNumbers(root));