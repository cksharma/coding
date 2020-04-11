package medium;

public class InsertionSortList {
    
	public ListNode insertionSortList(ListNode head) {
		ListNode ans = null;
		ListNode k = null;
		while (head != null) {
			ListNode minNode = head;
			ListNode temp = head;
			ListNode prev = null;
			ListNode next = head.next;
			
			ListNode old = null;
			while (temp != null) {				
				if (temp.val < minNode.val) {
					prev = old;
					minNode = temp;
					next = temp.next;
				}				
				old = temp;
				temp = temp.next;
			}
			if (prev != null) {
				prev.next = next;
			} else {
				head = head.next;
			}
			if (ans == null) {
				ans = new ListNode(minNode.val);
				k = ans;
			}
			else {
				ans.next = new ListNode(minNode.val);
				ans = ans.next;
			}	
		}
		return k;
    }

	private void printLinkedList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " ==> ");
			head = head.next;
		}
		System.out.println();
	}

    public static void main(String[] args) {
		InsertionSortList sol = new InsertionSortList();
    	
    	ListNode head = new ListNode(3);
		head.next = new ListNode(4);
		head.next.next = new ListNode(5);
		head = sol.insertionSortList(head);
		sol.printLinkedList(head);
	}
}
