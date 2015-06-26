#include <bits/stdc++.h>
using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

ListNode* reverseList(ListNode* head) {
        if (head == NULL) return NULL;
        ListNode* prev = NULL;
        ListNode* ans = head;
        
        while (head->next != NULL) {
            ListNode *temp = head->next;
            head->next = prev;
            prev = head;            
            head = temp;
        }
        head->next = prev;
        return head;
}

void printListNode(ListNode* head) {
    while (head != NULL) {
        cout << head->val << " ";    
        head = head->next;
    }
    cout << endl;
}

int main() {
    ListNode* head = new ListNode(1);
    //head->next = new ListNode(2);

    ListNode* head1 = reverseList(head);
    printListNode(head1);
}
