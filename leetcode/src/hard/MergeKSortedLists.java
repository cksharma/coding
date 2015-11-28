package hard;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by cksharma on 11/26/15.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class MergeKSortedLists {
    static class MyComparator implements Comparator<ListNode> {

        @Override
        public int compare(ListNode o1, ListNode o2) {
            if (o1.val < o2.val) return -1;
            return 1;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        Queue<ListNode> queue = new PriorityQueue<ListNode>(new MyComparator());
        for (ListNode node : lists) {
            while (node != null) {
                queue.add(node);
                node = node.next;
            }
        }

        ListNode prev = queue.poll();
        ListNode head = prev;

        while (queue.isEmpty() == false) {
            ListNode curNode = queue.poll();
            prev.next = curNode;
            prev = curNode;
            prev.next = null;
        }
        return head;
    }

    private static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        MergeKSortedLists sol = new MergeKSortedLists();
        ListNode[] lists = new ListNode[2];

        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(3);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        node1.next.next.next.next = new ListNode(5);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(4);
        node2.next.next = new ListNode(5);
        node2.next.next.next = new ListNode(6);
        node2.next.next.next.next = new ListNode(7);

        lists[0] = node1;
        lists[1] = node2;

        ListNode head = sol.mergeKLists(lists);
        printList(head);
    }
}
