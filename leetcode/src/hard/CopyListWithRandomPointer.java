package hard;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cksharma on 12/14/15.
 */

class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
}

public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;

        int headVal = head.label;
        RandomListNode original = head;

        Map<Integer, RandomListNode> map = new HashMap<>();
        while (original != null) {
            int val = original.label;
            map.put(val, new RandomListNode(val));
            original = original.next;
        }

        while (head != null) {
            if (head.random != null) {
                int nodeVal   = head.label;
                int randomVal = head.random.label;
                map.get(nodeVal).random = map.get(randomVal);
            }
            if (head.next != null) {
                int nodeVal = head.label;
                int nextVal = head.next.label;
                map.get(nodeVal).next = map.get(nextVal);
            }
            head = head.next;
        }

        return map.get(headVal);
    }

    private void printNode(RandomListNode head) {
        while (head != null) {
            System.out.println("val: " + head.label + "  random: " + (head.random != null ? head.random.label : null));
            head = head.next;
        }
    }

    public static void main(String[] args) {
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        RandomListNode node4 = new RandomListNode(4);
        RandomListNode node5 = new RandomListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        node1.random = node4;
        node2.random = node4;
        node3.random = node1;
        node4.random = null;
        node5.random = node3;

        CopyListWithRandomPointer solution = new CopyListWithRandomPointer();

        solution.printNode(node1);
        System.out.println();

        RandomListNode randomHead = solution.copyRandomList(node1);
        solution.printNode(randomHead);

    }

}
