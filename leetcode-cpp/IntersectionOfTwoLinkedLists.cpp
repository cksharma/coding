#include "header.h"

int getLength(ListNode* head) {
	int ans = 0;
	while (head != NULL) {
		ans++;
		head = head->next;
	}
	return ans;
}

ListNode* computeIntersectionPoint(int diff, ListNode* headA, ListNode* headB) {
	ListNode* ans = NULL;
	if (diff < 0) {
		while (diff++ != 0) {
			headB = headB->next;
		}
	}
	else {
		while (diff-- != 0) {
			headA = headA->next;
		}
	}
	while (headA != NULL && headB != NULL) {
		if (headA == headB) {
			ans = headA;
			break;
		}
		headA = headA->next;
		headB = headB->next;
	}
	return ans;
}

ListNode* IntersectionOfTwoLinkedLists::getIntersectionNode(ListNode *headA, ListNode *headB) {
	int len1 = getLength(headA);
	int len2 = getLength(headB);

	ListNode* node = NULL;
	node = computeIntersectionPoint(len1 - len2, headA, headB);
	return node;
}



