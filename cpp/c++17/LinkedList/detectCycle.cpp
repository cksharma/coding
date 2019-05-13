#include <bits/stdc++.h>
using namespace std;
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};
 
class Solution {
public:
    ListNode* detectCycle(ListNode* head) {
        ListNode* ans = head;
        ListNode* slow = head;
        ListNode* fast = head;
        while (fast != NULL && fast->next != NULL) {
            fast = fast->next->next;
            slow = slow->next;
            if (fast == slow) {
                ListNode* startLoop = head;
                while (startLoop != slow) {
                    startLoop = startLoop->next;
                    slow = slow->next;
                }
                return startLoop;        
            }
        }
        return NULL;
    }
};

ListNode* createLinkedList() {
    ListNode* head = new ListNode(1);

    head->next = new ListNode(2);
    head->next->next = new ListNode(3);
    //cout << "first " << endl;

    head->next->next->next = new ListNode(4);
    ListNode* loop = head->next->next->next;

    head->next->next->next->next = new ListNode(5);
    head->next->next->next->next->next = new ListNode(6);

    head->next->next->next->next->next->next = new ListNode(7);
    head->next->next->next->next->next->next->next = loop;
    return head;
}

int main() {
    ListNode* head = createLinkedList();
    Solution sol;
    ListNode* ans = sol.detectCycle(head);
    cout << ans->val << endl;

}