package hard;

/**
 * Created by cksharma on 12/15/15.
 */
public class ReverseNodesInKGroup {
    public ListNode[] reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        ListNode[] ans = new ListNode[2];
        ans[0] = prev;
        ans[1] = head;
        return ans;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null || k < 2) return head;

        ListNode ans = head;
        ListNode prev = null;
        ListNode current = head;

        int total = k;
        while (current != null) {
            k--;
            ListNode temp = current.next;
            if (k == 0) {
                current.next = null;
                ListNode[] arr = reverseList(head);
                //printList(arr[0]);
                ListNode reversedNode = arr[0];
                ListNode tail = arr[1];

                if (prev == null) {
                    ans = reversedNode;
                    prev = tail;
                    tail.next = temp;
                }
                else {
                    prev.next = reversedNode;
                    prev = tail;
                    tail.next = temp;
                }
                head = tail.next;
                k = total;
            }
            current = temp;
        }

        return ans;
    }

    private void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int k = 6;

        ReverseNodesInKGroup sol = new ReverseNodesInKGroup();
        ListNode node = sol.reverseKGroup(head, k);
        sol.printList(node);


    }
}
