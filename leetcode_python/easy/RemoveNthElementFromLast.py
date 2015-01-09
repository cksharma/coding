'''
Created on Dec 21, 2014

@author: Chandra Kant
'''
# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # @return a ListNode
    def removeNthFromEnd(self, head, n):
        ans = head;
        forw = head;
        back = head;
        i = 0;
        while i < n:
            forw = forw.next;
            i = i + 1;
        if forw == None:
            return back.next;
        while forw.next != None:
            forw = forw.next;
            back = back.next;
        back.next = back.next.next;       
        return ans;

def printList(head):
    while head != None:
        print(head.val, end=' => ');
        head = head.next;
        
if __name__ == '__main__':
    sol = Solution();
    list1 = ListNode(1);
    list1.next = ListNode(2);
    list1.next.next = ListNode(3);
    list1.next.next.next = ListNode(4);
    
    list1 = sol.removeNthFromEnd(list1, 2);
    
    printList(list1);