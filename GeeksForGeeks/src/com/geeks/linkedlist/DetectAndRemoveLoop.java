package com.geeks.linkedlist;

public class DetectAndRemoveLoop {
    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = two;
        boolean hasLoop = detectLoop(one);
        System.out.println(hasLoop);
        
        if (!hasLoop) return;
        
        one = removeLoop(one);
        printLinkedList(one);
    }


    public static Node removeLoop(Node head) {
        Node fast = head;
        Node slow = head;
        while (true) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) 
                break;
        }
        int loopSize = 0;
        while(slow != fast || loopSize == 0) {
            slow = slow.next;
            loopSize++;
        }
        
        Node front = head; 
        while (--loopSize >= 0) {
            front = front.next;    
        }
        Node back = head;
        
        while (front != back) {
           if (back.next == front.next) {
        	   front.next = null;
        	   break;
           }
           front = front.next;
           back = back.next;
        }    
        return head;
    }

    public static boolean detectLoop(Node head) {
        Node rabbit = head;
        Node tortoise = head;
        
        while(rabbit != null) {
            if (rabbit.next == null) {
                return false;
            }
            rabbit = rabbit.next.next;
            tortoise = tortoise.next;
            if (rabbit == tortoise) return true;
        }
        return false;
    }

    public static void printLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }  
}

