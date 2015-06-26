#include <bits/stdc++.h>
using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:

    ListNode* first;
    ListNode* secon;

    ListNode* getMiddleVal(ListNode* head) {
        ListNode* slow = head;
        ListNode* fast = head;
        while (fast != NULL && fast->next != NULL) {
            fast = fast->next->next;
            if (fast != NULL)
                slow = slow->next;    
        }
        cout << "before assign " << endl;
        first = head;
        secon = slow->next;
        slow->next = NULL;
        cout << "after ssign " << endl;
        return slow;
    }

    ListNode* reverse(ListNode* head) {
    	ListNode* prev = NULL;
    	
    	while (head != NULL) {
    		ListNode* temp = head->next;
    		head->next = prev;
    		prev = head;
    		head = temp;
    	}
    	return prev;
    }

    void reorderList(ListNode* head) {
    	if (head == NULL || head->next == NULL || head->next->next == NULL) return;
        getMiddleVal(head);
        secon = reverse(secon);
    	while (first != NULL && secon != NULL) {        
	        ListNode* temp1 = first->next;
	        first->next = secon;
	        ListNode* temp2 = secon->next;
	        secon->next = temp1;
	        first = temp1;
	        secon = temp2;
    	}    	
    }
    void printList(ListNode* head) {
 	   while (head != NULL) {
    	    cout << head->val << " ";
        	head = head->next;
    	}
    	cout << endl;	
	}
};

int main() {
    ListNode* head = new ListNode(1);

    head->next = new ListNode(2);
    head->next->next = new ListNode(3);
    cout << "first " << endl;
    head->next->next->next = new ListNode(4);
    head->next->next->next->next = new ListNode(5);
    head->next->next->next->next->next = new ListNode(6);

    head->next->next->next->next->next->next = new ListNode(7);
    cout << "came here" << endl;
    Solution sol;

    sol.reorderList(head);
    //head = sol.reverse(head);
    sol.printList(head);
    //sol.reorderList(head);
    //printList(head);   
}
