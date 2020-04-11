package medium;

public class SwapNodesInPairs {
    
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode ans = head.next;
		ListNode prev = null;
		ListNode next = null;
		
		while (head != null) {			
			if (head.next != null) {
				next = head.next.next;
			} else {
				break;
			}
			if (prev != null) {
				prev.next = head.next;	
			}  
			prev = head;
			ListNode temp = head.next;
			head.next = next;
			temp.next = head;
			
			head = next;
		}
		return ans;
    }
    private void printLinkedList(ListNode head) {
    	while (head != null) {
    		System.out.print(head.val + " ==> ");
    		head = head.next;
    	}
    	System.out.println();
    }
	public static void main(String[] args) {
		SwapNodesInPairs sol = new SwapNodesInPairs();
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		//head.next.next = new ListNode(3);
		//head.next.next.next = new ListNode(4);
		//head.next.next.next.next = new ListNode(5);
		//head.next.next.next.next.next = new ListNode(6);
		head = sol.swapPairs(head);
		
		sol.printLinkedList(head);
	}
}
