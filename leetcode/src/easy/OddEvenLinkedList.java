package easy;

/**
 * Created by cksharma on 1/19/16.
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode tail = new ListNode(-10);
        ListNode fixedTail = tail;

        ListNode prev = new ListNode(-10);
        prev.next = head;
        ListNode slow = head;

        while (slow != null) {
            ListNode temp = slow.next;
            if (slow.val % 2 == 0) {
                prev.next = temp;
                slow.next = null;
                tail.next = slow;
                tail = slow;
            } else {
                prev = slow;
            }
            slow = temp;
        }
        prev.next = fixedTail.next;
        return head;
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        OddEvenLinkedList list = new OddEvenLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        list.oddEvenList(head);
        printList(head);
    }
}
