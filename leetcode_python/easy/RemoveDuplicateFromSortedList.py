'''
Created on Dec 23, 2014

@author: Chandra Kant
'''
# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None
    def __str__(self):
        node = self;
        ss = '';
        while node != None:
            ss = ss + str(node.val) + ' => ';
            node = node.next;
        return ss;
class Solution:
    # @param head, a ListNode
    # @return a ListNode
    def deleteDuplicates(self, head):
        if head == None or head.next == None:
            return head;
        prev = head;
        curr = head.next;
        while curr != None :
            if curr.val == prev.val:
                prev.next = curr.next;
                curr = curr.next;
            else:
                prev = prev.next;
                curr = curr.next;
        return head;
    
if __name__ == '__main__':
    sol = Solution();
    
    head = ListNode(1);
    head.next = ListNode(2);
    head.next.next = ListNode(2);
    head.next.next.next = ListNode(3);
    head.next.next.next.next = ListNode(3);
    head.next.next.next.next.next = ListNode(4);
    head = sol.deleteDuplicates(head);
    print(head);
    