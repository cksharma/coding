package medium;

public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode ans = null;
        ListNode cks = null;
        while (current != null) {
            if (prev == null && current.next == null) {
                ans = current;
                cks = ans;
            } else if (prev == null && current.next != null && current.next.val != current.val) {
                ans = current;
                cks = ans;
            } else if (prev != null && current.next == null && current.val != prev.val) {
                if (ans == null) {
                    ans = current;
                    cks = ans;
                }
                else {
                    ans.next = current;
                    ans = ans.next;
                }
            } else if (prev != null && current.next != null && current.val != prev.val && current.next.val != current.val) {
                if (ans == null) {
                    ans = current;
                    cks = ans;
                }
                else {
                    ans.next = current;
                    ans = ans.next;
                }
            }
            prev = current;
            current = current.next;
        }
        if (ans != null)
            ans.next = null;
        return cks;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(4);
        node.next.next.next.next.next = new ListNode(4);
        node.next.next.next.next.next.next = new ListNode(5);
        RemoveDuplicatesFromSortedListII sol = new RemoveDuplicatesFromSortedListII();
        printList(sol.deleteDuplicates(node));

        node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(4);
        node.next.next.next.next.next = new ListNode(4);
        node.next.next.next.next.next.next = new ListNode(5);
        sol = new RemoveDuplicatesFromSortedListII();
        printList(sol.deleteDuplicates(node));

        node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        sol = new RemoveDuplicatesFromSortedListII();
        printList(sol.deleteDuplicates(node));

        node = new ListNode(1);
        sol = new RemoveDuplicatesFromSortedListII();
        printList(sol.deleteDuplicates(node));
    }
    private static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println();
    }
}
