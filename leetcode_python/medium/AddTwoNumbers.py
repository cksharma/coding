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
    # @return a ListNode
    def addTwoNumbers(self, l1, l2):
        ans = l1;
        if l1 == None and l2 == None:
            return None;
        if l1 == None:
            return l2;
        if l2 == None:
            return l1;
        
        carry = 0;
        temp1 = l1;
        while l1 != None and l2 != None:
            __sum = l1.val + carry + l2.val;
            carry = int(__sum / 10);
            l1.val = __sum % 10;
            l1 = l1.next;
            l2 = l2.next;
        while l1 != None:
            __sum = l1.val + carry;
            carry = int(__sum / 10);
            l1.val = __sum % 10;
            l1 = l1.next;
        
        temp2 = l2;
        while l2 != None:
            __sum = l2.val + carry;
            carry = int(__sum / 10);
            l2.val = __sum % 10;
            l2 = l2.next;
        
        while temp1.next != None:
            temp1 = temp1.next;
        temp1.next = temp2;
        
        while temp1.next != None:
            temp1 = temp1.next;
        if carry == 1:
            temp1.next = ListNode(1);        
        return ans;
    
    def printLinkedList(self, head):
        while head != None:
            print (head.val, end=' => ');
            head = head.next;
if __name__ == '__main__':
    num1 = ListNode(2);
    num1.next = ListNode(4);
    num1.next.next = ListNode(3);
    
    num2 = ListNode(5);
    #num2.next = ListNode(6);
    #num2.next.next = ListNode(4);
    
    sol = Solution();
    head = sol.addTwoNumbers(num1, num2);
    sol.printLinkedList(head);