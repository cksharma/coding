package medium;

public class SortList {
	public ListNode sortList(ListNode head) {
		return mergeSort(head);
	}

	private ListNode mergeSort(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode temp = head;
		int cnt = 0;
		while (temp != null) {
			cnt++;
			temp = temp.next;
		}	
		int middle = cnt / 2;
		ListNode l = head;
		ListNode r = null;

		temp = head;
		while (middle-- > 1) {
			temp = temp.next;
		}
		r = temp.next;
		temp.next = null;
		ListNode l1 = mergeSort(l);
		ListNode r1 = mergeSort(r);
		return mergeList(l1, r1);	
	}
	
	private ListNode mergeList(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null)
			return null;
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode ans = null;
		ListNode res = null;
		while (l1 != null && l2 != null) {
			int min = Math.min(l1.val, l2.val);
			if (ans == null) {
				ans = new ListNode(min);
				res = ans;
			} else {
				ans.next = new ListNode(min);
				ans = ans.next;
			}
			if (l1.val == min)
				l1 = l1.next;
			else
				l2 = l2.next;
		}
		while (l1 != null) {
			ans.next = new ListNode(l1.val);
			l1 = l1.next;
			ans = ans.next;
		}
		while (l2 != null) {
			ans.next = new ListNode(l2.val);
			l2 = l2.next;
			ans = ans.next;
		}
		return res;
	}

	public static void main(String[] args) {
		SortList sol = new SortList();
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(4);

		ListNode n4 = new ListNode(8);
		ListNode n5 = new ListNode(7);
		ListNode n6 = new ListNode(6);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;

		n1 = sol.sortList(n1);

		printList(n1);
	}

	public static void printList(ListNode x) {
		while (x != null) {
			System.out.print(x.val + " ");
			x = x.next;			
		}
		System.out.println();

	}
}
