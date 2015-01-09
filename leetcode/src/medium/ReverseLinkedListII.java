package medium;

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode prev = null;
        ListNode last = null;        
        ListNode node = head;
        ListNode start = head;
        
        //finding prev node (m - 1)th
        for (int i = 1; i < m; i++) {
        	prev = node;
        	node = node.next; 
        	start = node;
        }
        
        //finding last node (n + 1)th
        for (int i = 1; i <= n - m + 1; i++) {
        	node = node.next;
        	last = node;
        }
        
        ListNode temp = start;
        ListNode old = null;
        for (int i = 1; i <= n - m + 1; i++) {
        	temp = start.next;
        	if (old == null) {
        		start.next = last;
        	} else {
        		start.next = old;
        	}
        	old = start;
        	start = temp;
        }
        if (prev != null) prev.next = old;
        else head = old;
        return head;
    }
    private void printLinkedList(ListNode head) {
    	while (head != null) {
    		System.out.print(head.val + " ==> ");
    		head = head.next;
    	}
    	System.out.println();
    }
    
    public static void main(String[] args) {
		ReverseLinkedListII sol = new ReverseLinkedListII();
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head = sol.reverseBetween(head, 1, 5);
		sol.printLinkedList(head);
		
		head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head = sol.reverseBetween(head, 1, 1);
		sol.printLinkedList(head);
		
		head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head = sol.reverseBetween(head, 6, 6);
		sol.printLinkedList(head);
		
		head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head = sol.reverseBetween(head, 1, 6);
		sol.printLinkedList(head);
	}
}
