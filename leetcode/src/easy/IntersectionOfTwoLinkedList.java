package easy;
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
	public String toString() {
		ListNode ans = this;
		StringBuilder sb = new StringBuilder();
		while (ans != null) {
			sb.append(ans.val + "->");
			ans = ans.next;
		}
		return sb.toString();
	}
}

public class IntersectionOfTwoLinkedList {

	private int getLength(ListNode head) {
		int ans = 0;
		while (head != null) {
			ans++;
			head = head.next;
		}
		return ans;
	}
	
	private ListNode computeIntersectionPoint(int diff, ListNode headA, ListNode headB) {
		ListNode ans = null;
		if (diff < 0) {
			while (diff++ != 0) {
				headB = headB.next;
			}
		} else {
			while (diff-- != 0) {
				headA = headA.next;
			}
		}
		while (headA != null && headB != null) {
			if (headA == headB) {
				ans = headA;
				break;
			}
			headA = headA.next;
			headB = headB.next;
		}
		return ans;
	}
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int len1 = getLength(headA);
		int len2 = getLength(headB);
		
		ListNode node = null;
		node = computeIntersectionPoint(len1 - len2, headA, headB);
		return node;
	}

	public static void main(String[] args) {
		
	}
}