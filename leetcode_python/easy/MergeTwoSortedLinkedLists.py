'''
Created on Dec 24, 2014

@author: Chandra Kant
'''
# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # @param two ListNodes
    # @return a ListNode
    def mergeTwoLists(self, l1, l2):
        if l1 == None and l2 == None:
            return None;
        if l1 == None:
            return l2;
        if l2 == None:
            return l1;
        
        prev = None;
        if l1.val <= l2.val:
            temp = l1.next;
            prev = l1;
            l1.next = None;
            l1 = temp;
        else:
            temp = l2.next;
            prev = l2;
            l2.next = None;
            l2 = temp;
        ans = prev;
        
        while l1 != None and l2 != None:
            if l1.val <= l2.val:
                temp = l1.next;
                prev.next = l1;
                l1.next = None;
                l1 = temp;
            else:
                temp = l2.next;
                prev.next = l2;
                l2.next = None;
                l2 = temp;
            prev = prev.next;              
        if l1 != None:
            prev.next = l1;
        if l2 != None:
            prev.next = l2;        
        return ans;
    def printLinkedList(self, head):
        while head != None:
            print (head.val, end=' => ');
            head = head.next;
if __name__ == '__main__':
    sol = Solution();
    l1 = ListNode(3); l1.next = ListNode(3); l1.next.next = ListNode(5);
    l2 = ListNode(2); l2.next = ListNode(4); l2.next.next = ListNode(6);
    l2.next.next.next = ListNode(8)
    l1 = (sol.mergeTwoLists(l1, l2));
    sol.printLinkedList(l1);