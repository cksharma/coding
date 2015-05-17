#include "header.h"

ListNode* RemoveNthElementFromLast::removeNthFromEnd(ListNode *head, int n) {
	ListNode* ans = head;
	ListNode* forw = head;
	ListNode* back = head;
	for (int i = 0; i < n; i++)
		forw = forw->next;
	if (forw == NULL)
		return back->next;
	while (forw->next != NULL) {
		forw = forw->next;
		back = back->next;
	}
	back->next = back->next->next;
	return ans;
}

