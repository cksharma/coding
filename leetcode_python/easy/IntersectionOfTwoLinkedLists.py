'''
Created on Dec 20, 2014

@author: Chandra Kant
'''
# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
 
    def getLength(self, head):
        ans = 0;
        while head != None:
            ans = ans + 1;
            head = head.next;
        return ans;
    
    def computeIntersectionPoint(self, diff, headA, headB) :
        ans = None;
        if diff < 0:
            while diff != 0 :
                diff = diff + 1; 
                headB = headB.next;
        else :
            while diff != 0 :
                diff = diff - 1;
                headA = headA.next;
                
        while headA != None and headB != None:
            if headA == headB :
                ans = headA;
                break;
            headA = headA.next;
            headB = headB.next;
        return ans;
    # @param two ListNodes
    # @return the intersected ListNode
    def getIntersectionNode(self, headA, headB):
        len1 = self.getLength(headA);
        len2 = self.getLength(headB);
        node = self.computeIntersectionPoint(len1 - len2, headA, headB);
        return node;
if __name__ == '__main__':
    sol = Solution();

    nodeA = ListNode(1);
    nodeA.next = ListNode(2);
    nodeA.next.next = ListNode(3);

    nodeB = ListNode(4);
    nodeB.next = nodeA;

    ans = sol.getIntersectionNode(nodeA, nodeB);
    
    while ans != None :
        print(ans.val, end=" ==> ");
        ans = ans.next; 
    
    